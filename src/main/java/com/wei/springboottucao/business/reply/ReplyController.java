package com.wei.springboottucao.business.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wei.springboottucao.entity.Reply;

@RestController
@RequestMapping(value="/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService service;

	/**
	 * 添加一条回复到对应的评论中
	 * @param id 评论id
	 * @param reply
	 * @return
	 */
	@RequestMapping(value="/add/{id}", method=RequestMethod.POST)
	public Boolean addReply(@PathVariable(name="id")Long id, @RequestBody Reply reply)
	{
		return this.service.addReply(id, reply);
	}
	
	/**
	 * 通过评论的id获取评论所有的回复
	 * @param id 评论id
	 * @return
	 */
	@RequestMapping(value="/getByRemarkId/{id}")
	public List<Reply> getReplysByRemarkId(@PathVariable(name="id")Long id)
	{
		return this.service.getReplysByRemarkId(id);
	}
	
	/**
	 * 某条回复的喜爱数加1
	 * @param id 回复的id
	 * @return
	 */
	@RequestMapping(value="/praise/{id}")
	public Boolean addPraiseNum(@PathVariable(name="id") Long id){
		return this.service.addPraiseNum(id);
	}
	
}
