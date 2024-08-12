package cl.bigbytes.foodapp.controller;

import cl.bigbytes.foodapp.domain.Item;
import cl.bigbytes.foodapp.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> get(@PathVariable Integer id) {
        try {
            var item = itemService.getItem(id);
            return ResponseEntity.ok(item);
        } catch ( Exception ex) {
            log.error("error while reading the user:", ex);
            return ResponseEntity.notFound().build();
        }
    }
}
