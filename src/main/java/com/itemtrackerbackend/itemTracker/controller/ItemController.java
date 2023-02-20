package com.itemtrackerbackend.itemTracker.controller;

import com.itemtrackerbackend.itemTracker.models.jpa.ItemJPA;
import com.itemtrackerbackend.itemTracker.service.ItemService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    @RequestMapping(value = "/GetItems", method = RequestMethod.GET)
    public List<ItemJPA> getItems(){
        return itemService.getAll();
    }

    @GetMapping()
    @RequestMapping(value = "/GetItem/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemJPA> getItemById(@RequestParam(name = "id") String id) throws Exception {
        return itemService.getById(id);
    }

    @PutMapping()
    @RequestMapping(value = "/DeleteById/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> deleteById(@RequestParam(name = "id") String id){
        return itemService.deleteById(id);
    }

    @PostMapping()
    @RequestMapping(value = "/CreateItem", method = RequestMethod.POST)
    public ResponseEntity<ItemJPA> createItem(@RequestBody ItemJPA itemJPA){
        return itemService.createItem(itemJPA);
    }


}
