package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.bim.reporte.proyecto.request.feign.ticket.TicketRequest;
import com.bim.reporte.proyecto.response.feign.TicketResponse;


@FeignClient(name="ticket-service",url = "http://localhost:8084")
public interface TicketFeign {

	@PostMapping(value = "/ticket/cargarInfo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
	public void leerArchivo(@RequestPart("file") MultipartFile file);
	
	@GetMapping("/ticket/listar")
	public List<TicketResponse> listaTicket();
	
	@PutMapping("/ticket/modificar/{idTicket}")
	public void modificarTicket(@PathVariable("idTicket") int idTicket,@RequestBody TicketRequest ticketRequest);
	
}
