package com.netcompany.springwebapi.repository;

import com.netcompany.springwebapi.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.netcompany.springwebapi.entity.ItemList;
@Repository
public interface ItemListRepository extends CrudRepository<ItemList, Integer> {


}
