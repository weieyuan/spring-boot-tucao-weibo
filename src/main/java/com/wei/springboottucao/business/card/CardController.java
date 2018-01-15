package com.wei.springboottucao.business.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wei.springboottucao.entity.Card;

@RestController
@RequestMapping(value = "/card")
public class CardController {

	@Autowired
	private CardService service;

	/**
	 * 获取所有的微博
	 * @return
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public List<Card> getCards() {
		return this.service.getCards();
	}

	/**
	 * 添加一条微博
	 * @param card
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Card addCard(@RequestBody Card card) {
		return this.service.addCard(card);
	}
	
	/**
	 * 某条微博的喜爱数加1
	 * @param cardId 微博id
	 * @return
	 */
	@RequestMapping(value="/praise/{cardId}", method = RequestMethod.POST)
	public boolean addPraiseNum(@PathVariable(name="cardId")Long cardId){
		return this.service.addPraiseNum(cardId);
	}
	
	/**
	 * 获取微博
	 * @param cardId 微博id
	 * @return
	 */
	@RequestMapping(value="/get/{cardId}", method = RequestMethod.POST)
	public Card getCardById(@PathVariable(name="cardId")Long cardId){
		return this.service.getCardById(cardId);
	}

}
