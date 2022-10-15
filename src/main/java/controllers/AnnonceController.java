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

import beans.Annonce;
import beans.Blood_type;
import beans.User;
import servicesDB.AnnonceServices;
import servicesDB.Blood_typeServices;

@RestController
@RequestMapping("/annonce")
@CrossOrigin("*")
public class AnnonceController {

	private final AnnonceServices annonceservices=new AnnonceServices();
	
	@GetMapping("/{id}")
	public Annonce getannonce(@PathVariable long id){
		
		return annonceservices.getAnnonceById(id);
		
	}
	
	@GetMapping("/all")
	public  List<Annonce>getAllannonces() {
		
		return (List<Annonce>) annonceservices.getAllAnnonces();
	}
	
	
	@PostMapping("/add/{id}")
	public void addannonce(@RequestBody Annonce annonce,@PathVariable Long id) {
		annonceservices.addAnnonce( annonce, id);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteannonce(@PathVariable long id) {
		annonceservices.deleteAnnonce(annonceservices.getAnnonceById(id));
		
	}

	@GetMapping("/update")
	public void updateannonce(Annonce annonce) {
		annonceservices.updateAnnonce(annonce);
	}
	@GetMapping("/usersofannonce/{id}")
	public Iterator<User> getAllUsersOfannonce(@PathVariable long id){
		return annonceservices.getAllUsers(id);
	}
	
	
	@GetMapping("/bloodtypeofannonce/{id}")
	public Iterator<Blood_type> getAllBloodtypeOfannonce(@PathVariable long id){
		return annonceservices.getAllBloodtype(id);
	}

}