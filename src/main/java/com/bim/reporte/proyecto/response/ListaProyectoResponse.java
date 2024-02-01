package com.bim.reporte.proyecto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListaProyectoResponse {

	private ProyectoResponse proyectoResponse;
	private DetalleProyectoResponse detalleProyectoResponse;
	
}
