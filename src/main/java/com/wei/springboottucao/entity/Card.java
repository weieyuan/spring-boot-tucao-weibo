package com.wei.springboottucao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "tbl_card")
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
