package controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beans.Annonce;
import beans.Blood_type;
import beans.User;
import servicesDB.Blood_typeServices;

@RestController
@RequestMapping("/bloodtype")
public class Blood_typeController {
	private final Blood_typeServices bloodtypeservices=new Blood_typeServices();
	
	@GetMapping("/{id}")
	public Blood_type getBlood_type(@PathVariable long id){
		
		return bloodtypeservices.getBlood_typebyId(id);
		
	}
	
	@GetMapping("/all")
	public  List <Blood_type>  getAllBlood_type() {
		
		return bloodtypeservices.getAllBlood_type() ;
	}
	@GetMapping("/usersofbloodtype/{id}")
	public Iterator<User> getAllUsersOfBloodtype(@PathVariable long id){
		return bloodtypeservices.getAllUserofBlood_type(id);
	}
	
	@GetMapping("/annoncesofbloodtype/{id}")
	public Iterator<Annonce> getAllAnnoncesOfBloodtype(@PathVariable long id){
		return bloodtypeservices.getAllAnnoceofBlood_type(id);
	}
	@GetMapping("/add")
	public void addCentre(@RequestBody Blood_type bloodtype) {
		bloodtypeservices.addBlood_type( bloodtype);
	}
	
	@GetMapping("/delete/{id}")
	public void deletebloodtype(@PathVariable long id) {
		bloodtypeservices.deleteBlood_type(bloodtypeservices.getBlood_typebyId(id));
		
	}

	@GetMapping("/update")
	public void updateCentre(@RequestBody Blood_type bloodtype) {
		bloodtypeservices.updateBlood_type(bloodtype);
	}

}
