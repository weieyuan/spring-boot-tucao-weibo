package com.wei.springboottucao.utils;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtils {

	private RestTemplate template;
	
	@PostConstruct
	public void init(){
		this.template = new RestTemplate();
	}
	
	public <T> T post4Object(String strUrl, Object oParams, Class<T> responseClazz){
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(oParams, header);
		
		T t = template.postForObject(strUrl, entity, responseClazz);
		
		return t;
	}
	
}
