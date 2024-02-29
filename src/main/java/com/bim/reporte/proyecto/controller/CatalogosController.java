package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.request.DetalleDependenciaRequest;
import com.bim.reporte.proyecto.request.DetalleDocumentacionRequest;
import com.bim.reporte.proyecto.request.DetalleEstadoProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleFaseRequest;
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
	
	@GetMapping("/tipoDependencia")
	public ResponseEntity<List<TipoDependenciaResponse>> listaTipoDependencia(){
		return ResponseEntity.ok(catalogoService.listarTipoDependencia());
	}
	
	@PutMapping("/modificarDependencia")
	public void modificarDependencia (@PathVariable int id, @RequestBody DetalleDependenciaRequest detalleReq) {
		catalogoService.modificarDependencia(id, detalleReq);
	}
	
	@PostMapping("/crearDependencia")
	public void crearDependencia (@RequestBody DetalleDependenciaRequest dependencia) {
		catalogoService.crearDependencia(dependencia);
	}
	
	@GetMapping("/tipoDocumentacion")
	public ResponseEntity<List<TipoDocumentacionResponse>> listaTipoDoc(){
		return ResponseEntity.ok(catalogoService.listarTipoDoc());
	}
	
	@PutMapping("/modificarDocumentacion")
	public void modificarDocumentacion (@PathVariable int id, @RequestBody DetalleDocumentacionRequest detalleReq) {
		catalogoService.modificarDocumentacion(id, detalleReq);
	}
	
	@PostMapping("/crearDocumentacion")
	public void crearDocumentacion (@RequestBody DetalleDocumentacionRequest documentacion) {
		catalogoService.crearDocumentacion(documentacion);
	}
	
	@GetMapping("/tipoEstado")
	public ResponseEntity<List<TipoEstadoProyectoResponse>> listaTipoEstado(){
		return ResponseEntity.ok(catalogoService.listarTipoEstado());
	}
	
	@PutMapping("/modificarEstado")
	public void modificarEstado (@PathVariable int id, @RequestBody DetalleEstadoProyectoRequest detalleReq) {
		catalogoService.modificarEstado(id, detalleReq);
	}
	
	@GetMapping("/tipoFase")
	public ResponseEntity<List<TipoFaseResponse>> listaTipoFase(){
		return ResponseEntity.ok(catalogoService.listarTipoFase());
	}
	
	@PutMapping("/modificarFase")
	public void modificarFase(@PathVariable int id, @RequestBody DetalleFaseRequest detalleReq) {
		catalogoService.modificarFase(id, detalleReq);
	}
	
	@PostMapping("/crearFase")
	public void crearFase(@RequestBody DetalleFaseRequest fase) {
		catalogoService.crearFase(fase);
	}
	
}
