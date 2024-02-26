package com.bim.reporte.proyecto.service.implement;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.entity.CatDependencias;
import com.bim.reporte.proyecto.entity.CatDocumentacion;
import com.bim.reporte.proyecto.entity.CatEstadoProyecto;
import com.bim.reporte.proyecto.entity.CatFase;
import com.bim.reporte.proyecto.entity.CatTipoProyecto;
import com.bim.reporte.proyecto.entity.DetalleProyecto;
import com.bim.reporte.proyecto.entity.Objetivo;
import com.bim.reporte.proyecto.entity.Proyecto;
import com.bim.reporte.proyecto.entity.Usuario;
import com.bim.reporte.proyecto.feign.TipoProyectoFeign;
import com.bim.reporte.proyecto.repository.CatDependenciaRepo;
import com.bim.reporte.proyecto.repository.CatDocRepo;
import com.bim.reporte.proyecto.repository.CatEstadoRepo;
import com.bim.reporte.proyecto.repository.CatFaseRepo;
import com.bim.reporte.proyecto.repository.CatTipoProyRepo;
import com.bim.reporte.proyecto.repository.DetalleProyectoRepo;
import com.bim.reporte.proyecto.repository.ObjetivoRepo;
import com.bim.reporte.proyecto.repository.ProyectoRepo;
import com.bim.reporte.proyecto.repository.UsuarioRepo;
import com.bim.reporte.proyecto.request.DetalleObjetivo;
import com.bim.reporte.proyecto.request.DetalleProyectoRequest;
import com.bim.reporte.proyecto.request.ObjetivoRequest;
import com.bim.reporte.proyecto.request.ProyectoRequest;
import com.bim.reporte.proyecto.response.DetalleProyectoResponse;
import com.bim.reporte.proyecto.response.ListaProyectoRecursoResponse;
import com.bim.reporte.proyecto.response.ListaProyectoResponse;
import com.bim.reporte.proyecto.response.ProyectoResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.PersonaResponse;
import com.bim.reporte.proyecto.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private CatDependenciaRepo catDependenciaRepo;
	
	@Autowired
	private CatDocRepo catDocRepo;
	
	@Autowired
	private CatEstadoRepo catEstadoRepo;
	
	@Autowired
	private CatFaseRepo catFaseRepo;
	
	@Autowired
	private CatTipoProyRepo catTipoProyRepo;
	
	@Autowired
	private ProyectoRepo proyectoRepo;
	
	@Autowired
	DetalleProyectoRepo detalleProyectoRepo;
	
	@Autowired
	private ObjetivoRepo objetivoRepo;
	
	@Autowired
	TipoProyectoFeign proyectoFeign;
	
	@Autowired
	private UsuarioRepo repo;
	
	
	
	
	@Override
	public List<ListaProyectoResponse> listaProyectos() {
		// TODO Auto-generated method stub
		List<Proyecto> lista = proyectoRepo.findAll();
		
		/*ProyectoResponse proyResponse = new ProyectoResponse();
		
		DetalleProyectoResponse detalleProyectoResponse = new DetalleProyectoResponse(0);
		
		detalleProyectoResponse.setHrsatencion(0);
		
		p*/
		
		List<ListaProyectoResponse> detalleResponses = lista.stream()
				.map(proyecto -> 
				new ListaProyectoResponse(
						new ProyectoResponse(proyecto.getIdProyecto(), proyecto.getProyecto()),
						//proyecto.getRegistrations(),
						new DetalleProyectoResponse(
								proyecto.getDetalleProyecto().getIdDetalle(),
								proyecto.getDetalleProyecto().getCatTipoProyecto().getTipoProyecto(),
								proyecto.getDetalleProyecto().getHrsAtencion(),
								proyecto.getDetalleProyecto().getFechaInicio(),
								proyecto.getDetalleProyecto().getFechaFin(),
								proyecto.getDetalleProyecto().getCatFase().getTipoFase(),
								proyecto.getDetalleProyecto().getCatEstadoProyecto().getTipoEstado(),
								proyecto.getDetalleProyecto().getCatDependencias().getTipoDependencia(),
								proyecto.getDetalleProyecto().getAvance(),
								proyecto.getDetalleProyecto().getCatDocumentacion().getTipoDocumentacion()
								))
						//proyecto.getIdProyecto(),
						//proyecto.getProyecto())
				).collect(Collectors.toList());
		
		return detalleResponses;
	}

	@Override
	public ProyectoResponse guardarProyecto(ProyectoRequest proyectoRequest) {

		Proyecto proyecto = new Proyecto();
		
		System.out.println("nombre: " + proyectoRequest.getIdProyecto()); 
		
		System.out.println("Fecha inicio: " + proyectoRequest.getFechaInicio());
		System.out.println("Fecha fin: " + proyectoRequest.getFechaFin());
		proyecto.setProyecto(proyectoRequest.getProyecto());
		
		Set<Usuario> usuarioSet = new HashSet<>();
		//Set<Gerencia> gerenciaSet = new HashSet<>();
		
		Usuario usu = repo.findById(1).orElseThrow();
		
		
		
	    usuarioSet.add(usu);
		
		proyecto.setUsuario(usuarioSet);
		
		proyecto.getUsuario().add(usu);
		
		//Gerencia gerenEnt = gerenciaRepo.findById(1).orElseThrow();
		
		//gerenEnt.setIdGerencia();
		
		System.out.println("IP Proyecto: " + proyecto.getIdProyecto());
		
		
		
		//gerenciaSet.add(gerenEnt);
		
		//proyecto.setGerencia(gerenciaSet);
		
		//proyecto.getGerencia().add(gerenEnt);
	
		
		Proyecto proye = proyectoRepo.save(proyecto);
		
		System.out.println("ID_PROECTO: " + proye.getIdProyecto());
		
		proyectoRepo.actualizarGerencia(1,proye.getIdProyecto());
		
		DetalleProyecto det = new DetalleProyecto();
		
		CatTipoProyecto tipoProy = catTipoProyRepo.findById(proyectoRequest.getTipoProyecto()).orElseThrow();
		
		CatDocumentacion tipoDoc = catDocRepo.findById(proyectoRequest.getTipoDoc()).orElseThrow();
		
		CatDependencias catDependencia = catDependenciaRepo.findById(1).orElseThrow();
		
		CatEstadoProyecto catEstado = catEstadoRepo.findById(1).orElseThrow();
		
		CatFase catFase = catFaseRepo.findById(1).orElseThrow();
		
		//det.setCatFase(tipoProy);
		det.setFechaInicio(proyectoRequest.getFechaInicio());
		det.setFechaFin(proyectoRequest.getFechaFin());
		det.setCatTipoProyecto(tipoProy);
		det.setCatDocumentacion(tipoDoc);
		
		det.setCatDependencias(catDependencia);
		det.setCatEstadoProyecto(catEstado);
		det.setCatFase(catFase);
		
		det.setCatProyecto(proye);

		detalleProyectoRepo.save(det);
		
		//return new ProyectoResponse(creatProy.getIdProyecto(), creatProy.getProyecto(),crea);
		return null;
		//pruebas socket tls
	}

	@Override
	public void crearObjetivos(ObjetivoRequest objetivo) {
		// TODO Auto-generated method stub
		//DetalleProyecto detProy = detalleProyectoRepo.findById(null)
		Proyecto proyecto = proyectoRepo.findById(objetivo.getIdProyecto()).orElseThrow();
		
		List<DetalleObjetivo> objetivoRequest = objetivo.getObjetivo();
		
		//DetalleObjetivo detalleObjetivo = new DetalleObjetivo();
		
		
		
		List<Objetivo> listObj = new ArrayList<>();
		
		for(int i =0; i< objetivoRequest.size();i++) {
			//System.out.println("test: " +  objetivoRequest.);
			Objetivo obj = new Objetivo();
			System.out.println("com: " + objetivoRequest.get(i).getDetalle());
			//objetivo.setObjetivo(objetivoRequest);
			obj.setProyecto(proyecto);
			obj.setDetalle(objetivoRequest.get(i).getDetalle());
			listObj.add(obj);
			
		}
		
		if(proyecto!=null) {
			System.out.println("test 1");
			objetivoRepo.saveAll(listObj);
		}
		
		


		
		
	}

	@Override
	public void modificarDetalle(int idDetalle,DetalleProyectoRequest detalleProyectoRequest) {
		// TODO Auto-generated method stub
		int detalleProy = detalleProyectoRepo.obtenerDetalle(idDetalle);
		Optional<DetalleProyecto> detProy = detalleProyectoRepo.findById(detalleProy);
		//System.out.println("id:" + detProy.get().getCatProyecto().getIdProyecto());
		Optional<Proyecto> proyectoMod = proyectoRepo.findById(idDetalle);
		
		if(proyectoMod!=null) {
			DetalleProyecto detProyEnt = detProy.get();
			CatFase  catFaseEnt = catFaseRepo.findById(detalleProyectoRequest.getFase()).orElseThrow();
			CatEstadoProyecto  catEstadoEnt = catEstadoRepo.findById(detalleProyectoRequest.getEstado()).orElseThrow();
			CatDependencias  catDependenciaEnt = catDependenciaRepo.findById(detalleProyectoRequest.getDependencia()).orElseThrow();
			CatDocumentacion catDocuEnt = catDocRepo.findById(detalleProyectoRequest.getDocumentacion()).orElseThrow();
			
			detProyEnt.setHrsAtencion(detalleProyectoRequest.getHrsAtencion());
			//catFaseEnt.setIdTipoFase(detalleProyectoRequest.getFase());
			detProyEnt.setCatFase(catFaseEnt);
			detProyEnt.setCatEstadoProyecto(catEstadoEnt);
			detProyEnt.setCatDependencias(catDependenciaEnt);
			detProyEnt.setAvance(detalleProyectoRequest.getPorcentaje());
			detProyEnt.setCatDocumentacion(catDocuEnt);
			//detProy.get().setHrsAtencion(detalleProyectoRequest.getHrsAtencion());;
			//proyectoMod.setDetalleProyecto(detProy);
			
			detalleProyectoRepo.save(detProyEnt);
		}
		/*Proyecto proyectoMod = proyectoRepo.findById(detalleProyectoRequest.getIdProyecto()).orElseThrow();
		//DetalleProyecto detalleProyMod = detalleProyectoRepo.findBycatProyecto(proyectoMod.getIdProyecto());
		if(proyectoMod!=null) {
			DetalleProyecto detProy = new DetalleProyecto();
			detProy.setHrsAtencion(detalleProyectoRequest.getHrsAtencion());
			proyectoMod.setDetalleProyecto(detProy);
		}*/
	}

	@Override
	public List<Proyecto> listaProyectosRecurso() {
		// TODO Auto-generated method stub
		/*List<Proyecto> listaProyectoEnt = proyectoRepo.findAll();
		
		List<ListaProyectoRecursoResponse> listar = listaProyectoEnt.stream()
				.map(lst -> new ListaProyectoRecursoResponse(
						null,lst.getUsuario()
						)
						).collect(Collectors.toList());
		return listaProyectoEnt;*/
		
		return null;
		/*List<ListaProyectoRecursoResponse> listaProyectoResponselst = new ArrayList<>();
		
		ListaProyectoRecursoResponse listaProyectoResponse = new ListaProyectoRecursoResponse();
		List<PersonaResponse> listaPersonaRes = new ArrayList<>();
		for(Proyecto proyIt : listaProyectoEnt) {
			ProyectoResponse proyectoResponse = new ProyectoResponse();
			
			proyectoResponse.setIdProyecto(proyIt.getIdProyecto());
			proyectoResponse.setProyecto(proyIt.getProyecto());
			
			
			
			for(ProyectoRecurso proyRec: proyIt.getRegistrations()) {
				PersonaResponse personaResponse = new PersonaResponse();
				proyRec.getUsuario().getNombre();
				
				//listaPersonaRes.add(personaResponse);
			}
			
			listaProyectoResponse.setProyectoResponse(proyectoResponse);
			listaProyectoResponse.setRecurso(listaPersonaRes);
			listaProyectoResponselst.add(listaProyectoResponse);
			
		}
		
		return listaProyectoResponselst;*/
	}

	@Override
	public List<ListaProyectoRecursoResponse> listaProyectosGerencia(int idGerencia) {
		// TODO Auto-generated method stub
		List<Proyecto> listaProyectoEnt = proyectoRepo.listaProyeGerencia(idGerencia);
		
		List<ListaProyectoRecursoResponse> listaProyectoRecursoResponses = listaProyectoEnt.stream()
				.map(lstProy -> {
					ListaProyectoRecursoResponse proyectoRecursoResponse = new ListaProyectoRecursoResponse();
					ProyectoResponse proyectoResponse = new ProyectoResponse();
					DetalleProyectoResponse detalleProyectoResponse = new DetalleProyectoResponse();
					proyectoResponse.setIdProyecto(lstProy.getIdProyecto());
					proyectoResponse.setProyecto(lstProy.getProyecto());
					proyectoRecursoResponse.setProyecto(proyectoResponse);
					
					detalleProyectoResponse.setAvance(lstProy.getDetalleProyecto().getAvance());
					detalleProyectoResponse.setDependenciaProy(lstProy.getDetalleProyecto().getCatDependencias().getTipoDependencia());
					detalleProyectoResponse.setEstadoProy(lstProy.getDetalleProyecto().getCatEstadoProyecto().getTipoEstado());
					detalleProyectoResponse.setFaseProy(lstProy.getDetalleProyecto().getCatFase().getTipoFase());
					detalleProyectoResponse.setFechaFin(lstProy.getDetalleProyecto().getFechaFin());
					detalleProyectoResponse.setFechaInicio(lstProy.getDetalleProyecto().getFechaInicio());
					detalleProyectoResponse.setHrsAtencion(lstProy.getDetalleProyecto().getHrsAtencion());
					detalleProyectoResponse.setIdDetalle(lstProy.getDetalleProyecto().getIdDetalle());
					detalleProyectoResponse.setTipoProyecto(lstProy.getDetalleProyecto().getCatTipoProyecto().getTipoProyecto());
					
					proyectoRecursoResponse.setDetalleProyecto(detalleProyectoResponse);
					proyectoRecursoResponse.setRecursos(lstProy.getUsuario().stream()
							.map(lstProyUsu -> new PersonaResponse(
									lstProyUsu.getIdUsuario(),
									lstProyUsu.getNombre(),
									"",
									"",
									true
									)
								).collect(Collectors.toSet()));
					proyectoRecursoResponse.setGerencia(lstProy.getGerencia().stream()
							.map(lstProyGeren -> new GerenciaResponse(
									lstProyGeren.getIdGerencia(),
									lstProyGeren.getGerencia()
									)
								).collect(Collectors.toSet()));
					
					return proyectoRecursoResponse;
				}).collect(Collectors.toList());
	    
		return listaProyectoRecursoResponses;
	}

	@Override
	public List<ListaProyectoRecursoResponse> listaProyectosGerenciaRecurso(int idGerencia, int idRecurso) {
		// TODO Auto-generated method stub
		List<Proyecto> listaProyectoEnt = proyectoRepo.listaProyeGerenciaRecurso(idGerencia,idRecurso);
		
		List<ListaProyectoRecursoResponse> listaProyectoRecursoResponses = listaProyectoEnt.stream()
				.map(lstProy -> {
					ListaProyectoRecursoResponse proyectoRecursoResponse = new ListaProyectoRecursoResponse();
					ProyectoResponse proyectoResponse = new ProyectoResponse();
					DetalleProyectoResponse detalleProyectoResponse = new DetalleProyectoResponse();
					proyectoResponse.setIdProyecto(lstProy.getIdProyecto());
					proyectoResponse.setProyecto(lstProy.getProyecto());
					proyectoRecursoResponse.setProyecto(proyectoResponse);
					
					detalleProyectoResponse.setAvance(lstProy.getDetalleProyecto().getAvance());
					detalleProyectoResponse.setDependenciaProy(lstProy.getDetalleProyecto().getCatDependencias().getTipoDependencia());
					detalleProyectoResponse.setEstadoProy(lstProy.getDetalleProyecto().getCatEstadoProyecto().getTipoEstado());
					detalleProyectoResponse.setFaseProy(lstProy.getDetalleProyecto().getCatFase().getTipoFase());
					detalleProyectoResponse.setFechaFin(lstProy.getDetalleProyecto().getFechaFin());
					detalleProyectoResponse.setFechaInicio(lstProy.getDetalleProyecto().getFechaInicio());
					detalleProyectoResponse.setHrsAtencion(lstProy.getDetalleProyecto().getHrsAtencion());
					detalleProyectoResponse.setIdDetalle(lstProy.getDetalleProyecto().getIdDetalle());
					detalleProyectoResponse.setTipoProyecto(lstProy.getDetalleProyecto().getCatTipoProyecto().getTipoProyecto());
					
					proyectoRecursoResponse.setDetalleProyecto(detalleProyectoResponse);
					proyectoRecursoResponse.setRecursos(lstProy.getUsuario().stream()
							.map(lstProyUsu -> new PersonaResponse(
									lstProyUsu.getIdUsuario(),
									lstProyUsu.getNombre(),
									"",
									"",
									true
									)
								).collect(Collectors.toSet()));
					proyectoRecursoResponse.setGerencia(lstProy.getGerencia().stream()
							.map(lstProyGeren -> new GerenciaResponse(
									lstProyGeren.getIdGerencia(),
									lstProyGeren.getGerencia()
									)
								).collect(Collectors.toSet()));
					
					return proyectoRecursoResponse;
				}).collect(Collectors.toList());
	    
		return listaProyectoRecursoResponses;
	}

	@Override
	public List<ListaProyectoRecursoResponse> listaProyectosRecurso(int idRecurso) {
		// TODO Auto-generated method stub
		List<Proyecto> listaProyectoEnt = proyectoRepo.listaProyectoRecurso(idRecurso);
		
		List<ListaProyectoRecursoResponse> listaProyectoRecursoResponses = listaProyectoEnt.stream()
				.map(lstProy -> {
					ListaProyectoRecursoResponse proyectoRecursoResponse = new ListaProyectoRecursoResponse();
					ProyectoResponse proyectoResponse = new ProyectoResponse();
					DetalleProyectoResponse detalleProyectoResponse = new DetalleProyectoResponse();
					proyectoResponse.setIdProyecto(lstProy.getIdProyecto());
					proyectoResponse.setProyecto(lstProy.getProyecto());
					proyectoRecursoResponse.setProyecto(proyectoResponse);
					
					detalleProyectoResponse.setAvance(lstProy.getDetalleProyecto().getAvance());
					detalleProyectoResponse.setDependenciaProy(lstProy.getDetalleProyecto().getCatDependencias().getTipoDependencia());
					detalleProyectoResponse.setEstadoProy(lstProy.getDetalleProyecto().getCatEstadoProyecto().getTipoEstado());
					detalleProyectoResponse.setFaseProy(lstProy.getDetalleProyecto().getCatFase().getTipoFase());
					detalleProyectoResponse.setFechaFin(lstProy.getDetalleProyecto().getFechaFin());
					detalleProyectoResponse.setFechaInicio(lstProy.getDetalleProyecto().getFechaInicio());
					detalleProyectoResponse.setHrsAtencion(lstProy.getDetalleProyecto().getHrsAtencion());
					detalleProyectoResponse.setIdDetalle(lstProy.getDetalleProyecto().getIdDetalle());
					detalleProyectoResponse.setTipoProyecto(lstProy.getDetalleProyecto().getCatTipoProyecto().getTipoProyecto());
					
					proyectoRecursoResponse.setDetalleProyecto(detalleProyectoResponse);
					proyectoRecursoResponse.setRecursos(lstProy.getUsuario().stream()
							.map(lstProyUsu -> new PersonaResponse(
									lstProyUsu.getIdUsuario(),
									lstProyUsu.getNombre(),
									"",
									"",
									true
									)
								).collect(Collectors.toSet()));
					proyectoRecursoResponse.setGerencia(lstProy.getGerencia().stream()
							.map(lstProyGeren -> new GerenciaResponse(
									lstProyGeren.getIdGerencia(),
									lstProyGeren.getGerencia()
									)
								).collect(Collectors.toSet()));
					
					return proyectoRecursoResponse;
				}).collect(Collectors.toList());
	    
		return listaProyectoRecursoResponses;
	}

	
	
	
	/*public List<TipoProyectoResponse> listarTipoProy(){
		return proyectoFeign.listarTipoProyecto();
	}

	@Override
	public List<TipoDocumentacionResponse> listarTipoDoc() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
