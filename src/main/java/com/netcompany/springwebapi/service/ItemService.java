package com.netcompany.springwebapi.service;

import java.util.ArrayList;
import java.util.List;

import com.netcompany.springwebapi.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcompany.springwebapi.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item getItemById(int id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(item -> items.add(item));
        return items;
    }

    public List<Item> getAllItemsByItemListId(int itemListId){
        List<Item> items = new ArrayList<Item>();
        itemRepository.findByItemListId(itemListId).forEach(item -> items.add(item));
        return items;
    }

    public void saveOrUpdate(Item item) {
        itemRepository.save(item);
    }

    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }
}