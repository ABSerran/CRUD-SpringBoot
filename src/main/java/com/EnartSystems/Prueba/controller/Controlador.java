package com.EnartSystems.Prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EnartSystems.Prueba.interfaceService.IpersonaService;
import com.EnartSystems.Prueba.model.Persona;

@Controller
@RequestMapping

public class Controlador {

	@Autowired
	private IpersonaService service;

//Ver todos los clientes
	@GetMapping("/")
	public String listar(Model model,@Param("palabraClave") String palabraClave) {

		List<Persona> personas = service.listar(palabraClave);
		model.addAttribute("personas", personas);
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}

//Crear un nuevo cliente
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form";
	}

//Guardar
	@PostMapping("/save")
	public String save(@Validated Persona p, Model model) {
		service.save(p);
		return "redirect:/";

	}
	
//Actualizar un cliente	
	@GetMapping ("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	
//Borrar	
	@GetMapping ("/eliminar/{id}")
	public String delete (Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/";
		
	}

}
