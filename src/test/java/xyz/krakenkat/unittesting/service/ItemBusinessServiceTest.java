package xyz.krakenkat.unittesting.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.krakenkat.unittesting.model.Item;
import xyz.krakenkat.unittesting.repository.ItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    private List<Item> items;

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemBusinessService itemBusinessService;

    @BeforeEach
    void initEach() {
        items = List.of(
                Item.builder().id(1).name("Item-1").quantity(10).price(100).build(),
                Item.builder().id(2).name("Item-2").quantity(20).price(40).build());
    }

    @Test
    void getHardcodedItem_basic() {
        // given
        Item expected = Item.builder()
                .id(1)
                .name("Ball")
                .quantity(10)
                .price(100)
                .build();

        // when
        Item actual = itemBusinessService.getHardcodedItem();


        // then
        assertEquals(expected.getId(), actual.getId());
    }

    @Test
    void getAllItems_basic() {
        // given
        int expectedOne = 1000, expectedTwo = 800;

        // when
        when(itemRepository.findAll()).thenReturn(items);
        List<Item> actual = itemBusinessService.getAllItems();

        // then
        assertEquals(expectedOne, actual.get(0).getValue());
        assertEquals(expectedTwo, actual.get(1).getValue());
    }
}