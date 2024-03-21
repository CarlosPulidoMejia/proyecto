package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.response.feign.rol.RolResponse;
import com.bim.reporte.proyecto.service.RolService;

@RestController
@RequestMapping("rol")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@GetMapping("/listar")
	private ResponseEntity<List<RolResponse>> listaRoles(){
		return ResponseEntity.ok(rolService.listaRoles());
	}
	
}
