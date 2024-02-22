package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bim.reporte.proyecto.response.feign.TipoDependenciaResponse;
import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoEstadoProyectoResponse;
import com.bim.reporte.proyecto.response.feign.TipoFaseResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;

@FeignClient(name="mantenimiento-service",url = "http://localhost:8081")
public interface TipoProyectoFeign {
	
	@GetMapping("/catalogos/tipoDependencia")
	public List<TipoDependenciaResponse> listarTipoDependencia();
	
	@PutMapping("/catalogos/modificarDependencia/{id}")
	public void modificarDependencia ();
	
	@PostMapping("/crearDependencia")
	public void crearDependencia ();
	
	
	@GetMapping("/catalogos/tipoDocumentacion")
	public List<TipoDocumentacionResponse> listarTipoDocumentacion();
	
	@PutMapping("/modificarDocumentacion/{id}")
	public void modificarDocumentacion ();
	
	@PostMapping("/crearDocumentacion")
	public void crearDocumentacion ();
	
	
	@GetMapping("/catalogos/tipoEstado")
	public List<TipoEstadoProyectoResponse> listarTipoEstado();
	
	@PutMapping("/modificarEstado/{id}")
	public void modificarEstado ();
	
	@PostMapping("/crearEstado")
	public void crearEstado ();
	
	
	@GetMapping("/catalogos/tipoFase")
	public List<TipoFaseResponse> listarTipoFase();
	
	@PutMapping("/modificarFase/{id}")
	public void modificarFase ();
	
	@PostMapping("/crearFase")
	public void crearFase ();
	
	
	@GetMapping("/catalogos/tipoProyecto")
	public List<TipoProyectoResponse> listarTipoProyecto();
	
	@PutMapping("/modificarTipoProyecto/{id}")
	public void modificarTipoProyecto ();
	
	@PostMapping("/crearTipoProyecto")
	public void crearTipoProyecto ();
}
