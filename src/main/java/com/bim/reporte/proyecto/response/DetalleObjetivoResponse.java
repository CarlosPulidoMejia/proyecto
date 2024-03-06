package com.bim.reporte.proyecto.response;

import lombok.Data;

@Data
public class DetalleObjetivoResponse {

	private int idObjetivo;
	
	private String objetivo;
	
	private String detalleObjetivo;
	
	private Boolean status;
}
