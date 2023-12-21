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

	@Override
	public Optional<Persona> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int save(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
