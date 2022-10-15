package controllers;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import beans.Centre;
import servicesDB.CentreServices;
import util.HibernateUtil;

@RestController
@RequestMapping("/centre")
@CrossOrigin("*")
public class CentreController {
	CentreServices centreservices = new CentreServices();
	
	
	@GetMapping("/{id}")
	public Centre getCentre(@PathVariable long id){
		
		return centreservices.getCentrebyId(id);
		
	}
	@GetMapping("/all")
	public  Iterator<Centre> getAllCentres(){
		
		return  centreservices.getAllCentres();
	}
	@GetMapping("/usersofcentre/{id}")
	public Iterator<beans.User> getAllUsersOfCentre(@PathVariable long id){
		return centreservices.getAllUsers(id);
	}
	
	
	@GetMapping("/add")
	public void addCentre(@RequestBody Centre centre) {
		centreservices.addCentre( centre);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteCentre(@PathVariable long id) {
		
		centreservices.deleteCentre(centreservices.getCentrebyId(id));
		
	}

	@GetMapping("/update")
	public void updateCentre(Centre centre) {
		centreservices.updateCentre(centre);
	}
	

}
