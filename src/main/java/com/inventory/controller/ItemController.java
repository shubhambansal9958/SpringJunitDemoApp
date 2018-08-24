package com.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.model.Item;
import com.inventory.service.ItemService;;


@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;

	@PostMapping
	public void save(@RequestBody Item Item) {
		itemService.save(Item);
	}

	@GetMapping("/{id}")
	public Optional<Item> findById(@PathVariable("id") String id) {
		return itemService.findById(id);
	}
	
	@GetMapping
	public List<Item> findAll() {
		return itemService.findAll();
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") String id) {
		itemService.deleteById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Item> findByItemName(@PathVariable("name") String itemName){
		System.out.println(itemName);
		return itemService.findByItemName(itemName);
	}

}
