package com.bim.reporte.proyecto.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.feign.ReporteDCFeign;
import com.bim.reporte.proyecto.response.reportedc.GestionDocumentacionResponse;
import com.bim.reporte.proyecto.response.reportedc.GestionPlaneacionResponse;
import com.bim.reporte.proyecto.response.reportedc.GestionRecursosResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenGestionResponse;
import com.bim.reporte.proyecto.response.reportedc.ResumenProyectoResponse;
import com.bim.reporte.proyecto.service.GestionService;

@Service
public class GestionServiceImpl  implements GestionService{

	@Autowired
	private ReporteDCFeign reporteDCFeign;
	
	@Override
	public GestionRecursosResponse gestionRecurso() {
		// TODO Auto-generated method stub
		return reporteDCFeign.gestionRecursos();
	}

	@Override
	public GestionPlaneacionResponse gestionPlaneacion() {
		// TODO Auto-generated method stub
		return reporteDCFeign.gestionPlaneacion();
	}

	@Override
	public GestionDocumentacionResponse gestionDocumentacion() {
		// TODO Auto-generated method stub
		return reporteDCFeign.gestionDocumentacion();
	}

	@Override
	public ResumenGestionResponse resumenGestionResponse() {
		// TODO Auto-generated method stub
		
		ResumenGestionResponse resumenGestionResponse = new ResumenGestionResponse();
		
		GestionRecursosResponse gestionRecursosResponse = reporteDCFeign.gestionRecursos();
		
		GestionPlaneacionResponse gestionPlaneacionResponse = reporteDCFeign.gestionPlaneacion();
		
		GestionDocumentacionResponse gestionDocumentacionResponse = reporteDCFeign.gestionDocumentacion();
		
		
		
		resumenGestionResponse.setRecursos(gestionRecursosResponse);
	
		resumenGestionResponse.setPlaneacion(gestionPlaneacionResponse);
		
		resumenGestionResponse.setDocumentacion(gestionDocumentacionResponse);
		
		return resumenGestionResponse;
	}

	@Override
	public ResumenProyectoResponse resumenProyectoResponse() {
		// TODO Auto-generated method stub
		return reporteDCFeign.resumenProyectoResponse();
	}

}
