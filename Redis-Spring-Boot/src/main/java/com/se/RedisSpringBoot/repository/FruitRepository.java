package com.se.RedisSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.se.RedisSpringBoot.entity.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
