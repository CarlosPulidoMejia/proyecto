package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;


public interface GerenciaService {

	public List<GerenciaResponse> listaGerencias();
	
	public List<GerenciaResponse> listaGerenciasId(int idGerencia);
	
}
