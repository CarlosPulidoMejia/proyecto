package com.bim.reporte.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bim.reporte.proyecto.entity.Proyecto;
import com.bim.reporte.proyecto.response.reportedc.GestionRecursosResponse;
import com.bim.reporte.proyecto.response.reportedc.ResultadoDatos;

@Repository
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
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "CALL CerrarSemana(:idGerencia)")
    void cerrarSemanaProyectos(@Param("idGerencia")int idGerencia);
	
	/*@Transactional(readOnly = true)
	@Procedure("obtenerdatos")
	void obtenerDatos(@Param("counts")int counts);*/
	
	//@Query(value = "{call obtenerdatos()}",nativeQuery = true)
	
	@Transactional(readOnly = true)
	@Query(value = "{call obtenerdatos(@counts)}",nativeQuery = true)
	void obtenerDatos();
	
	/*@Query(value="SELECT id_proyecto AS id, id_detalle AS iddet  FROM detalle_proyecto",nativeQuery = true)
	public Datos conteoHoras();*/
	
	
	@Query(value = "SELECT \r\n"
			+ "(SELECT COUNT(*)  FROM detalle_proyecto\r\n"
			+ " inner join proyecto_recurso on detalle_proyecto.id_proyecto = proyecto_recurso.id_proyecto\r\n"
			+ "WHERE id_gerencia=1 and hrs_atencion>0\r\n"
			+ ") AS recursouno,\r\n"
			+ "COUNT(*) AS recursodos\r\n"
			+ " FROM detalle_proyecto\r\n"
			+ " inner join proyecto on detalle_proyecto.id_proyecto = proyecto.id_proyecto\r\n"
			+ "inner join proyecto_recurso ON proyecto_recurso.id_proyecto = proyecto_recurso.id_proyecto\r\n"
			+ "WHERE proyecto_recurso.id_gerencia =1",nativeQuery = true)
	public GestionRecursosResponse recursosResponse();
	
}
