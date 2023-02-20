package com.itemtrackerbackend.itemTracker.service;

import com.itemtrackerbackend.itemTracker.models.ItemResponse;
import com.itemtrackerbackend.itemTracker.models.jpa.ItemJPA;
import com.itemtrackerbackend.itemTracker.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemJPA> getAll(){
        List<ItemJPA> itemJPAList = new ArrayList<>();

        try {
            Iterable<ItemJPA> itemJPAIterable = itemRepository.findAll();
            itemJPAIterable.forEach(itemJPAList::add);
        } catch (Exception e){
            LOGGER.error("Not found {}", e.getMessage());
        }
        return itemJPAList;
    }

    public ResponseEntity<ItemJPA> getById(String id) throws Exception {
        Optional<ItemJPA> optionalItemJPA = itemRepository.findById(Long.valueOf(id));
        ItemJPA itemJPA =optionalItemJPA.orElseThrow(() -> new NotFoundException("Not found id"));
        return new ResponseEntity<>(itemJPA, HttpStatus.OK);
    }

    public ResponseEntity deleteById(String id){
        try{
            Optional<ItemJPA> optionalItemJPA = itemRepository.findById(Long.valueOf(id));
            ItemJPA itemJPA = optionalItemJPA.orElseThrow(() -> new NotFoundException("Not found id"));
            itemJPA.setStatus("OFF");
            itemRepository.save(itemJPA);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            LOGGER.error("Error to delete: {}", e.getCause());
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<ItemJPA> createItem(ItemJPA itemJPA){
        try{
            itemRepository.save(itemJPA);
            LOGGER.info("Create item: {}", itemJPA);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            LOGGER.error("Error to create: {}", e.getCause());
            return ResponseEntity.badRequest().build();
        }
    }
}
