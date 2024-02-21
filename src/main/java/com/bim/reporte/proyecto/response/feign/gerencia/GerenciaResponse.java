package com.bim.reporte.proyecto.response.feign.gerencia;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GerenciaResponse {

	public int idGerencia;
	public String gerencia;
}
