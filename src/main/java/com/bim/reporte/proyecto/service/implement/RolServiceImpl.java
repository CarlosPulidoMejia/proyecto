package com.bim.reporte.proyecto.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.feign.UsuariosFeign;
import com.bim.reporte.proyecto.response.feign.rol.RolRequest;
import com.bim.reporte.proyecto.response.feign.rol.RolResponse;
import com.bim.reporte.proyecto.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	
	@Autowired
	private UsuariosFeign usuariosFeign;
	
	@Override
	public List<RolResponse> listaRoles() {
		// TODO Auto-generated method stub
		return usuariosFeign.listarRoles();
	}

	@Override
	public void crearRol(RolRequest rolRequest) {
		// TODO Auto-generated method stub
		usuariosFeign.crearRol(rolRequest);
	}

}
