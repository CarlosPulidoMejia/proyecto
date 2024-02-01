package com.bim.reporte.proyecto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleProyectoRequest {

	private int idDetalle;
	//private int idProyecto;
	private float hrsAtencion;
	private String fechaInicio;
	private String fechaFin;
	private int fase;
	private int estado;
	private int dependencia;
	private int porcentaje;
	private int documentacion;
	
}
