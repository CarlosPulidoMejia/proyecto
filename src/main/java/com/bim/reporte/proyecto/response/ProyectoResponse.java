package com.bim.reporte.proyecto.response;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProyectoResponse {

	public int idProyecto;

	public String proyecto;
	
	//public DetalleProyectoResponse detalleProyecto;
	
	

	//private float horas;
	
	/*public ProyectoResponse(int idProyecto2, String proyecto2, float hrsAtencion) {
		// TODO Auto-generated constructor stub
		this.idProyecto = idProyecto2;
		this.proyecto = proyecto2;
		this.detalleProyecto.setHrsatencion(hrsAtencion);
	}*/
	
}
