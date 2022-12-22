package com.netcompany.springwebapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcompany.springwebapi.entity.Item;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByItemListId(int itemListId);

}
