package com.bim.reporte.proyecto.response.feign.gerencia;


import java.util.List;
import java.util.Set;

import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;
import com.bim.reporte.proyecto.response.feign.usuarios.RolResponse;

import lombok.Data;


@Data
public class RecursosResponse {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean status;
	private Set<GerenciaResponse> gerencia;
	private Set<RolResponse> rol;
}
