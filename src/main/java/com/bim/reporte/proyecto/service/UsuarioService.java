package com.bim.reporte.proyecto.service;

import java.util.List;


import org.springframework.web.bind.annotation.RequestBody;

import com.bim.reporte.proyecto.request.feign.usuario.UsuarioRequest;
import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;
import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosPersonaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosResponse;


public interface UsuarioService {

	public List<UsuarioResponseFeign> listarUsuarios();
	
	public List<RecursosResponse> listarUsuariosTodo();
	
	public List<GerenciaResponse> listaGerencias();
	
	public List<GerenciaResponse> listaGerenciasId(int idGerencia);
	
	public List<RecursosPersonaResponse> listaGerencia(int id);
	
	public void crearUsuario(UsuarioRequest request);
	
	public void modificarUsuario(int idUsuario, @RequestBody UsuarioRequest request);
	
}
