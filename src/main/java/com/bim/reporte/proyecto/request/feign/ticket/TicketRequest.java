package com.bim.reporte.proyecto.request.feign.ticket;

import lombok.Data;

@Data
public class TicketRequest {

	private int idUsuario;
	
	private float horas;
	
	private int tipoTicket;
}
