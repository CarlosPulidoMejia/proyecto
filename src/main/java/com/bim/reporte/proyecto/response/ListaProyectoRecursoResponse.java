package com.bim.reporte.proyecto.response;
import java.util.Set;

import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.PersonaResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaProyectoRecursoResponse {

	private ProyectoResponse proyecto;
	private DetalleProyectoResponse detalleProyecto;
	private Set<PersonaResponse> recursos;
	private Set<GerenciaResponse> gerencia;
	//private Set<GerenciaResponse> gerencia;
	//private Set<ProyectoRecurso> recurso;
	//private DetalleProyectoResponse detalleProyectoResponse;
}
