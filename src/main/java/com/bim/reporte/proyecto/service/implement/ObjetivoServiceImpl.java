package com.bim.reporte.proyecto.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.entity.Objetivo;
import com.bim.reporte.proyecto.repository.ObjetivoRepo;
import com.bim.reporte.proyecto.request.DetalleObjetivoRequest;
import com.bim.reporte.proyecto.response.ObjetivoResponse;
import com.bim.reporte.proyecto.service.ObjetivoService;

@Service
public class ObjetivoServiceImpl implements ObjetivoService{
	
	@Autowired
	private ObjetivoRepo objetivoRepo;

	@Override
	public void comentariosObjetivo(int idProyecto,DetalleObjetivoRequest detalleObjetivoRequest) {
		// TODO Auto-generated method stub
		Optional<Objetivo> optObjetivoEnt = objetivoRepo.findById(detalleObjetivoRequest.getIdObjetivo());
		
		Objetivo objetivoEnt = optObjetivoEnt.get();
		
		objetivoEnt.setComentarioDetalle("Test");
		objetivoEnt.setStatus(true);
		
		objetivoRepo.save(objetivoEnt);
		
		
	}

	@Override
	public List<ObjetivoResponse> listaObjetivoProyecto(int idProyecto) {
		// TODO Auto-generated method stub
		System.out.println("TEST: " + idProyecto);
		List<Objetivo> lstObjetivoEnt = objetivoRepo.listaObjetivoProy(idProyecto);
		
		List<ObjetivoResponse> lstObjetivoResponses = lstObjetivoEnt.stream()
				.map(lstObjetivo ->
				new ObjetivoResponse( 
						lstObjetivo.getProyecto().getIdProyecto(),
						lstObjetivo.getDetalle(),
						lstObjetivo.getComentarioDetalle(),
						true
						)).collect(Collectors.toList());
		return lstObjetivoResponses;
	}

	@Override
	public void modificarObjetivo(int idObjetivo,DetalleObjetivoRequest detalleObjetivoRequest) {
		// TODO Auto-generated method stub
		Optional<Objetivo> optObjetivoEnt = objetivoRepo.findById(idObjetivo);
		
		Objetivo objetivoEnt = optObjetivoEnt.get();
		
		objetivoEnt.setComentarioDetalle(detalleObjetivoRequest.getComentario());
		objetivoEnt.setStatus(detalleObjetivoRequest.getStatus());
		
		objetivoRepo.save(objetivoEnt);
	}

}
