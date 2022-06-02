package com.example.calometer.services;

import com.example.calometer.model.Item;
import com.example.calometer.payload.ItemDto;
import com.example.calometer.payload.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    void createItem(ItemDto itemDto, UserDto userDto);
   // void updateItem(ItemDto item,Integer id);
    List<ItemDto> getAllItems();

    ItemDto getItemById(Integer id);
    void deleteItem(Integer id);

}
