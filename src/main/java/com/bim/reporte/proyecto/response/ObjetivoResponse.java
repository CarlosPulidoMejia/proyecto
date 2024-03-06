package com.bim.reporte.proyecto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetivoResponse {
	
	private int idProyecto;
	
	private int idObjetivo;
	
	private String objetivo;
	
	private String detalleObjetivo;
	
	private Boolean status;
	
	//private List<DetalleObjetivoResponse> objetivos;
}
