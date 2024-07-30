package cl.bigbytes.foodapp.controller;

import cl.bigbytes.foodapp.domain.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {


    @PostMapping("/items")
    public ResponseEntity<String> create(Item item) {
        return ResponseEntity.ok("Item created");
    }

    //get
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> get(@PathVariable Integer id) {
        var item = new Item();
        item.setName("completo italiano");
        item.setDescription("pancito, palta, tomate, mayo, vienesa");
        item.setPrice(1500.0);
        return ResponseEntity.ok(item);
    }

}
