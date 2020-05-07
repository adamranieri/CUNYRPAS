package dev.ranieri.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.ranieri.entities.Associate;
import dev.ranieri.repositories.AssociateRepository;

@Component
@Service // lets spring know that this class is  service
// automatically makes this class a singleton
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	AssociateRepository ar;

		
	@Override
	public Associate createAssociate(Associate associate) {	
		associate = ar.save(associate);
		return associate;
	}

	@Override
	public Associate getAssociateById(int id) {	
		return ar.findById(id).get();
	}

	@Override
	public Associate updateAssociate(Associate associate) {		
		return ar.save(associate);
	}

	@Override
	public boolean deleteAssociate(Associate associate) {		
		ar.delete(associate);
		return true;
	}

	@Override
	public List<Associate> getAllAssociates() {
		List<Associate> associates = (List<Associate>) ar.findAll();	
		return associates;
	}

	@Override
	public List<Associate> findAssociatesInPointRange(int min, int max) {
		List<Associate> associates = ar.findByPointsBetween(min, max);
		return associates;
	}
	
	

}
