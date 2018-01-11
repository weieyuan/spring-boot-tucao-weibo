package com.wei.springboottucao;

import java.util.List;

import org.junit.Assert;

import com.wei.springboottucao.entity.Remark;
import com.wei.springboottucao.helper.ApplicationHelper;
import com.wei.springboottucao.utils.HttpUtils;

public class RemarkTestProvider {

	private RemarkTestProvider(){
		
	}
	
	public static void addRemark(){
		Remark oRemark = new Remark();
		oRemark.setAnonymous(true);
		oRemark.setMsg("ssss");
		oRemark.setName("A");
		oRemark.setPic("");
		oRemark.setPraiseNum(0);
		oRemark.setReplyNum(0);
		oRemark.setTime(10000);
		
		String strUrl = ConstProvider.BASE_URL + "/remark/add/1";
		
		Boolean b = ApplicationHelper.getBean(HttpUtils.class).post4Object(strUrl, oRemark, Boolean.class);
		
		Assert.assertEquals(true, b);
	}

	public static void getReamrkByCardId() {
		
		String strUrl = ConstProvider.BASE_URL + "/remark/get/1";
		
		List<?> lst = ApplicationHelper.getBean(HttpUtils.class).post4ObjectWithoutParams(strUrl, List.class);
		
		Assert.assertEquals(1, lst.size());
		
	}
	
}
