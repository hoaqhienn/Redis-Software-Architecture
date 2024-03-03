package com.se.RedisSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.RedisSpringBoot.entity.Fruit;
import com.se.RedisSpringBoot.service.FruitServiceImplement;

@RestController
@RequestMapping("/api/fruit")
public class FruitController {
	@Autowired
	private FruitServiceImplement fruitService;

	@GetMapping("")
	public List<Fruit> getAll() {
		return fruitService.getAll();
	}

	@GetMapping("/{fruitId}")
	public Fruit getDetail(@PathVariable("fruitId") Long fruitId) {
		return fruitService.getDetail(fruitId);
	}

	@PostMapping("/create")
	public Fruit create(@RequestBody Fruit fruit) {
		Fruit newFruit = fruitService.create(fruit);
		System.out.println("GET ID CREATE: " + newFruit.getId());
		return newFruit;
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Fruit fruit) {
		fruitService.update(id, fruit);

		return ResponseEntity.ok("Update fruit is success");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		fruitService.delete(id);

		return ResponseEntity.ok("Delete fruit is success");
	}
}