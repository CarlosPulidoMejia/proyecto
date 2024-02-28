package com.bim.reporte.proyecto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleEstadoProyectoRequest {
	private int id_estado;
	private boolean status;
	private String tipo_estado_vch;
}
