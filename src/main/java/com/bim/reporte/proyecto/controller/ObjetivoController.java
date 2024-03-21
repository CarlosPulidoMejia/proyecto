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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.request.ComentarioProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleObjetivoRequest;
import com.bim.reporte.proyecto.response.ObjetivoResponse;
import com.bim.reporte.proyecto.service.ObjetivoService;

@RestController
@RequestMapping("objetivo")
@CrossOrigin("*")
public class ObjetivoController {
	
	@Autowired
	private ObjetivoService objetivoService;
	
	@PutMapping("/editarComentario/{idProyecto}")
	public void comentarioObjetivo(@PathVariable("idProyecto") int idProyecto,@RequestBody ComentarioProyectoRequest comentarioProyectoRequest) {
		objetivoService.comentariosObjetivo(idProyecto, comentarioProyectoRequest);
	}
	
	@GetMapping("/listarToDo/{idProyecto}")
	public ResponseEntity<List<ObjetivoResponse>> listaObjetivoToDo(@PathVariable("idProyecto") int idProyecto){
		System.out.println("ID PROY: " + idProyecto);
		
		return ResponseEntity.ok(objetivoService.listaObjetivoProyecto(idProyecto));
	}
	
	@GetMapping("/listarDocumentacion/{idProyecto}")
	public ResponseEntity<List<ObjetivoResponse>> listaObjetivoAvance(@PathVariable("idProyecto") int idProyecto){
		System.out.println("ID PROY: " + idProyecto);
		
		return ResponseEntity.ok(objetivoService.listaObjetivoProyectoSemana(idProyecto));
	}

	@PutMapping("/modificarDocumentacion/{idObjetivo}")
	public void modificarDetalle(@PathVariable("idObjetivo") int idObjetivo,@RequestBody DetalleObjetivoRequest detalleObjetivoRequest) {
		objetivoService.modificarObjetivo(idObjetivo, detalleObjetivoRequest);
	}
}
