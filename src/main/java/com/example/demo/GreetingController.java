package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import util.HibernateUtil;

@RestController
public class GreetingController {
	
	@GetMapping("/greeting/{id}")
	List<Greeting> greeting(@RequestParam(defaultValue = "ahmed") String nam,@PathVariable("id") String id) {
		Greeting greeting = new Greeting();
		greeting.setId(1L);
		//greeting.setContent("hello"+ id +nam);
		
		Greeting greeting2= new Greeting();
		//greeting2.setContent("walo");
		//greeting2.setId(2L);
		List<Greeting> greetings = new ArrayList<Greeting>();
		greetings.add(greeting2);
		greetings.add(greeting);
		return greetings;
	}

	@GetMapping("/walo/{id}")
	String function(@RequestParam String value) {
		return new String("bonjoour!");
	}
	
	@PostMapping("/savegrreting")
	public Greeting saveGreeting(@RequestBody Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Greeting greeting2 = new Greeting();
		//String string = new String("walo");
		greeting2.setContent("walo");
		//session.save(greeting);
		Greeting greeting3 = new Greeting();
		greeting3.setContent("meme2223");
		
		
		User user = new User(); 
		List<Greeting> greetings = new ArrayList<Greeting>();
		greetings.add(greeting3);
		
		user.setUsername("ahmedA");
		//greeting3.setUser(user);
		
		session.save(user);
		session.saveOrUpdate(greeting3);
		session.save(greeting2);
		session.getTransaction().commit();
		//session.close();
		return greeting3;
	}
	
	@GetMapping("/greetings")
	public Set<Greeting> getallgreetings(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//Greeting greeting1 = (Greeting) session.get(Greeting.class, 1L);
		//List<Greeting> greetings = (List<Greeting>) session.createQuery("from Greeting").list();
		User user = ((User) session.get(User.class, 1L));
		//List<User> greetingss = session.createQuery("from User").list();
		//session.close();
		return  user.getGreetings();
	}
	
	@GetMapping("/usergreetings/{id}")
	public Iterator<Greeting> usergreetings(@PathVariable long id){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//User user = ((User) session.get(User.class, id));
		Greeting greeting = (Greeting) session.get(Greeting.class, 1L);
		//User user = greeting.getUser();
	
	
		//Set<Greeting> greetings =  user.getGreetings();
		//Iterator<Greeting> greetings = user.getGreetings().iterator();
		//Iterator<Greeting> iterator = greetings;
		//session.close();
		//Iterator<Greeting> greetingss = greetings.iterator();
		//Greeting greeting = greetingss.next();
		return null;
	}
	
}
