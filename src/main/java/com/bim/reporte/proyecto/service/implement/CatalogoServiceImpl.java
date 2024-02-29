package com.bim.reporte.proyecto.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.feign.TipoProyectoFeign;
import com.bim.reporte.proyecto.request.DetalleDependenciaRequest;
import com.bim.reporte.proyecto.request.DetalleDocumentacionRequest;
import com.bim.reporte.proyecto.request.DetalleEstadoProyectoRequest;
import com.bim.reporte.proyecto.request.DetalleFaseRequest;
import com.bim.reporte.proyecto.response.feign.TipoDependenciaResponse;
import com.bim.reporte.proyecto.response.feign.TipoDocumentacionResponse;
import com.bim.reporte.proyecto.response.feign.TipoEstadoProyectoResponse;
import com.bim.reporte.proyecto.response.feign.TipoFaseResponse;
import com.bim.reporte.proyecto.response.feign.TipoProyectoResponse;
import com.bim.reporte.proyecto.service.CatalogoService;

@Service
public class CatalogoServiceImpl implements CatalogoService{
	
	@Autowired
	private TipoProyectoFeign proyectoFeign;

	@Override
	public List<TipoProyectoResponse> listarTipoProy() {
			return proyectoFeign.listarTipoProyecto();
	}

	@Override
	public List<TipoDocumentacionResponse> listarTipoDoc() {
		// TODO Auto-generated method stub
		return proyectoFeign.listarTipoDocumentacion();
	}

	@Override
	public List<TipoFaseResponse> listarTipoFase() {
		// TODO Auto-generated method stub
		return proyectoFeign.listarTipoFase();
	}

	@Override
	public List<TipoDependenciaResponse> listarTipoDependencia() {
		// TODO Auto-generated method stub
		return proyectoFeign.listarTipoDependencia();
	}

	@Override
	public List<TipoEstadoProyectoResponse> listarTipoEstado() {
		// TODO Auto-generated method stub
		return proyectoFeign.listarTipoEstado();
	}

	@Override
	public void modificarDependencia(int id, DetalleDependenciaRequest dependenciaRequest) {
		// TODO Auto-generated method stub
		proyectoFeign.modificarDependencia(id, dependenciaRequest);
	}

	@Override
	public void crearDependencia(DetalleDependenciaRequest dependencia) {
		// TODO Auto-generated method stub
		proyectoFeign.crearDependencia(dependencia);
	}

	@Override
	public void modificarDocumentacion(int id, DetalleDocumentacionRequest detalleReq) {
		// TODO Auto-generated method stub
		proyectoFeign.modificarDocumentacion(id, detalleReq);
	}

	@Override
	public void crearDocumentacion(DetalleDocumentacionRequest documentacion) {
		// TODO Auto-generated method stub
		proyectoFeign.crearDocumentacion(documentacion);
	}

	@Override
	public void modificarEstado(int id, DetalleEstadoProyectoRequest detalleReq) {
		// TODO Auto-generated method stub
		proyectoFeign.modificarEstado(id, detalleReq);
	}
	
	@Override
	public void modificarFase(int id, DetalleFaseRequest fase) {
		// TODO Auto-generated method stub
		proyectoFeign.modificarFase(id, fase);
	}

	@Override
	public void crearFase(DetalleFaseRequest fase) {
		// TODO Auto-generated method stub
		proyectoFeign.crearFase(fase);
	}
}
