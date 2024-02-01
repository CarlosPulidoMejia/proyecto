package com.bim.reporte.proyecto.request;

import java.util.List;

import lombok.Data;

@Data
public class ObjetivoRequest {

	private int idProyecto;
	private List<DetalleObjetivo> objetivo;
}
