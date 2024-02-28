package com.bim.reporte.proyecto.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.feign.UsuariosFeign;
import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;
import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosPersonaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosResponse;
import com.bim.reporte.proyecto.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuariosFeign usuariosFeign;
	
	@Override
	public List<UsuarioResponseFeign> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuariosFeign.listarUsuario();
	}

	@Override
	public List<GerenciaResponse> listaGerencias() {
		// TODO Auto-generated method stub
		return usuariosFeign.listarGerencia();
	}

	@Override
	public List<GerenciaResponse> listaGerenciasId(int idGerencia) {
		// TODO Auto-generated method stub
		return usuariosFeign.listarGerenciaId(idGerencia);
	}

	@Override
	public List<RecursosPersonaResponse> listaGerencia(int id) {
		// TODO Auto-generated method stub
		return usuariosFeign.listaGerencia(id);
	}

	@Override
	public List<RecursosResponse> listarUsuariosTodo() {
		// TODO Auto-generated method stub
		return usuariosFeign.listarRecursos();
	}
	
	

}
