package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	@PostMapping("/catalogos/crearDependencia")
	public void crearDependencia (@RequestBody DetalleDependenciaRequest dependencia);
	
	
	@GetMapping("/catalogos/tipoDocumentacion")
	public List<TipoDocumentacionResponse> listarTipoDocumentacion();
	
	@PutMapping("/catalogos/modificarDocumentacion/{id}")
	public void modificarDocumentacion (@PathVariable int id, @RequestBody DetalleDocumentacionRequest detalleReq);
	
	@PostMapping("/catalogos/crearDocumentacion")
	public void crearDocumentacion (@RequestBody DetalleDocumentacionRequest documentacion);
	
	
	@GetMapping("/catalogos/tipoEstado")
	public List<TipoEstadoProyectoResponse> listarTipoEstado();
	
	@PutMapping("/catalogos/modificarEstado/{id}")
	public void modificarEstado (@PathVariable int id, @RequestBody DetalleEstadoProyectoRequest detalleReq);
	
	@PostMapping("/catalogos/crearEstado")
	public void crearEstado (@RequestBody DetalleEstadoProyectoRequest estado);
	
	
	@GetMapping("/catalogos/tipoFase")
	public List<TipoFaseResponse> listarTipoFase();
	
	@PutMapping("/catalogos/modificarFase/{id}")
	public void modificarFase (@PathVariable int id, @RequestBody DetalleFaseRequest detalleReq);
	
	@PostMapping("/catalogos/crearFase")
	public void crearFase (@RequestBody DetalleFaseRequest fase);
	
	
	@GetMapping("/catalogos/tipoProyecto")
	public List<TipoProyectoResponse> listarTipoProyecto();
	
	@PutMapping("/catalogos/modificarTipoProyecto/{id}")
	public void modificarTipoProyecto (@PathVariable int id, @RequestBody DetalleTipoProyectoRequest detalleReq);
	
	@PostMapping("/catalogos/crearTipoProyecto")
	public void crearTipoProyecto (@RequestBody DetalleTipoProyectoRequest tipoProyecto);
}
