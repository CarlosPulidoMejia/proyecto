package com.bim.reporte.proyecto.response.feign;

import lombok.Data;

@Data
public class UsuarioResponseFeign {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean status;
}
