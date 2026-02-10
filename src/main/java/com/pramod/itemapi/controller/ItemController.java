package com.pramod.itemapi.controller;

import com.pramod.itemapi.model.Item;
import com.pramod.itemapi.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@Tag(name = "Item API", description = "APIs for managing items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(summary = "Add a new item")
    @PostMapping
    public Item addItem(@Valid @RequestBody Item item) {
        return itemService.addItem(item);
    }

    @Operation(summary = "Get all items")
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
}
