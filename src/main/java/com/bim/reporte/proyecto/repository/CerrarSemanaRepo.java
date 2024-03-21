package com.bim.reporte.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.bim.reporte.proyecto.entity.Proyecto;

public interface CerrarSemanaRepo extends JpaRepository<Proyecto, Integer> {

	@Procedure("cerrarsemanahis")
	public void cerrarSemanaHis(@Param("fecha") String model );
}
