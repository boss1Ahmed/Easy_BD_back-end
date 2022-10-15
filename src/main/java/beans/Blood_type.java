package beans;

import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "blood_type")
public class Blood_type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "blood_name")
	private String blood_name;
	
	@OneToMany( targetEntity=User.class, mappedBy="blood_name" , fetch = FetchType.LAZY)
	@JsonIgnore
    private Set<User> users  = new HashSet<User>() ;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "annoce_blood",
			   joinColumns = @JoinColumn(name ="id_blood"),
			   inverseJoinColumns = @JoinColumn(name ="id_annonce"))
	@JsonIgnore
	private Set<Annonce> annonces;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBlood_name() {
		return blood_name;
	}

	public void setBlood_name(String blood_name) {
		this.blood_name = blood_name;
	}


	public Blood_type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Set<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	
	
	
}
