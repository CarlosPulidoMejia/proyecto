package com.bim.reporte.proyecto.response.reportedc;

import lombok.Data;

@Data
public class ResumenGestionResponse {

	private GestionRecursosResponse recursos;
	
	private GestionPlaneacionResponse planeacion;
	
	private GestionDocumentacionResponse documentacion;
}
