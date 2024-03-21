package com.bim.reporte.proyecto.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bim.reporte.proyecto.feign.TicketFeign;
import com.bim.reporte.proyecto.feign.TipoProyectoFeign;
import com.bim.reporte.proyecto.request.feign.ticket.TicketRequest;
import com.bim.reporte.proyecto.response.feign.TicketResponse;
import com.bim.reporte.proyecto.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketFeign ticketFeign;

	@Override
	public void leerArchivo(MultipartFile file) {
		// TODO Auto-generated method stub
		ticketFeign.leerArchivo(file);
	}

	@Override
	public List<TicketResponse> listaTicket() {
		// TODO Auto-generated method stub
		return ticketFeign.listaTicket();
	}

	@Override
	public void modificarTicket(int idTicket, TicketRequest ticketRequest) {
		// TODO Auto-generated method stub
		ticketFeign.modificarTicket(idTicket, ticketRequest);
	}
	
	
	
}
