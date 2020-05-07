package dev.ranieri.app;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.ranieri.entities.Associate;
import dev.ranieri.repositories.AssociateRepository;

@SpringBootTest
@Transactional
class RpasApplicationTests {
	
	@Autowired // @Autowired telss spring this field needs to be fulfilled with dependency injection
	// Spring will search the spring container to find a bean that can satisfy this dependency
	// Spring data will create its OWN implementation classes for your repository interfaces
	AssociateRepository ar;

	@Test
	void getAllAssociates() {
		
		List<Associate> associates = (List<Associate>) ar.findAll();;
		System.out.println(associates);
		
	}
	
	@Test
	void getAssociate() {
		//optionals are helpful for when you might not get the data
		Associate jesse = ar.findById(1).get();
		System.out.println(jesse);
		
	}
	
	@Test
	void getAssociatesByName() {
		//optionals are helpful for when you might not get the data
		List<Associate> associates = ar.findByName("Nirav");
		System.out.println(associates);
		
	}
	
	@Test
	void getAssociatesByLowerPoints() {
		List<Associate> associates = ar.findByPointsBetween(0, 1000);
		System.out.println(associates);
	}
	
	// because we put at transactional any crud operations are automically rolled back in your tests
	@Test
	@Commit
	public void createAssociate() {
		
		Associate cheng = new Associate(0,"Cheng",500);
		ar.save(cheng);
	}


}
