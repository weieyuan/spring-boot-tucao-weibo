package com.wei.springboottucao;

import java.util.List;

import org.junit.Assert;

import com.wei.springboottucao.entity.Reply;
import com.wei.springboottucao.helper.ApplicationHelper;
import com.wei.springboottucao.utils.HttpUtils;

public class ReplyTestProvider {

	private ReplyTestProvider() {

	}

	public static void addReply() {

		Reply oReply = new Reply();
		oReply.setAnonymous(true);
		oReply.setMsg("This is a reply");
		oReply.setName("DESTINA");
		oReply.setPic("");
		oReply.setTime(1345678);
		
		String strUrl = ConstProvider.BASE_URL + "/reply/add/1";
		
		Boolean b = ApplicationHelper.getBean(HttpUtils.class).post4Object(strUrl, oReply, Boolean.class);
		
		Assert.assertTrue(b);
		
	}

	public static void getReplyByRemarkId() {
		String strUrl = ConstProvider.BASE_URL + "/reply/getByRemarkId/1";
		
		List<?> lst = ApplicationHelper.getBean(HttpUtils.class).post4ObjectWithoutParams(strUrl, List.class);
		
		Assert.assertEquals(1, lst.size());
	}

	public static void addPriseNum() {
		String strUrl = ConstProvider.BASE_URL + "/reply/praise/1";
		
		Boolean b = ApplicationHelper.getBean(HttpUtils.class).post4ObjectWithoutParams(strUrl, Boolean.class);
		
		Assert.assertTrue(b);
	}
	
	

}
