package controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beans.Centre;
import beans.Compte;
import beans.Role;
import servicesDB.CompteServices;
import util.HibernateUtil;

@RestController
@RequestMapping("/compte")
@CrossOrigin("*")
public class CompteController {
	CompteServices compteServices = new CompteServices();
	
	
	
	@GetMapping("/{id}")
	public Compte getComptebyId(@PathVariable Long id) {
		Compte compte = new Compte();
		
		compte = compteServices.getComptebyId(id);
		
		return compte;
	}
	
	@PostMapping("/add/{id}")
	public void addCompte(@RequestBody Compte compte, @PathVariable long id) {
		Role role = new Role();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		role = (Role) session.get(Role.class, id);
		compte.setRole(role);
		session.close();
		compteServices.addCompte(compte);
		
	}
	
	@GetMapping("/all")
	public List<Compte> getAllCompte(){
		List<Compte> comptes = new ArrayList<Compte>();
		
		comptes = compteServices.getAllCompte();
		return comptes;
	}
	
	@PostMapping("/delete/{id}")
	public void deleteCompte(@PathVariable Long id) {
		compteServices.deleteCompte(compteServices.getComptebyId(id));
	}
	
	@PostMapping("/update")
	public void updateCompte(@RequestBody Compte compte) {
		compteServices.updateCompte(compte);
	}
	
	@PostMapping("/userofcompte/{id}")
	public beans.User getUserofCompte(@PathVariable Long id) {
		beans.User user = new beans.User();
		user = compteServices.getUserofCompte(id);
		return user;
	}
	
	@PostMapping("/centerofcompte/{id}")
	public Centre getCenterofCompte(@PathVariable Long id) {
		Centre centre = new Centre();
		centre = compteServices.getCentreofCompte(id);
		return centre;
	}
	
	

}
