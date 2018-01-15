package com.wei.springboottucao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.wei.springboottucao.entity.Reply;

@Transactional(readOnly=true)
public interface ReplyRepository extends CrudRepository<Reply, Long> {

	List<Reply> findByRemarkId(Long id);
	
	@Modifying
	@Transactional
	@Query("update Reply r set r.praiseNum = r.praiseNum + 1 where r.id = ?1")
	void addPriseNumOne(Long id);
	
}
