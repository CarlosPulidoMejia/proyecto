package com.bim.reporte.proyecto.service.implement;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bim.reporte.proyecto.response.feign.gerencia.GerenciaResponse;
import com.bim.reporte.proyecto.service.GerenciaService;

@Service
public class GerenciaServiceImpl implements GerenciaService{

	//@Autowired
	//private List
	@Override
	public List<GerenciaResponse> listaGerencias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GerenciaResponse> listaGerenciasId(int idGerencia) {
		// TODO Auto-generated method stub
		return null;
	}

}
