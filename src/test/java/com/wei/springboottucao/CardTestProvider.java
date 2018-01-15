package com.wei.springboottucao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;

import com.wei.springboottucao.entity.Card;
import com.wei.springboottucao.helper.ApplicationHelper;
import com.wei.springboottucao.utils.HttpUtils;

public class CardTestProvider {

	private CardTestProvider() {

	}

	public static void addCard() {
		Card oCard = new Card();
		oCard.setAnonymous(false);
		oCard.setName("");
		oCard.setPic("");
		oCard.setPraiseNum(0);
		oCard.setRemarkNum(0);
		oCard.setTime(1509526435275L);
		oCard.setMsg("abcd");

		String strUrl = ConstProvider.BASE_URL + "/card/add";
		Card oCardRes = ApplicationHelper.getBean(HttpUtils.class).post4Object(strUrl, oCard, Card.class);

		Assert.assertEquals(oCard.getTime(), oCardRes.getTime());
	}

	public static void getCards() {
		String strUrl = ConstProvider.BASE_URL + "/card/getAll";
		List<?> oRes = ApplicationHelper.getBean(HttpUtils.class).post4ObjectWithoutParams(strUrl, List.class);

		assertEquals(oRes.size(), 1);
	}
	
	public static Card getCardById(){
		String strUrl = ConstProvider.BASE_URL + "/card/get/1";
		Card oCard = ApplicationHelper.getBean(HttpUtils.class).post4ObjectWithoutParams(strUrl, Card.class);
		Assert.assertEquals(oCard.getId(), Long.valueOf(1));
		return oCard;
	}

}
