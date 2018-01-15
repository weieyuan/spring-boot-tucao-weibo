package com.wei.springboottucao.business.remark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wei.springboottucao.entity.Remark;

@RequestMapping(value = "/remark")
@RestController
public class RemarkController {

	@Autowired
	private RemarkService service;

	/**
	 * 获取微博的所有评论
	 * @param id 微博id
	 * @return
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.POST)
	public List<Remark> getRemarksByCardId(@PathVariable(name = "id") Long id) {
		return this.service.getRemarksByCardId(id);
	}

	/**
	 * 给某条微博添加评论
	 * @param cardId 微博id
	 * @param oRemark
	 * @return
	 */
	@RequestMapping(value = "/add/{cardId}", method = RequestMethod.POST)
	public Boolean addRemark(@PathVariable(name = "cardId") Long cardId, @RequestBody Remark oRemark) {
		Boolean b = this.service.addRemark(cardId, oRemark);
		return b;
	}
	
	/**
	 * 某条评论的喜爱数加1 
	 * @param id 评论的id
	 * @return
	 */
	@RequestMapping(value="/praise/{id}", method = RequestMethod.POST)
	public Boolean addPriseNum(@PathVariable(name="id") Long id){
		return this.service.addPriseNum(id);
	}

}
