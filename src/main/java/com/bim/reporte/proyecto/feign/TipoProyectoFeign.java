package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bim.reporte.proyecto.response.feign.TipoDependenciaResponse;
import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoEstadoProyectoResponse;
import com.bim.reporte.proyecto.response.feign.TipoFaseResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;

@FeignClient(name="mantenimiento-service",url = "http://localhost:8081")
public interface TipoProyectoFeign {
	@GetMapping("/catalogos/tipoProyecto")
	public List<TipoProyectoResponse> listarTipoProyecto();
	
	@GetMapping("/catalogos/tipoDocumentacion")
	public List<TipoDocumentacionResponse> listarTipoDocumentacion();
	
	@GetMapping("/catalogos/tipoFase")
	public List<TipoFaseResponse> listarTipoFase();
	
	@GetMapping("/catalogos/tipoDependencia")
	public List<TipoDependenciaResponse> listarTipoDependencia();
	
	@GetMapping("/catalogos/tipoEstado")
	public List<TipoEstadoProyectoResponse> listarTipoEstado();
}
