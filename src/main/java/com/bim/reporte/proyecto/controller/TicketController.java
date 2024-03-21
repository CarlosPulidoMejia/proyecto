package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bim.reporte.proyecto.request.feign.ticket.TicketRequest;
import com.bim.reporte.proyecto.response.feign.TicketResponse;
import com.bim.reporte.proyecto.service.TicketService;


@RestController
@CrossOrigin("*")
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/cargar")
	public void leerArchivo(@RequestParam("file") MultipartFile file) {
	
		System.out.println("Test");
		ticketService.leerArchivo(file);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<TicketResponse>> listaTicket(){
		return ResponseEntity.ok(ticketService.listaTicket());
	}
	
	@PutMapping("/modificar/{idTicket}")
	public void modificarTicket(@PathVariable("idTicket") int idTicket,@RequestBody TicketRequest ticketRequest) {
		ticketService.modificarTicket(idTicket, ticketRequest);
	}
}
