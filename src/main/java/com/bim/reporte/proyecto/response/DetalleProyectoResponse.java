package com.bim.reporte.proyecto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetalleProyectoResponse {

	private int idDetalle;
	private String tipoProyecto;
	private float hrsAtencion;
	private String fechaInicio;
	private String fechaFin;
	private String faseProy;
	private String estadoProy;
	private String dependenciaProy;
	private int avance;
	private String docProy;
	/*private String fechaInicio;
	private String fechaFin;
	private String fase;*/
}
