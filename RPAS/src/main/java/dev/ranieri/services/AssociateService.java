package dev.ranieri.services;

import java.util.List;

import dev.ranieri.entities.Associate;

public interface AssociateService {
	
	Associate createAssociate(Associate associate);
	
	Associate getAssociateById(int id);
	List<Associate> getAllAssociates();
	
	Associate updateAssociate(Associate associate);
	
	boolean deleteAssociate(Associate associate);
	
	List<Associate> findAssociatesInPointRange(int min, int max);

}
