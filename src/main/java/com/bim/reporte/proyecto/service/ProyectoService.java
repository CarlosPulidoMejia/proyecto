package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.entity.Proyecto;
import com.bim.reporte.proyecto.request.DetalleProyectoRequest;
import com.bim.reporte.proyecto.request.ObjetivoRequest;
import com.bim.reporte.proyecto.request.ProyectoRequest;
import com.bim.reporte.proyecto.response.ListaProyectoRecursoResponse;
import com.bim.reporte.proyecto.response.ListaProyectoResponse;
import com.bim.reporte.proyecto.response.ProyectoResponse;

public interface ProyectoService {

	public List<ListaProyectoResponse> listaProyectos();
	
	public List<ListaProyectoRecursoResponse> listaProyectosRecurso();
	
	public List<ListaProyectoRecursoResponse> listaProyectosGerencia(int idGerencia);
	
	public List<ListaProyectoRecursoResponse> listaProyectosGerenciaRecurso(int idGerencia,int idRecurso);
	
	public List<ListaProyectoRecursoResponse> listaProyectosGerencia(int idGerencia);
	
	public List<ListaProyectoRecursoResponse> listaProyectosGerenciaRecurso(int idGerencia,int idRecurso);
	
	public List<ListaProyectoRecursoResponse> listaProyectosRecurso(int idRecurso);
	
	public ProyectoResponse guardarProyecto(ProyectoRequest proyectoRequest);
	
	public void crearObjetivos(ObjetivoRequest objetivo);
	
	public void modificarDetalle(int idDetalle,DetalleProyectoRequest detalleProyecto);
	
	public List<Proyecto> listaUsu(); 
	
	

}
