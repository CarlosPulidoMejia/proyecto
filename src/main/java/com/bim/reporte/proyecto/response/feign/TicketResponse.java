package com.bim.reporte.proyecto.response.feign;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
	
	private int idTicket;
	
	private int numero;
	
	private String fechaInicio;
	
	private String fechaFin;
	
	private String estado;
	
	private String prioridad;
	
	private String Gerencia;
	
	private String tipoSolicitud;
	
	private String descripcion;
	
	private String usuario;
}
