package com.bim.reporte.proyecto.response.reportedc;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FaseProyectoResponse {

	private int analisis;
	private int desarrollo;
	private int pruebas;
	private int calidad;
	private int producion;
}
