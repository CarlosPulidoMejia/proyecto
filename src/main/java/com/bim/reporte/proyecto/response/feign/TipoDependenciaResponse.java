package com.bim.reporte.proyecto.response.feign;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDependenciaResponse {
	public int idDependencia;
	public boolean status;

	public String tipoDependencia;
}
