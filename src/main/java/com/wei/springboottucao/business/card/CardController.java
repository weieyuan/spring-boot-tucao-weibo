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

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public List<Card> getCards() {
		return this.service.getCards();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addCard(@RequestBody Card card) {
		return this.service.addCard(card);
	}
	
	@RequestMapping(value="/praise/{cardId}", method = RequestMethod.POST)
	public boolean addPraiseNum(@PathVariable(name="cardId")Long cardId){
		return this.service.addPraiseNum(cardId);
	}
	
	@RequestMapping(value="/{cardId}", method = RequestMethod.POST)
	public Card getCardById(@PathVariable(name="cardId")Long cardId){
		return this.service.getCardById(cardId);
	}

}
