package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.entity.DetalleProyecto;
import com.bim.reporte.proyecto.entity.Proyecto;
import com.bim.reporte.proyecto.request.DetalleProyectoRequest;
import com.bim.reporte.proyecto.request.ObjetivoRequest;
import com.bim.reporte.proyecto.request.ProyectoRequest;
import com.bim.reporte.proyecto.response.ListaProyectoResponse;
import com.bim.reporte.proyecto.response.ProyectoResponse;
import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;

public interface ProyectoService {

	public List<ListaProyectoResponse> listaProyectos();
	
	public ProyectoResponse guardarProyecto(ProyectoRequest proyectoRequest);
	
	public void crearObjetivos(ObjetivoRequest objetivo);
	
	public void modificarDetalle(int idDetalle,DetalleProyectoRequest detalleProyecto);
	
	

}
