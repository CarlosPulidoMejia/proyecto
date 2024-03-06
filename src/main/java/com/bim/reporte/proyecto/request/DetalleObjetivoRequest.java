package com.bim.reporte.proyecto.request;

import lombok.Data;

@Data

public class DetalleObjetivoRequest {

	private int idProyecto;
	
	private int idObjetivo;
	
	private String detalleObjetivo;
	
	private int status;
	
	private String comentarioProyecto;
	
}
