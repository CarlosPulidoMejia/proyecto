package com.bim.reporte.proyecto.request;

import lombok.Data;

@Data
//@AllArgsConstructor
public class ProyectoRequest {

	private int idProyecto;
	private String proyecto;
	private int tipoProyecto;
	private int responsable;
	private String fechaInicio;
	private String fechaFin;
	private int tipoDoc;
}
