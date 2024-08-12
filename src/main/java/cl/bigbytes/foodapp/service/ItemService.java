package cl.bigbytes.foodapp.service;

import cl.bigbytes.foodapp.domain.Item;
import cl.bigbytes.foodapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem(Integer id) {
        return itemRepository.getItem(id);
    }

}
