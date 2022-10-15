package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userG")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
//	@OneToMany(targetEntity = Greeting.class, mappedBy = "user")
//	@JsonIgnore
//	private List<Greeting> greetings = new ArrayList<>();

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "user_greeting",
			   joinColumns = @JoinColumn(name ="id_user"),
			   inverseJoinColumns = @JoinColumn(name ="id_greeting"))
	private Set<Greeting> greetings;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	
	public Set<Greeting> getGreetings() {
		return greetings;
	}

	public void setGreetings(Set<Greeting> greetings) {
		this.greetings = greetings;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
