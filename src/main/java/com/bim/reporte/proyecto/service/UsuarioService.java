package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;
import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosPersonaResponse;


public interface UsuarioService {

	public List<UsuarioResponseFeign> listarUsuarios();
	
	public List<GerenciaResponse> listaGerencias();
	
	public List<GerenciaResponse> listaGerenciasId(int idGerencia);
	
	public List<RecursosPersonaResponse> listaGerencia(int id);
}
