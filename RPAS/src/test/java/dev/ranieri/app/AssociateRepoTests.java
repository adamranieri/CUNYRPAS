package dev.ranieri.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.ranieri.entities.Associate;
import dev.ranieri.repositories.AssociateRepository;

@SpringBootTest
@ContextConfiguration(classes = dev.ranieri.app.RpasApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AssociateRepoTests {

	@Autowired
	AssociateRepository ar;
	
	@Test
	@Order(1)
	public void createAssociate() {
		Associate tiffany = new Associate(0,"Tiffany",1500);
		ar.save(tiffany);
	}
	
	@Test
	@Order(2)
	public void updatePoints() {
		Associate tiff = ar.findByName("Tiffany").get(0);
		tiff.setPoints(1700);
		ar.save(tiff);
	}
	
}
