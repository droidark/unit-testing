package xyz.krakenkat.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.krakenkat.unittesting.model.Item;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return Item.builder()
                .id(1)
                .name("Ball")
                .price(10)
                .quantity(100)
                .build();
    }
}
