package com.netcompany.springwebapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcompany.springwebapi.entity.ItemList;
import com.netcompany.springwebapi.service.ItemListService;

@RestController
@RequestMapping(path = "/api")
public class ItemListController {

    @Autowired
    ItemListService itemListService;

    @GetMapping("/itemLists")
    public List<ItemList> getAllItemLists(){
        return itemListService.getAllItemLists();
    }

    @GetMapping("/itemList/{id}")
    public ItemList getItemList(@PathVariable("id") int id) {
        return itemListService.getItemListById(id);
    }

    @DeleteMapping("/itemList/{id}")
    public void deleteItemList(@PathVariable("id") int id) {
        itemListService.deleteItemListById(id);
    }

    @PostMapping("/itemList")
    public void addItemList(@RequestBody ItemList itemList) {
        itemListService.saveOrUpdate(itemList);
    }

    @PutMapping("/itemList")
    public void updateItemList(@RequestBody ItemList itemList) {
        itemListService.saveOrUpdate(itemList);
    }
}