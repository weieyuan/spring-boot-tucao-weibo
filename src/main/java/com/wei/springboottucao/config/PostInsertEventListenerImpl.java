package com.wei.springboottucao.config;

import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.stereotype.Component;

//不生效，待完善配置后生效
@Component
public class PostInsertEventListenerImpl implements PostInsertEventListener {

	private static final long serialVersionUID = -5776243679464624146L;

	@Override
	public void onPostInsert(PostInsertEvent event) {
		System.out.println("xxx");

	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO Auto-generated method stub
		return true;
	}

}
