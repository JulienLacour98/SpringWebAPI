package com.netcompany.springwebapi.controller;

import java.util.List;

import com.netcompany.springwebapi.entity.ItemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netcompany.springwebapi.entity.Item;
import com.netcompany.springwebapi.service.ItemService;
import com.netcompany.springwebapi.service.ItemListService;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    ItemListService itemListService;

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("itemList/{itemListId}/items")
    public List<Item> getAllItemsByItemListId(@PathVariable("itemListId") int itemListId){
        return itemService.getAllItemsByItemListId(itemListId);
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("/item/{id}")
    public void deleteItemList(@PathVariable("id") int id) {
        itemService.deleteItemById(id);
    }

    @PostMapping("/itemList/{itemListId}/item")
    public void addItemList(@PathVariable("itemListId") int itemListId, @RequestBody Item item) {
        ItemList itemList = itemListService.getItemListById(itemListId);
        item.setItemList(itemList);
        itemService.saveOrUpdate(item);
    }

    @PutMapping("/itemList/{itemListId}/item")
    public void updateItem(@PathVariable("itemListId") int itemListId, @RequestBody Item item) {
        ItemList itemList = itemListService.getItemListById(itemListId);
        item.setItemList(itemList);
        itemService.saveOrUpdate(item);
    }
}
