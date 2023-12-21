package com.EnartSystems.Prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EnartSystems.Prueba.interfaceService.IpersonaService;
import com.EnartSystems.Prueba.model.Persona;
import com.EnartSystems.Prueba.interfaces.IPersona;

@Service
public class PersonaService implements IpersonaService {

	@Autowired
	private IPersona data;

	@Override
	public List<Persona> listar() {
		return (List<Persona>) data.findAll();
	}
//Recuperar un cliente por su ID	
	@Override
	public Optional<Persona> listarId(int id) {
		return data.findById(id);
	}
//Guardar un cliente ya sea modificado o creado de nuevo
	@Override
	public int save(Persona p) {
		int res=0;
		Persona persona=data.save(p);
		if (!persona.equals(null)) {
			res=1;
		}
		return res;
	}
//Borrar un cliente
	@Override
	public void delete(int id) {
		data.deleteById(id);

	}

}
