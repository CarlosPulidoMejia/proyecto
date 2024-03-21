package com.bim.reporte.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.response.reportedc.ResumenGestionResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenProyectoResponse;
import com.bim.reporte.proyecto.service.GestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("reporte")
public class ReporteDCControlller {

	@Autowired
	private GestionService gestionService; 
	
	@GetMapping("/gestion")
	public ResponseEntity<ResumenGestionResponse> resumenGestion(){
	
		return ResponseEntity.ok(gestionService.resumenGestionResponse());
	}
	
	@GetMapping("/resumen")
	public ResponseEntity<ResumenProyectoResponse> resumenProyectoResponse(){
	
		return ResponseEntity.ok(gestionService.resumenProyectoResponse());
	}
}
