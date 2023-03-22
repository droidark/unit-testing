package xyz.krakenkat.unittesting.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Item {
    private int id;
    private String name;
    private int price;
    private int quantity;
}
