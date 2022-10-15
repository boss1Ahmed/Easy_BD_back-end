package com.example.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beans.Centre;
import beans.User;
import servicesDB.CentreServices;
import servicesDB.UserServices;

@RestController
public class TestConroller {
	UserServices services = new UserServices();
	CentreServices centreServices = new CentreServices();


	@GetMapping("/users")
	public List<User> getallusers(){
		
		return services.getAllUsers();
	}
	
	@PostMapping("/adduser")
	public User saveuser(@RequestBody User user) {
		services.addUser(user);
		return user;
	}
	
	@GetMapping("/getcentres")
	public Iterator<Centre> getallcentres(){
		return centreServices.getAllCentres();
	}
	
	@GetMapping("centre/{id}")
	public Centre getcentre(@PathVariable Long id) {
		return centreServices.getCentrebyId(id);
	}
	

}
