package com.bim.reporte.proyecto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetivoResponse {

	private int idProyecto;
	
	private String objetivo;
	
	private String comentario;
	
	private Boolean status;
}
