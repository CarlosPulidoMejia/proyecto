package com.bim.reporte.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bim.reporte.proyecto.entity.Objetivo;

public interface ObjetivoRepo extends JpaRepository<Objetivo, Integer>{

	
	@Query("SELECT o FROM Objetivo o JOIN o.proyecto p WHERE p.idProyecto= :idProyecto and o.status=0")
	public List<Objetivo> listaObjetivoProy(@Param("idProyecto") int idProyecto);
	
	@Query("SELECT o FROM Objetivo o JOIN o.proyecto p WHERE p.idProyecto= :idProyecto and o.status=1")
	public List<Objetivo> listaObjetivoProySemana(@Param("idProyecto") int idProyecto);
}
