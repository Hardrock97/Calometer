package com.example.calometer.services;

import com.example.calometer.exceptions.ResourceNotFoundException;
import com.example.calometer.model.Item;
import com.example.calometer.model.User;
import com.example.calometer.payload.ItemDto;
import com.example.calometer.payload.UserDto;
import com.example.calometer.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserService userService;
    @Override
    public void createItem(ItemDto itemDto, UserDto userDto) {
       // User user = userService.registerUser(userDto);
        //Item item = new Item(itemDto.getId(), itemDto.getCalories(), itemDto.getName(), itemDto.getRichIn(), itemDto.getDateFromLocalDate(), Arrays.asList(user));
        //Item item = dtoToItem(itemDto);
        Item item = dtoToItem(itemDto);
        this.itemRepository.save(item);
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> items = this.itemRepository.findAll();
        List<ItemDto> itemDtos=items.stream().map(item->itemToDto(item)).collect(Collectors.toList());
        return itemDtos;
    }

    @Override
    public void deleteItem(Integer id) {

        Item item = this.itemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User","id,",id));
        this.itemRepository.delete(item);
    }
    @Override
    public ItemDto getItemById(Integer id) {
        Item item = this.itemRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User","id,",id));
        return itemToDto(item);
    }

    // Working as Model Mappers.
    private Item dtoToItem(ItemDto itemDto) {

        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());
        item.setCalories(itemDto.getCalories());
        item.setRichIn(itemDto.getRichIn());
        item.setDate(itemDto.getDateFromLocalDate());
        item.setUsers(Arrays.asList( new User()));
        return item;
    }
    private ItemDto itemToDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setCalories(item.getCalories());
        itemDto.setRichIn(item.getRichIn());
        itemDto.setDate(item.getDateFromLocalDate());
        return itemDto;
    }

}
