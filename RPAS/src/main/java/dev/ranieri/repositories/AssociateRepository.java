package dev.ranieri.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.ranieri.entities.Associate;

@Component
@Repository									// type of entity and the type of the key (int id)
public interface AssociateRepository extends CrudRepository<Associate,Integer> {

	List<Associate> findByName(String name);
	List<Associate> findByPointsBetween(int min,int max);
}
