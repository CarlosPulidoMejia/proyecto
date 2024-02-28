package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bim.reporte.proyecto.request.DetalleDocumentacionRequest;
import com.bim.reporte.proyecto.request.DetalleEstadoProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleFaseRequest;
import com.bim.reporte.proyecto.request.DetalleDependenciaRequest;
import com.bim.reporte.proyecto.request.DetalleTipoProyectoRequest;
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
	public void modificarDependencia (@PathVariable int id, @RequestBody DetalleDependenciaRequest detalleReq);
	
	@PostMapping("/crearDependencia")
	public void crearDependencia (@RequestBody DetalleDependenciaRequest dependencia);
	
	
	@GetMapping("/catalogos/tipoDocumentacion")
	public List<TipoDocumentacionResponse> listarTipoDocumentacion();
	
	@PutMapping("/modificarDocumentacion/{id}")
	public void modificarDocumentacion (@PathVariable int id, @RequestBody DetalleDocumentacionRequest detalleReq);
	
	@PostMapping("/crearDocumentacion")
	public void crearDocumentacion (@RequestBody DetalleDocumentacionRequest documentacion);
	
	
	@GetMapping("/catalogos/tipoEstado")
	public List<TipoEstadoProyectoResponse> listarTipoEstado();
	
	@PutMapping("/modificarEstado/{id}")
	public void modificarEstado (@PathVariable int id, @RequestBody DetalleEstadoProyectoRequest detalleReq);
	
	@PostMapping("/crearEstado")
	public void crearEstado (@RequestBody DetalleEstadoProyectoRequest estado);
	
	
	@GetMapping("/catalogos/tipoFase")
	public List<TipoFaseResponse> listarTipoFase();
	
	@PutMapping("/modificarFase/{id}")
	public void modificarFase (@PathVariable int id, @RequestBody DetalleFaseRequest detalleReq);
	
	@PostMapping("/crearFase")
	public void crearFase (@RequestBody DetalleFaseRequest fase);
	
	
	@GetMapping("/catalogos/tipoProyecto")
	public List<TipoProyectoResponse> listarTipoProyecto();
	
	@PutMapping("/modificarTipoProyecto/{id}")
	public void modificarTipoProyecto (@PathVariable int id, @RequestBody DetalleTipoProyectoRequest detalleReq);
	
	@PostMapping("/crearTipoProyecto")
	public void crearTipoProyecto (@RequestBody DetalleTipoProyectoRequest tipoProyecto);
}
