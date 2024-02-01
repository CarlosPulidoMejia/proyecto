package com.bim.reporte.proyecto.request;

import lombok.Data;

@Data
public class DetalleObjetivo {
	
	private int idProyecto;
	
	private boolean status;
	
	private String detalle;
	
	private String fechaCorteUno;
	
	private String fechaCorteDos;
}
