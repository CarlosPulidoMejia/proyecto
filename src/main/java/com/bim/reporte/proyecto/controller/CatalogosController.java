package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.response.feign.TipoDependenciaResponse;
import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoEstadoProyectoResponse;
import com.bim.reporte.proyecto.response.feign.TipoFaseResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;
import com.bim.reporte.proyecto.service.CatalogoService;

@RestController
public class CatalogosController {
	
	@Autowired
	CatalogoService catalogoService;
	
	@GetMapping("/tipoProyecto")
	public ResponseEntity<List<TipoProyectoResponse>> listaTipoProy(){
		
		return ResponseEntity.ok(catalogoService.listarTipoProy());
		//impl.listarTipoProy();
		//return null;
	}
	
	@GetMapping("/tipoDocumentacion")
	public ResponseEntity<List<TipoDocumentacionResponse>> listaTipoDoc(){
		return ResponseEntity.ok(catalogoService.listarTipoDoc());
	}
	
	@GetMapping("/tipoFase")
	public ResponseEntity<List<TipoFaseResponse>> listaTipoFase(){
		return ResponseEntity.ok(catalogoService.listarTipoFase());
	}
	
	@GetMapping("/tipoDependencia")
	public ResponseEntity<List<TipoDependenciaResponse>> listaTipoDependencia(){
		return ResponseEntity.ok(catalogoService.listarTipoDependencia());
	}
	
	@GetMapping("/tipoEstado")
	public ResponseEntity<List<TipoEstadoProyectoResponse>> listaTipoEstado(){
		return ResponseEntity.ok(catalogoService.listarTipoEstado());
	}
}
