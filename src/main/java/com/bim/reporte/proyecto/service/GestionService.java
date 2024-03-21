package com.bim.reporte.proyecto.service;

import com.bim.reporte.proyecto.response.reportedc.GestionDocumentacionResponse;
import com.bim.reporte.proyecto.response.reportedc.GestionPlaneacionResponse;
import com.bim.reporte.proyecto.response.reportedc.GestionRecursosResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenGestionResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenProyectoResponse;

public interface GestionService {

	public GestionRecursosResponse gestionRecurso();
	
	public GestionPlaneacionResponse gestionPlaneacion();
	
	public GestionDocumentacionResponse gestionDocumentacion();
	
	public ResumenGestionResponse resumenGestionResponse();
	
	public ResumenProyectoResponse resumenProyectoResponse();
}
