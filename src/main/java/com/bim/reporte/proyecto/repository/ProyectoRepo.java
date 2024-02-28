package com.bim.reporte.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bim.reporte.proyecto.entity.Proyecto;

public interface ProyectoRepo extends JpaRepository<Proyecto, Integer>{

	@Query("SELECT u FROM Proyecto u JOIN u.usuario r WHERE r.idUsuario = :idRol")
	List<Proyecto> buscarUsuariosPorIdRol(@Param("idRol") int idRol);
	

	@Query("SELECT u FROM Proyecto u JOIN u.gerencia g WHERE g.idGerencia = :idRol")
	List<Proyecto> buscarUsuariosPorIdGeren(@Param("idRol") int idRol);
	
	@Query("SELECT u FROM Proyecto u JOIN u.usuario r JOIN u.gerencia g WHERE g.idGerencia = :idRol AND r.idUsuario = :idRolUsu")
	List<Proyecto> buscarUsuariosPorIdGerenRec(@Param("idRol") int idRol,@Param("idRolUsu") int idRolUsu);
}
