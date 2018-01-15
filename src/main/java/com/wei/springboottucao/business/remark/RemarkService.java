package com.wei.springboottucao.business.remark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wei.springboottucao.entity.Card;
import com.wei.springboottucao.entity.Remark;
import com.wei.springboottucao.repository.CardRepository;
import com.wei.springboottucao.repository.RemarkRepository;

@Service
public class RemarkService {

	@Autowired
	private RemarkRepository repository;
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<Remark> getRemarksByCardId(Long cardId) {
		List<Remark> lst = this.repository.findByCardId(cardId);
		return lst;
	}

	@Transactional
	public Remark addRemark(Long cardId, Remark oRemark) {
		Card oCard = this.cardRepository.findOne(cardId);
		oCard.setRemarkNum(oCard.getRemarkNum() + 1);
		this.cardRepository.save(oCard);
		oRemark.setCard(oCard);
		Remark oRemarkRes = this.repository.save(oRemark);
		return oRemarkRes;
	}

	public Boolean addPriseNum(Long id) {
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
