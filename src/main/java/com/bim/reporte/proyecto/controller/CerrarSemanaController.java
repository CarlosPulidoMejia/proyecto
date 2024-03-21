package com.bim.reporte.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.service.CerrarSemanaService;

@RestController
@RequestMapping("cerrar")
public class CerrarSemanaController {

	@Autowired
	private CerrarSemanaService cerrarSemanaService;
	
	@GetMapping("/semana")//11-12
	public void cerrarSemana() {
		cerrarSemanaService.obtenerFecha();
	}
	
}
