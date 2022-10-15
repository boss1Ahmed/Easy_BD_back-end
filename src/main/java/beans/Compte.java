package beans;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "compte")
public class Compte {
	
	@Id
	@Column(name = "id")
	
	private long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "validate")
	private boolean validate = false;
    
	@OneToOne(cascade = CascadeType.DETACH , fetch =  FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@OneToOne(cascade = CascadeType.DETACH , fetch =  FetchType.LAZY)
	@JoinColumn(name = "centre_id")
	@JsonIgnore
	private Centre centre;
	
	@ManyToOne(targetEntity = Role.class ,cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
	//@JsonIgnore
	@JoinColumn(name = "role")
	private Role role;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate ) {
		this.validate = validate;
	}

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
