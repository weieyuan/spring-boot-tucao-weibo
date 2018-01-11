package com.wei.springboottucao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wei.springboottucao.entity.Remark;

public interface RemarkRepository extends CrudRepository<Remark, Long> {

	List<Remark> findByCardId(Long id);
	
}
