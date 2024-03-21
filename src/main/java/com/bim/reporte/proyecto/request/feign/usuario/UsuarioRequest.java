package com.bim.reporte.proyecto.request.feign.usuario;

import lombok.Data;

@Data
public class UsuarioRequest {

	private int idGerencia;
	private int idGerenciaAntes;
	private String apellido;
	private String correo;
	private String nombre;
	private boolean status;
	private int idRol;
}
