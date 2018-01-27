package com.wei.springboottucao.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.wei.springboottucao.test.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
