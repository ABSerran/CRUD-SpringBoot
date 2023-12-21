package com.EnartSystems.Prueba.interfaces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EnartSystems.Prueba.model.Persona;

@Repository
public interface IPersona extends CrudRepository <Persona,Integer>{

}
