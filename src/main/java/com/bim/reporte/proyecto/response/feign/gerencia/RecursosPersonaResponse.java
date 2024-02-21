package com.bim.reporte.proyecto.response.feign.gerencia;

import java.util.List;

import lombok.Data;


@Data
public class RecursosPersonaResponse {

	private GerenciaResponse gerencia;
	private List<PersonaResponse> usuarios;
}
