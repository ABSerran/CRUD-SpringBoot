package com.EnartSystems.Prueba.interfaces;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EnartSystems.Prueba.model.Persona;

@Repository
public interface IPersona extends CrudRepository <Persona,Integer>{
	
	@Query ("SELECT p FROM Persona p WHERE "
			+ "CONCAT (p.name, p.surname)"
			+ "LIKE %?1%" )
	public List <Persona> findAll(String palabraClave);

}
