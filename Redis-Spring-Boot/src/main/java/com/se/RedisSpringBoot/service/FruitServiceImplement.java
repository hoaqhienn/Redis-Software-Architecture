package com.se.RedisSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.se.RedisSpringBoot.entity.Fruit;
import com.se.RedisSpringBoot.repository.FruitRepository;

import java.util.List;

@Service
public class FruitServiceImplement implements FruitService {

	@Autowired
	private FruitRepository fruitRepository;

	@Override
	@Cacheable(value = "fruitsCache", key = "#root.methodName")
	public List<Fruit> getAll() {
		return fruitRepository.findAll();
	}

	@Override
	@Cacheable(value = "fruitsCache", key = "#id")
	public Fruit getDetail(Long id) {
		return fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit is not exist!"));
	}

	@Override
	@CacheEvict(value = "fruitsCache", allEntries = true)
	public Fruit create(Fruit fruit) {
		return fruitRepository.save(fruit);
	}

	@Override
	@CacheEvict(value = "fruitsCache", key = "#id")
	public void update(Long id, Fruit fruitUpdate) {
		Fruit fruit = fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit is not exist!"));

		// Update course properties

		fruitRepository.save(fruit);
	}

	@Override
	@CacheEvict(value = "fruitsCache", key = "#id")
	public void delete(Long id) {
		fruitRepository.findById(id).orElseThrow(() -> new RuntimeException("Fruit is not exist!"));
		fruitRepository.deleteById(id);
	}
}
