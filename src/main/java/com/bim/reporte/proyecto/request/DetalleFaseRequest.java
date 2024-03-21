package com.bim.reporte.proyecto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleFaseRequest {
	private int id_fase;
	private boolean status;
	private String tipo_fase_vch;
}
