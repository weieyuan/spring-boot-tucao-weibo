package com.wei.springboottucao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
		Boolean strRes = ApplicationHelper.getBean(HttpUtils.class).post4Object(strUrl, oCard, Boolean.class);

		assertTrue(strRes);
	}

	public static void getCards() {
		String strUrl = ConstProvider.BASE_URL + "/card/getAll";
		List<?> oRes = ApplicationHelper.getBean(HttpUtils.class).post4ObjectWithoutParams(strUrl, List.class);

		assertEquals(oRes.size(), 1);
	}

}
