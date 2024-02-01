package com.bim.reporte.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bim.reporte.proyecto.entity.DetalleProyecto;

import feign.Param;

@Repository
public interface DetalleProyectoRepo extends JpaRepository<DetalleProyecto, Integer>{

	//DetalleProyecto findBycatProyecto(int idProyecto);
	@Query(value = "SELECT id_detalle FROM detalle_proyecto WHERE id_proyecto=:idProyecto",nativeQuery = true)
	int obtenerDetalle(@Param("idProyecto") int idProyecto);
	

}
