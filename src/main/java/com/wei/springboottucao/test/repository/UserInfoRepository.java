package com.wei.springboottucao.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.wei.springboottucao.test.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

}
