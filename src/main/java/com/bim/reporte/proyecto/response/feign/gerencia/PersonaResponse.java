package com.bim.reporte.proyecto.response.feign.gerencia;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaResponse {

	
	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean status;
	//private Set<GerenciaResponse> gerencia;
	
	
	
}
