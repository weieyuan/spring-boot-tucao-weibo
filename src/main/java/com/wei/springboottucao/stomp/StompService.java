package com.wei.springboottucao.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class StompService {

	@Autowired
	private SimpMessagingTemplate template;
	
	
	public void sendMsg(String strDst, Object oPayload){
		this.template.convertAndSend(strDst, oPayload);
	}
	
}
