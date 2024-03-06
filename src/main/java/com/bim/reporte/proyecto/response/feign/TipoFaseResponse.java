package com.bim.reporte.proyecto.response.feign;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoFaseResponse {

	private int idFase;
	private boolean status;
	private String fase;
}
