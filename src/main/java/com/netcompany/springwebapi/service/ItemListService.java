package com.netcompany.springwebapi.service;

import java.util.ArrayList;
import java.util.List;

import com.netcompany.springwebapi.entity.ItemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcompany.springwebapi.repository.ItemListRepository;

@Service
public class ItemListService {

    @Autowired
    ItemListRepository itemListRepository;

    public ItemList getItemListById(int id) {
        return itemListRepository.findById(id).get();
    }

    public List<ItemList> getAllItemLists(){
        List<ItemList> itemLists = new ArrayList<ItemList>();
        itemListRepository.findAll().forEach(itemList -> itemLists.add(itemList));
        return itemLists;
    }

    public void saveOrUpdate(ItemList itemList) {
        itemListRepository.save(itemList);
    }

    public void deleteItemListById(int id) {
        itemListRepository.deleteById(id);
    }
}
