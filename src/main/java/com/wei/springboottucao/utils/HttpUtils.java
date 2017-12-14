package com.wei.springboottucao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtils {

	@Autowired
	private RestTemplate template;
	
	public <T> T post4Object(String strUrl, Object oParams, Class<T> responseClazz){
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(oParams, header);
		
		T t = template.postForObject(strUrl, entity, responseClazz);
		
		return t;
	}
	
}
