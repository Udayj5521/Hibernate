package com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int pid;
	private String name;
	private String email;

	@OneToOne
	private  VoterId voterId;
	
	
	public VoterId getVoterId() {
		return voterId;
	}
	public void setVoterId(VoterId voterId) {
		this.voterId = voterId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
