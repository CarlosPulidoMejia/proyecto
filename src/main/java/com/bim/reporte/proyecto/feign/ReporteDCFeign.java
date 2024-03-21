package com.bim.reporte.proyecto.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bim.reporte.proyecto.response.feign.rol.RolRequest;
import com.bim.reporte.proyecto.response.reportedc.GestionDocumentacionResponse;
import com.bim.reporte.proyecto.response.reportedc.GestionPlaneacionResponse;
import com.bim.reporte.proyecto.response.reportedc.GestionRecursosResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenGestionResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenProyectoResponse;

@FeignClient(name="reportedc-service",url = "http://localhost:8085")
public interface ReporteDCFeign {

	@GetMapping("gestion/recursos")
	public GestionRecursosResponse gestionRecursos();
	
	@GetMapping("gestion/planeacion")
	public GestionPlaneacionResponse gestionPlaneacion();
	
	@GetMapping("gestion/documentacion")
	public GestionDocumentacionResponse gestionDocumentacion();
	
	@GetMapping("resumen/detalle")
	public ResumenProyectoResponse resumenProyectoResponse();
	
}
