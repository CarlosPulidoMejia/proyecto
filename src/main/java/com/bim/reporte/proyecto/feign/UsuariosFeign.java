package com.bim.reporte.proyecto.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bim.reporte.proyecto.response.feign.UsuarioResponseFeign;
import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosPersonaResponse;
import com.bim.reporte.proyecto.response.feign.gerencia.RecursosResponse;

@FeignClient(name="usuario-service",url = "http://localhost:8083")
public interface UsuariosFeign {
	
	@GetMapping("/usuario/listar")
	public List<UsuarioResponseFeign> listarUsuario();
	
	@GetMapping("/usuario/listaRecursos")
	public List<RecursosResponse> listarRecursos();
	
	@GetMapping("/gerencia/listar")
	public List<GerenciaResponse> listarGerencia();
	
	@GetMapping("/usuario/recursosGerencia/{idGerencia}")
	public List<GerenciaResponse> listarGerenciaId(@PathVariable("idGerencia") int idGerencia);
	
	@GetMapping("/usuario/recursosGerencia/{idGerencia}")
	public List<RecursosPersonaResponse> listar(@PathVariable("idGerencia") int idGerencia);
	
	@GetMapping("/usuario/test/{id}")
	public List<RecursosPersonaResponse> listaGerencia(@PathVariable("id") int idGerencia);

}
