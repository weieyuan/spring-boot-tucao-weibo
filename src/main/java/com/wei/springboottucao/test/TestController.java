package com.wei.springboottucao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class TestController {

	@Autowired
	private UserInfoRepository repository;

	@RequestMapping(value = "/test")
	public String test() {
		return "Test";
	}

	@RequestMapping(value = "/save/{name}/{title}")
	public String save(@PathVariable("name") String name, @PathVariable("title") String title) {
		UserInfo oUserInfo = new UserInfo();
		oUserInfo.setName(name);
		oUserInfo.setTitle(title);
		this.repository.save(oUserInfo);
		return "success";
	}
	
	@RequestMapping(value = "/get")
	public UserInfo get(){
		Iterable<UserInfo> oUserInfo = this.repository.findAll();
		return oUserInfo.iterator().next();
	}
	
	@RequestMapping(value = "/promise/{num}")
	public String testPromise(@PathVariable(name="num") int i)
	{
		return "data" + i;
	}
}
