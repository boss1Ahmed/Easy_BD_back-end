package beans;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "annonce")
public class Annonce {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "datelimite")
	private Date datelimite;
	
	@Column(name = "datecreation")
	private Date datecreation;
	
	
	@Column(name = "message")
	private String message;
	
	
	
	@ManyToMany()
	@JsonIgnore
	@JoinTable(name = "user_annonce",
			   joinColumns = @JoinColumn(name ="id"),
			   inverseJoinColumns = @JoinColumn(name ="CIN"))
	private Set<User> users;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	//@JsonIgnore
	@JoinTable(name = "annoce_blood",
			   joinColumns = @JoinColumn(name ="id_annonce"),
			   inverseJoinColumns = @JoinColumn(name ="id_blood"))
	private Set<Blood_type> bloods;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDatelimite() {
		return datelimite;
	}
	public void setDatelimite(Date datelimite) {
		this.datelimite = datelimite;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Blood_type> getBloods() {
		return bloods;
	}
	public void setBloods(Set<Blood_type> bloods) {
		this.bloods = bloods;
	}
	
	
	

}
