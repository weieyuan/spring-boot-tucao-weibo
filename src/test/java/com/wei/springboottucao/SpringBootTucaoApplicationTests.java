package com.wei.springboottucao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.wei.springboottucao.entity.Card;
import com.wei.springboottucao.helper.ApplicationHelper;
import com.wei.springboottucao.utils.HttpUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=dev"}, 
webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootTucaoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void cardTest(){
		Card oCard = new Card();
		oCard.setAnonymous(false);
		oCard.setName("");
		oCard.setPic("");
		oCard.setPraiseNum(0);
		oCard.setRemarkNum(0);
		oCard.setTime(1509526435275L);
		oCard.setMsg("abcd");
		
//		RestTemplate template = new RestTemplate();
//		HttpHeaders header = new HttpHeaders();
//		header.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<Card> entity = new HttpEntity<Card>(oCard, header);
//		
		String url = "http://localhost:8089/card/add";
//		String strRes = template.postForObject(url, entity, String.class);
		
		String strRes = ApplicationHelper.getBean(HttpUtils.class).post4Object(url, oCard, String.class);
		
		System.out.println(strRes);
	}
	
}
