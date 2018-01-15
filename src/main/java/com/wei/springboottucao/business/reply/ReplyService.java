package com.wei.springboottucao.business.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wei.springboottucao.entity.Remark;
import com.wei.springboottucao.entity.Reply;
import com.wei.springboottucao.repository.RemarkRepository;
import com.wei.springboottucao.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository repository;

	@Autowired
	private RemarkRepository remarkRepository;

	public List<Reply> getReplysByRemarkId(Long remarkId) {

		List<Reply> lst = this.repository.findByRemarkId(remarkId);

		return lst;
	}

	@Transactional
	public Reply addReply(Long remarkId, Reply oReply) {
		Remark oRemark = this.remarkRepository.findOne(remarkId);
		oRemark.setReplyNum(oRemark.getReplyNum() + 1);
		this.remarkRepository.save(oRemark);
		
		oReply.setRemark(oRemark);
		Reply oReplyRes = this.repository.save(oReply);
		return oReplyRes; 
	}

	public Boolean addPraiseNum(Long id) {
		Boolean success = true;
		try{
			this.repository.addPriseNumOne(id);
		}
		catch(Exception e){
			success = false;
		}
		return success;
	}

}
