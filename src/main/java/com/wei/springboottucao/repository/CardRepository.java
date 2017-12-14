package com.wei.springboottucao.repository;

import org.springframework.data.repository.CrudRepository;

import com.wei.springboottucao.entity.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

}