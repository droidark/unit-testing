package xyz.krakenkat.unittesting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.krakenkat.unittesting.model.Item;
import xyz.krakenkat.unittesting.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemBusinessService {

    private final ItemRepository repository;

    public Item getHardcodedItem() {
        return Item.builder()
                .id(1)
                .name("Ball")
                .quantity(10)
                .price(100)
                .build();
    }

    public List<Item> getAllItems() {
        return repository
                .findAll()
                .stream()
                .map(item -> {
                    item.setValue(item.getPrice() * item.getQuantity());
                    return item;
                })
                .toList();
    }
}
