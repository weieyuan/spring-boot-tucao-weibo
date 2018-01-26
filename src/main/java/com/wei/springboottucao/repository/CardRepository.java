package com.wei.springboottucao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wei.springboottucao.entity.Card;

@Transactional(readOnly=true)
public interface CardRepository extends CrudRepository<Card, Long> {

	List<Card> findAllByOrderByIdDesc();
	
	List<Card> findByIdGreaterThanOrderByIdDesc(Long cardId);
	
}