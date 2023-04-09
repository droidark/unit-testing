package xyz.krakenkat.unittesting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.krakenkat.unittesting.model.Item;
import xyz.krakenkat.unittesting.service.ItemBusinessService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return Item.builder()
                .id(1)
                .name("Ball")
                .price(10)
                .quantity(100)
                .build();
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.getHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return itemBusinessService.getAllItems();
    }
}
