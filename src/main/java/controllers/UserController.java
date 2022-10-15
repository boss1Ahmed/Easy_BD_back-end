package controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beans.Compte;
import beans.User;
import servicesDB.CompteServices;
import servicesDB.UserServices;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	UserServices userServices = new UserServices();
	CompteServices compteServices = new CompteServices();
	
	@GetMapping("/all")
	public List<User> getallusers(){
		return userServices.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getuserbyid(@PathVariable long id) {
		return userServices.getUserById(id);
	}
	
	@PostMapping("/add/{id}")
	@CrossOrigin("*")
	public void adduser(@RequestBody User user , @PathVariable long id) {
		Compte compte = new Compte();
		compte = compteServices.getComptebyId(id); 
		user.setCompte(compte);
		userServices.addUser(user);
	}

	
	@GetMapping("/delete/{id}")
	public void deleteuser(@PathVariable long id) {
		userServices.deleteUser(userServices.getUserById(id));
		
	}
	
	@GetMapping("/update")
	public void updateuser(@RequestBody User user) {
		userServices.updateUser(user);
	}
	
}
