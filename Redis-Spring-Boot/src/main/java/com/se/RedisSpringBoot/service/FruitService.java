package com.se.RedisSpringBoot.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.se.RedisSpringBoot.entity.Fruit;

@Service
public interface FruitService {
	List<Fruit> getAll();

	Fruit getDetail(Long id);

	Fruit create(Fruit fruit);

	void update(Long id, Fruit fruit);

	void delete(Long id);
}
