package com.EnartSystems.Prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EnartSystems.Prueba.interfaceService.IpersonaService;
import com.EnartSystems.Prueba.model.Persona;

@Controller
@RequestMapping

public class Controlador {

	@Autowired
	private IpersonaService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona> personas = service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}

}
