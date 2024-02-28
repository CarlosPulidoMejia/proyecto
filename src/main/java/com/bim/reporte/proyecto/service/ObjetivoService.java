package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.request.DetalleObjetivoRequest;
import com.bim.reporte.proyecto.response.ObjetivoResponse;

public interface ObjetivoService {

	public void comentariosObjetivo(int idProyecto,DetalleObjetivoRequest detalleObjetivoRequest);
	
	public List<ObjetivoResponse> listaObjetivoProyecto(int idProyecto);
	
	public void modificarObjetivo (int idObjetivo,DetalleObjetivoRequest detalleObjetivoRequest);
}
