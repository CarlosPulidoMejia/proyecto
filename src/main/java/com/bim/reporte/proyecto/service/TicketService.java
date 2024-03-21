package com.bim.reporte.proyecto.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bim.reporte.proyecto.request.feign.ticket.TicketRequest;
import com.bim.reporte.proyecto.response.feign.TicketResponse;

public interface TicketService {

	public void leerArchivo(@RequestParam("file") MultipartFile file);
	
	public List<TicketResponse> listaTicket();
	
	public void modificarTicket(@PathVariable("idTicket") int idTicket,@RequestBody TicketRequest ticketRequest);
	
}
