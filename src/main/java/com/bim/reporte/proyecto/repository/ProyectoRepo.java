package com.bim.reporte.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bim.reporte.proyecto.entity.Proyecto;

public interface ProyectoRepo extends JpaRepository<Proyecto, Integer>{

	@Query("SELECT p FROM Proyecto p JOIN p.gerencia g WHERE g.idGerencia = :idGerencia")
	public List<Proyecto> listaProyeGerencia(@Param("idGerencia") int idGerencia);
	
	@Query("SELECT p FROM Proyecto p JOIN p.gerencia g JOIN p.usuario u WHERE g.idGerencia = :idGerencia AND u.idUsuario= :idUsuario")
	public List<Proyecto> listaProyeGerenciaRecurso(@Param("idGerencia") int idGerencia,@Param("idUsuario") int idUsuario);
	
	@Query("SELECT p FROM Proyecto p JOIN p.usuario u WHERE u.idUsuario= :idUsuario")
	public List<Proyecto> listaProyectoRecurso(@Param("idUsuario") int idUsuario);
}
