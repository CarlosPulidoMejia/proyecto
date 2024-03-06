package com.bim.reporte.proyecto.response.feign;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDocumentacionResponse {

	private int idDocumentacion;
	private boolean status;
	private String documentacion;
}
