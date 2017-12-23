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
		CardTestProvider.addCard();
		CardTestProvider.getCards();
	}
	
}
