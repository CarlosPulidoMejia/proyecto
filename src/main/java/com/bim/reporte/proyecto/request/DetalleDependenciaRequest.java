package com.bim.reporte.proyecto.request;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleDependenciaRequest {
	private int id_dependencia;
	private boolean status;
	private String tipo_dependencia_vch;
}
