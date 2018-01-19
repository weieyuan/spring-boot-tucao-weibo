package com.wei.springboottucao.business.card;

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

	public Card addCard(Card card) {
		Card oCardRes = this.repository.save(card);
		return oCardRes;
	}

	public List<Card> getCards() {
//		Iterable<Card> ite = this.repository.findAll();
//		Iterator<Card> iterator = ite.iterator();
//		List<Card> lst = new ArrayList<Card>();
//		while (iterator.hasNext()) {
//			lst.add(iterator.next());
//		}
		List<Card> lst = this.repository.findAllByOrderByTimeDesc();
		
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

	public Card getCardById(Long cardId) {
		Card oCard = this.repository.findOne(cardId);
		return oCard;
	}

}
