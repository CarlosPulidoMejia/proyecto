package com.bim.reporte.proyecto.service;

import java.util.List;


import com.bim.reporte.proyecto.request.DetalleDependenciaRequest;
import com.bim.reporte.proyecto.request.DetalleDocumentacionRequest;
import com.bim.reporte.proyecto.request.DetalleEstadoProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleFaseRequest;
import com.bim.reporte.proyecto.response.feign.TipoDependenciaResponse;
import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoEstadoProyectoResponse;
import com.bim.reporte.proyecto.response.feign.TipoFaseResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;

public interface CatalogoService {

	public List<TipoProyectoResponse> listarTipoProy();
	
	public List<TipoDocumentacionResponse> listarTipoDoc();
	
	public List<TipoFaseResponse> listarTipoFase();
	
	public List<TipoDependenciaResponse> listarTipoDependencia();
	
	public List<TipoEstadoProyectoResponse> listarTipoEstado();
	
	public void modificarDependencia(int id,DetalleDependenciaRequest dependencia);
	
	public void crearDependencia (DetalleDependenciaRequest dependencia);
	
	public void modificarDocumentacion (int id, DetalleDocumentacionRequest detalleReq);
	
	public void crearDocumentacion (DetalleDocumentacionRequest documentacion);
	
	public void modificarEstado (int id,  DetalleEstadoProyectoRequest detalleReq);
	
	public void crearEstado ( DetalleEstadoProyectoRequest estado);
	
	public void modificarFase (int id, DetalleFaseRequest fase);
	
	public void crearFase (DetalleFaseRequest fase);
}
