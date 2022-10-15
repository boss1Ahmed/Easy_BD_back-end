package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="role") 
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	private long id_role;
	
	@Column(name = "role_name")
	private String role_name;

	
	@OneToMany(targetEntity = Compte.class, mappedBy = "role" , fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Compte> comptes = new HashSet<Compte>() ;
	
	public long getId_role() {
		return id_role;
	}

	public void setId_role(long id_role) {
		this.id_role = id_role;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
	
}
