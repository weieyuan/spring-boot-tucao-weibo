package com.wei.springboottucao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		CardTestProvider.getCardById();
	}
	
	@Test
	public void remarkTest(){
		CardTestProvider.addCard();
		RemarkTestProvider.addRemark();
		RemarkTestProvider.getReamrkByCardId();
		RemarkTestProvider.addPriseNum();
	}
	
	@Test
	public void replyTest(){
		CardTestProvider.addCard();
		RemarkTestProvider.addRemark();
		ReplyTestProvider.addReply();
		ReplyTestProvider.getReplyByRemarkId();
		ReplyTestProvider.addPriseNum();
	}
	
}
