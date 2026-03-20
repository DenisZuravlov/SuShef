package com.SuShef.backend.inventory.service;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class ItemService {

    protected NoSuchElementException notFound(String type, long id){ // throws an exception if the item is not found
        throw new NoSuchElementException(type + " with id " + id + " not found");
    }

    protected void updateItem(Item target, Item update){ // used both in ingredient and appliance to update common fields
        target.setUserId(update.getUserId());
        target.setName(update.getName());
        target.setDescription(update.getDescription());
        target.setDateUpdated(LocalDate.now());
    }





}
