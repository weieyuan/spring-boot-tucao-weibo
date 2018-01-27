package com.wei.springboottucao;



import com.wei.springboottucao.helper.ApplicationHelper;
import com.wei.springboottucao.test.entity.Person;
import com.wei.springboottucao.test.repository.PersonRepository;

public class HibernateTest {


	public static void test() {
		PersonRepository repository = ApplicationHelper.getBean(PersonRepository.class);
		
		Person oPerson = new Person();
		oPerson.getPhones().add("phnoe1");
		
		repository.save(oPerson);
		
		//
		oPerson.getPhones().add("phone2");
		repository.save(oPerson);
		System.out.println("end");
	}
	

}
