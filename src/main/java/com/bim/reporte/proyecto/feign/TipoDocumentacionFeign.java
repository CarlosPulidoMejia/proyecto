package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;

//@FeignClient(name="mantenimiento-service",url="localhost:8081")
public interface TipoDocumentacionFeign {

	/*@GetMapping("/catalogos/tipoProyecto")
	public List<TipoDocumentacionResponse> listarTipoDocumentacion();
	*/
}
