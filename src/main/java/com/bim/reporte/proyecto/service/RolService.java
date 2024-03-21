package com.bim.reporte.proyecto.service;

import java.util.List;

import com.bim.reporte.proyecto.response.feign.rol.RolRequest;
import com.bim.reporte.proyecto.response.feign.rol.RolResponse;

public interface RolService {

	public List<RolResponse> listaRoles();
	
	public void crearRol(RolRequest rolRequest);
}
