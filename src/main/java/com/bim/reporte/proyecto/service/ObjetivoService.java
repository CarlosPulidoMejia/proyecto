package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.request.ComentarioProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleComentarioRequest;
import com.bim.reporte.proyecto.request.DetalleObjetivoRequest;
import com.bim.reporte.proyecto.response.ObjetivoResponse;

public interface ObjetivoService {

	public void comentariosObjetivo(int idProyecto,ComentarioProyectoRequest comentarioProyectoRequest);
	
	public List<ObjetivoResponse> listaObjetivoProyecto(int idProyecto);
	
	public List<ObjetivoResponse> listaObjetivoProyectoSemana(int idProyecto);
	
	public void modificarObjetivo (int idObjetivo,DetalleObjetivoRequest detalleObjetivoRequest);
}
