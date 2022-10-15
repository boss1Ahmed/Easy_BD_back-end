package controllers;

import java.sql.Array;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import beans.Compte;
import beans.Role;
import beans.User;
import beans.User_Compte;
import servicesDB.BeansService;
import servicesDB.CompteServices;
import servicesDB.UserServices;
import util.HibernateUtil;

@RestController
@CrossOrigin("*")
public class TestObjectsController {

	CompteServices compteServices = new CompteServices();
	UserServices userServices = new UserServices();
	
	
	@PostMapping("/object/{object}")
	public List<Object> getObjects(@PathVariable String object,@RequestBody String[] values){
		BeansService beansService = new BeansService();
		//String[] values = {"CIN", "10","nom","ahmed","prenom","ahmed1"};
		return beansService.getObject(object, values );
	}
	
	@PostMapping("/objects/{object}")
	public Object getObject(@PathVariable String object,@RequestBody String[] values){
		BeansService beansService = new BeansService();
		//String[] values = {"CIN", "10","nom","ahmed","prenom","ahmed1"};
		return beansService.getObject(object, values ).iterator();
	}
	
	@PostMapping("/signup/{id}")
	public void signup(@RequestBody User_Compte map ,@PathVariable long id) {
		Role role = new Role();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		role = (Role) session.get(Role.class, id);
		session.close();
		Compte compte = map.getCompte();
		User user = map.getUser();
		compteServices.addCompte(compte);
		userServices.addUser(user);
		
		user.setCompte(compte);
		compte.setUser(user);
		compte.setRole(role);
		
		
		compteServices.updateCompte(compte);
		userServices.updateUser(user);
		
	}
}
