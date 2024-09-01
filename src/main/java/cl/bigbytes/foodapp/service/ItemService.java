package cl.bigbytes.foodapp.service;

import cl.bigbytes.foodapp.domain.Item;
import cl.bigbytes.foodapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    //private ItemRepository itemRepository;
    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
    public Item getItem(Integer id) {
        return itemRepository.getItem(id);
    }
    public Item updateItem(Item item) {return itemRepository.save(item);}
    public void deleteItem(Integer id){itemRepository.deleteItem(id);}






    }





