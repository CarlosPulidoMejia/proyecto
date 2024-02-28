package com.bim.reporte.proyecto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaProyectoResponse {

	private ProyectoResponse proyectoResponse;
	//private Set<ProyectoRecurso> recurso;
	private DetalleProyectoResponse detalleProyectoResponse;
	
}
