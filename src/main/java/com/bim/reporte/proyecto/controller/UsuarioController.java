package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;
import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosPersonaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosResponse;
import com.bim.reporte.proyecto.service.UsuarioService;

@RestController
@RequestMapping("recursos")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	/*@GetMapping("/listar")
	public ResponseEntity<List<UsuarioResponseFeign>> listar(){
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
	*/
	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<RecursosResponse>> listarTodo(){
		return ResponseEntity.ok(usuarioService.listarUsuariosTodo());
	}
	
	@GetMapping("/listarGerencias")
	public ResponseEntity<List<GerenciaResponse>> listarGerencias(){
		return ResponseEntity.ok(usuarioService.listaGerencias());
	}
	
	@GetMapping("/listarGerencia/{idGerencia}")
	public ResponseEntity<List<GerenciaResponse>> listarGerencias(@PathVariable("idGerencia") int idGerencia){
		return ResponseEntity.ok(usuarioService.listaGerenciasId(idGerencia));
	}
	
	@GetMapping("/listarGerencias/{idGerencia}")
	public ResponseEntity<List<RecursosPersonaResponse>> listarGerencias1(@PathVariable("idGerencia") int idGerencia){
		return ResponseEntity.ok(usuarioService.listaGerencia(idGerencia));
	}
}
