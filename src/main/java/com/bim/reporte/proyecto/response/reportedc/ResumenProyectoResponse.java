package com.bim.reporte.proyecto.response.reportedc;

import lombok.Data;

@Data
public class ResumenProyectoResponse {

	private TipoProyectoResponse proyectoResponse;
	
	private FaseProyectoResponse faseProyectoResponse;
	
	private EstadoProyectoResponse estadoProyectoResponse;
	
	private DocumentacionResponse documentacionResponse;

}
