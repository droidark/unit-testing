package xyz.krakenkat.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.krakenkat.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
