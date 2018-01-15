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

	public List<Reply> getReplysByRemarkId(Long id) {

		List<Reply> lst = this.repository.findByRemarkId(id);

		return lst;
	}

	@Transactional
	public Boolean addReply(Long id, Reply oReply) {
		Boolean success = true;
		try {
			Remark oRemark = this.remarkRepository.findOne(id);
			oRemark.setReplyNum(oRemark.getReplyNum() + 1);
			this.remarkRepository.save(oRemark);
			
			oReply.setRemark(oRemark);
			this.repository.save(oReply);

		} 
		catch (Exception e) {
			success = false;
		}

		return success;
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
