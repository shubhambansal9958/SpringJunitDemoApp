package com.inventory.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.model.Item;
import com.inventory.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	public Item save(Item Item) {
		return itemRepository.save(Item);
	}

	public Optional<Item> findById(String id) {
		return itemRepository.findById(id);
	}

	public void deleteById(String id) {
		itemRepository.deleteById(id);
	}

	public List<Item> findAll() {
		Iterable<Item> data = itemRepository.findAll();
		List<Item> list = new ArrayList<>();
		data.forEach(item -> list.add(item));
		return list;		
	}
	
	public List<Item> findByItemName(String itemName) {
		return itemRepository.findByItemName(itemName);
	}
}
