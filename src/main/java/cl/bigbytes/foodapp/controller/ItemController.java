package cl.bigbytes.foodapp.controller;
import cl.bigbytes.foodapp.domain.Item;
import cl.bigbytes.foodapp.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j

public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/items")
    public ResponseEntity<Item> create(@RequestBody Item item) {
        try {
            Item savedItem = itemService.saveItem(item);
            return ResponseEntity.ok(savedItem);
        } catch (Exception ex) {
            log.error("Error while creating the item:", ex);
            return ResponseEntity.status(500).build();
        }
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

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @RequestBody Item item) {
        try {
            item.setId(id);
            Item updatedItem = itemService.updateItem(item);
            return ResponseEntity.ok(updatedItem);
        } catch (Exception ex) {
            log.error("Error while updating the item:", ex);
            return ResponseEntity.status(500).build();
        }
    }
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            itemService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            log.error("Error while deleting the item:", ex);
            return ResponseEntity.status(500).build();
        }
    }

   
}

