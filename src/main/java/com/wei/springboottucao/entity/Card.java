package com.wei.springboottucao.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.wei.springboottucao.helper.ApplicationHelper;
import com.wei.springboottucao.stomp.StompService;

@Entity
@Table(name = "tbl_card")
@EntityListeners(AuditingEntityListener.class)
public class Card {

	@Id
	@GeneratedValue
	private Long id;

	@Type(type = "true_false")
	private boolean anonymous;

	private String pic;

	private String name;

	private long time;

	private long praiseNum;

	private long remarkNum;

	@Type(type = "text")
	private String msg;

//	@OneToMany(mappedBy="card")
//	private List<Remark> remarks;
	
	//audit
	@CreatedBy
	private String createdBy;

	//audit
	@LastModifiedBy
	private String modifiedBy;
	
	@PostPersist
	public void postInsert(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("success", true);
		params.put("count", 10);
		ApplicationHelper.getBean(StompService.class).sendMsg("/card/newMsg", params);
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public long getRemarkNum() {
		return remarkNum;
	}

	public void setRemarkNum(long remarkNum) {
		this.remarkNum = remarkNum;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
