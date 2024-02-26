package com.bim.reporte.proyecto.response.feign.gerencia;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaResponse {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean status;
	//private Set<GerenciaResponse> gerencia;
	
}
