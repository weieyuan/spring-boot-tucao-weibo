package com.wei.springboottucao.business.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.springboottucao.entity.Card;
import com.wei.springboottucao.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;
	
	public boolean addCard(Card card) {
		boolean success = true;
		try{
			this.repository.save(card);
		}
		catch(Exception e){
			success = false;
		}
		return success;
	}

}
