package com.example.calometer.controllers;

import com.example.calometer.model.Item;
import com.example.calometer.payload.ApiResponse;
import com.example.calometer.payload.ItemDto;
import com.example.calometer.payload.UserDto;
import com.example.calometer.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    //get all items so far
    @GetMapping("/getItems")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        return ResponseEntity.ok(this.itemService.getAllItems());
    }

    @GetMapping("/all")
    public String viewItemFeeds(Model model) {
        model.addAttribute("listItems",this.itemService.getAllItems());
        return "ItemFeeds";
    }
    @GetMapping("/addItem")
    public String toAddItemPage(Model model) {
        model.addAttribute("itemDto",new ItemDto());
        return "new_Item";
    }
    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("itemDto") ItemDto itemDto, UserDto userDto) {
        this.itemService.createItem(itemDto,userDto);
        return "redirect:/all";
    }
    @GetMapping("/update/{id}")
    public String toUpdateItemPage(@PathVariable Integer id, Model model) {
            ItemDto itemDto = this.itemService.getItemById(id);
            model.addAttribute("itemDto",itemDto);
            return "update_item";
    }
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Integer id) {
        this.itemService.deleteItem(id);
        return "redirect:/all";
    }

}
