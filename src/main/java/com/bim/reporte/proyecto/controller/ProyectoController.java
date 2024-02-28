package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.request.DetalleProyectoRequest;
import com.bim.reporte.proyecto.request.ObjetivoRequest;
import com.bim.reporte.proyecto.request.ProyectoRequest;
import com.bim.reporte.proyecto.response.ListaProyectoRecursoResponse;
import com.bim.reporte.proyecto.response.ListaProyectoResponse;
import com.bim.reporte.proyecto.service.ProyectoService;

@RestController
@CrossOrigin("*")
public class ProyectoController {

	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/listaproyectos")
	public ResponseEntity<List<ListaProyectoResponse>> listar(){
		return ResponseEntity.ok(proyectoService.listaProyectos());
	}
	
	@GetMapping("/listaproyectosRecurso")
	public ResponseEntity<List<ListaProyectoRecursoResponse>> listarProy(){
		return ResponseEntity.ok(proyectoService.listaProyectosRecurso());
	}
	
	@GetMapping("/listaproyectosGerencia/{idGerencia}")
	public ResponseEntity<List<ListaProyectoRecursoResponse>> listarProyGeren(@PathVariable("idGerencia") int idGerencia){
		return ResponseEntity.ok(proyectoService.listaProyectosGerencia(idGerencia));
	}
	
	@GetMapping("/listaproyectosGerenciaRecurso/{idGerencia}/{idUsu}")
	public ResponseEntity<List<ListaProyectoRecursoResponse>> listarProyGerenRec(@PathVariable("idGerencia") int idGerencia,@PathVariable("idUsu") int id){
		return ResponseEntity.ok(proyectoService.listaProyectosGerenciaRecurso(idGerencia,id));
	}
	
	@PostMapping("/guardarproyecto")
	public void guardarProyecto(@RequestBody ProyectoRequest proyectoRequest) {
		proyectoService.guardarProyecto(proyectoRequest);
	}
	
	@PostMapping("/guardarobjetivo")
	public void guardarObjetivo(@RequestBody ObjetivoRequest objetivo) {
		proyectoService.crearObjetivos(objetivo);
	}
	
	@PutMapping("/detalleProy/{id}")
	public void guardarObjetivo(@PathVariable int id,@RequestBody DetalleProyectoRequest detalleReq) {
		System.out.println("id mod:" + id);
		proyectoService.modificarDetalle(id,detalleReq);
	}
	
}
