package com.bim.reporte.proyecto.response;

import java.util.List;
import java.util.Set;

import com.bim.reporte.proyecto.entity.Usuario;
import com.bim.reporte.proyecto.response.feign.gerencia.PersonaResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaProyectoRecursoResponse {

	private ProyectoResponse proyectoResponse;
	private List<PersonaResponse> recurso;
	//private Set<ProyectoRecurso> recurso;
	//private DetalleProyectoResponse detalleProyectoResponse;
}
