package beans;

import java.util.Set;

import javax.annotation.Generated;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
@DynamicUpdate
@DynamicInsert(value = true)
public class User {

	@Id
	
	@Column(name = "CIN")
	private long CIN;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name= "age")
	private int age;
	
	@Column(name= "adresse")
	private String adresse;
	
	@Column(name= "url")
	private String url; 
	
	
	
	@ManyToMany()
	//@JsonIgnore
	@JoinTable(name = "user_annonce",
			   joinColumns = @JoinColumn(name ="CIN"),
			   inverseJoinColumns = @JoinColumn(name ="id"))
	@Column(updatable = false)
	private Set<Annonce> annonces;
	

	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "user_centre",
			   joinColumns = @JoinColumn(name ="CIN"),
			   inverseJoinColumns = @JoinColumn(name ="id"))
	private Set<Centre> centres;
	
	@OneToOne( cascade = CascadeType.DETACH  ) 
    @JoinColumn( name="id_compte" )
	@JsonIgnore
    private Compte compte ;
  
	@ManyToOne(targetEntity = Blood_type.class , fetch = FetchType.LAZY )
	@JoinColumn(name = "id_blood" )
	//@JsonIgnore
	private Blood_type blood_name;
	
	@Column(name = "image")
	private String image;
	
	
	
	public long getCIN() {
		return CIN;
	}
	public void setCIN(long cIN) {
		CIN = cIN;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Blood_type getBlood_name() {
		return blood_name;
	}
	public void setBlood_name(Blood_type blood_name) {
		this.blood_name = blood_name;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Set<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(Set<Annonce> annonces) {
		this.annonces = annonces;
	}
	public Set<Centre> getCentres() {
		return centres;
	}
	public void setCentres(Set<Centre> centres) {
		this.centres = centres;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
