package com.bim.reporte.proyecto.response.feign;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoProyectoResponse {
	public int idTipoProyecto;
	public boolean status;
	public String tipoProyecto;
}
