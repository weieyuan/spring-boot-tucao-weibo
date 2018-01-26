package com.wei.springboottucao.business.card;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.springboottucao.cache.GlobalCache;
import com.wei.springboottucao.cache.GlobalCache.Cache;
import com.wei.springboottucao.entity.Card;
import com.wei.springboottucao.repository.CardRepository;
import com.wei.springboottucao.vo.card.CardNewMsgVo;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;

	public Card addCard(String clientId, Card card) {
		//save cache
		Cache oCache = new Cache();
		oCache.setClientId(clientId);
		GlobalCache.getInstance().addCache(oCache);
		
		Card oCardRes = this.repository.save(card);
		return oCardRes;
	}

	public List<Card> getCards() {
		List<Card> lst = this.repository.findAllByOrderByIdDesc();
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

	public List<Card> getNewCards(CardNewMsgVo oCardNewMsgVo) {
		List<Card> lstRes = this.repository.findByIdGreaterThanOrderByIdDesc(oCardNewMsgVo.getCardId());
		return lstRes;
	}

}
