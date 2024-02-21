package com.bim.reporte.proyecto.response.feign.gerencia;


import java.util.List;

import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;


import lombok.Data;


@Data
public class RecursosResponse {

	private GerenciaResponse gerencia;
	private List<UsuarioResponseFeign> usuarios;
	
	public RecursosResponse(GerenciaResponse gerencia, List<UsuarioResponseFeign> usuario) {
		super();
		this.gerencia = gerencia;
		this.usuarios = usuario;
	}
}
