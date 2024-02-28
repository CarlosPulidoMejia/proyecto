package com.bim.reporte.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bim.reporte.proyecto.entity.Proyecto;

public interface ProyectoRepo extends JpaRepository<Proyecto, Integer>{

	@Query("SELECT p FROM Proyecto p JOIN p.gerencia g WHERE g.idGerencia = :idGerencia")
	public List<Proyecto> listaProyeGerencia(@Param("idGerencia") int idGerencia);
	
	@Query("SELECT p FROM Proyecto p JOIN p.gerencia g JOIN p.usuario u WHERE g.idGerencia = :idGerencia AND u.idUsuario= :idUsuario")
	public List<Proyecto> listaProyeGerenciaRecurso(@Param("idGerencia") int idGerencia,@Param("idUsuario") int idUsuario);
	
	@Query("SELECT p FROM Proyecto p JOIN p.usuario u WHERE u.idUsuario= :idUsuario")
	public List<Proyecto> listaProyectoRecurso(@Param("idUsuario") int idUsuario);
	
	/*@Transactional
	@Modifying
	@Query("UPDATE Proyecto p SET p.gerencia = :nuevaGerencia WHERE p.idProyecto = :idProyecto")
	void actualizarGerencia(@Param("nuevaGerencia") int nuevaGerencia,@Param("idProyecto") int idProyecto);*/
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE proyecto_recurso SET id_gerencia = :nuevaGerencia WHERE id_proyecto = :idProyecto", nativeQuery = true)
	void actualizarGerencia(@Param("nuevaGerencia") int nuevaGerenciaId, @Param("idProyecto") int idProyecto);
	
}
