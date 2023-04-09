package xyz.krakenkat.unittesting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import xyz.krakenkat.unittesting.model.Item;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(1001, items.get(0).getId());
    }
}
