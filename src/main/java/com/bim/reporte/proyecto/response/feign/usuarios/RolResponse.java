package com.bim.reporte.proyecto.response.feign.usuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RolResponse {

	private int idRol;
	private String permiso;
}
