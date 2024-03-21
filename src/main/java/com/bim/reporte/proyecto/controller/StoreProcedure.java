package com.bim.reporte.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.proyecto.repository.ProyectoRepo;
import com.bim.reporte.proyecto.response.reportedc.GestionRecursosResponse;
import com.bim.reporte.proyecto.response.reportedc.ResultadoDatos;
import com.bim.reporte.proyecto.response.reportedc.ResultadoDatos;

@RestController
public class StoreProcedure {

	@Autowired
	private ProyectoRepo proyectoRepo;
	
	@GetMapping("store")
	public void store() {
		
		int counts=0;
		int test = 0;
        
		/*GestionRecursosResponse dt =  proyectoRepo.recursosResponse();
		
		System.out.println("DT " + dt.getrecursouno() );
		System.out.println("id_det " + dt.getrecursodos() );*/
		
		System.out.println("test:" + counts);
		//System.out.println("id_det:" + iddet);
		//System.out.println(resul);
		/*ResultadoDatos resultado = new ResultadoDatos();
		
		resul.setTotalPersonas(totalPersonas);
		resul.setTotalEmpleadosActivos(totalEmpleadosActivos);
        
        
        System.out.println("proyectos: " + resultado.getTotalPersonas());
        System.out.println("usuarios: " + resultado.getTotalEmpleadosActivos());*/
	}
}
