package com.bim.reporte.proyecto.response.feign;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoEstadoProyectoResponse {

	public int idTipoEstado;
	private boolean status;
	public String tipoEstado;
	
}
