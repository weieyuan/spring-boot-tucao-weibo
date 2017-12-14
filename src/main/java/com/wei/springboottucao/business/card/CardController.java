package com.wei.springboottucao.business.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wei.springboottucao.entity.Card;

@RestController
@RequestMapping(value="/card")
public class CardController {

	@Autowired
	private CardService service;
	
	@RequestMapping(value= "/add", method=RequestMethod.POST)
	public boolean addCard(@RequestBody Card card){
		return this.service.addCard(card);
	}
	
}
