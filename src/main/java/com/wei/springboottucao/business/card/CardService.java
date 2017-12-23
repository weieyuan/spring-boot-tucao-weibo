package com.wei.springboottucao.business.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

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
		try {
			this.repository.save(card);
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	public List<Card> getCards() {
		Iterable<Card> ite = this.repository.findAll();
		Iterator<Card> iterator = ite.iterator();
		List<Card> lst = new ArrayList<Card>();
		while (iterator.hasNext()) {
			lst.add(iterator.next());
		}
		return lst;
	}

	@Transactional
	public boolean addPraiseNum(Long cardId) {
		boolean bSuccess = true;
		try{
			Card oCard = this.repository.findOne(cardId);
			oCard.setPraiseNum(oCard.getPraiseNum() + 1);
			this.repository.save(oCard);
		}
		catch (Exception e){
			bSuccess = false;
		}
		
		return bSuccess;
	}

}
