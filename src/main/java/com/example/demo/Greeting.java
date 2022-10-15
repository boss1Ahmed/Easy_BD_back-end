package com.example.demo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "greeting")
public class Greeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String  content;
	
//	@ManyToOne()
//	@JoinColumn(name = "user")
//	@JsonIgnore
//	private User user;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "user_greeting",
			   joinColumns = @JoinColumn(name ="id_greeting"),
			   inverseJoinColumns = @JoinColumn(name ="id_user"))
	private Set<User> users;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	

}
