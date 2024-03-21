package com.bim.reporte.proyecto.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.entity.Objetivo;
import com.bim.reporte.proyecto.entity.Proyecto;
import com.bim.reporte.proyecto.repository.ObjetivoRepo;
import com.bim.reporte.proyecto.request.ComentarioProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleComentarioRequest;
import com.bim.reporte.proyecto.request.DetalleObjetivoRequest;
import com.bim.reporte.proyecto.response.ObjetivoResponse;
import com.bim.reporte.proyecto.service.ObjetivoService;
import com.bim.reporte.proyecto.service.ProyectoService;

@Service
public class ObjetivoServiceImpl implements ObjetivoService{
	
	@Autowired
	private ObjetivoRepo objetivoRepo;
	
	@Autowired
	private ProyectoService proyectoService;

	@Override
	public void comentariosObjetivo(int idProyecto,ComentarioProyectoRequest comentarioProyectoRequest) {
		// TODO Auto-generated method stub
		/*Optional<Objetivo> optObjetivoEnt = objetivoRepo.findById(detalleObjetivoRequest.getIdObjetivo());
		
		Objetivo objetivoEnt = optObjetivoEnt.get();
		
		objetivoEnt.setComentarioDetalle("Test");
		objetivoEnt.setStatus(detalleObjetivoRequest.getStatus());
		
		objetivoRepo.save(objetivoEnt);*/
		
		proyectoService.comentarioProyecto(idProyecto,comentarioProyectoRequest);
		
		
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
						lstObjetivo.getIdObjetivo(),
						lstObjetivo.getDetalle(),
						lstObjetivo.getComentarioDetalle(),
						true
						)).collect(Collectors.toList());
		
		/*List<ObjetivoResponse> lstObjetivoResponses = lstObjetivoEnt.stream()
				.map(lstObjetivo -> {
					ObjetivoResponse objetivoResponse = new ObjetivoResponse();
					objetivoResponse.setIdProyecto(lstObjetivo.getIdObjetivo());
					
					objetivoResponse.setObjetivos(lstObjetivo.ge)
					return objetivoResponse;
				}).collect(Collectors.toList());*/
		return lstObjetivoResponses;
	}

	@Override
	public void modificarObjetivo(int idObjetivo,DetalleObjetivoRequest detalleObjetivoRequest) {
		// TODO Auto-generated method stub
		Optional<Objetivo> optObjetivoEnt = objetivoRepo.findById(idObjetivo);
		
		
		Objetivo objetivoEnt = optObjetivoEnt.get();
		
		objetivoEnt.setComentarioDetalle(detalleObjetivoRequest.getDetalleObjetivo());
		objetivoEnt.setStatus(detalleObjetivoRequest.getStatus());
		
		
		
		objetivoRepo.save(objetivoEnt);
		
		//proyectoService.comentarioProyecto(detalleObjetivoRequest);
	}

	@Override
	public List<ObjetivoResponse> listaObjetivoProyectoSemana(int idProyecto) {
		// TODO Auto-generated method stub
		System.out.println("TEST: " + idProyecto);
		List<Objetivo> lstObjetivoEnt = objetivoRepo.listaObjetivoProySemana(idProyecto);
		
		List<ObjetivoResponse> lstObjetivoResponses = lstObjetivoEnt.stream()
				.map(lstObjetivo ->
				new ObjetivoResponse( 
						lstObjetivo.getProyecto().getIdProyecto(),
						lstObjetivo.getIdObjetivo(),
						lstObjetivo.getDetalle(),
						lstObjetivo.getComentarioDetalle(),
						true
						)).collect(Collectors.toList());
		
		/*List<ObjetivoResponse> lstObjetivoResponses = lstObjetivoEnt.stream()
				.map(lstObjetivo -> {
					ObjetivoResponse objetivoResponse = new ObjetivoResponse();
					objetivoResponse.setIdProyecto(lstObjetivo.getIdObjetivo());
					
					objetivoResponse.setObjetivos(lstObjetivo.ge)
					return objetivoResponse;
				}).collect(Collectors.toList());*/
		return lstObjetivoResponses;
	}

}
