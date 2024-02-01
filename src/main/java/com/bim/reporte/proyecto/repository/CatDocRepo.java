package com.bim.reporte.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bim.reporte.proyecto.entity.CatDocumentacion;

public interface CatDocRepo extends JpaRepository<CatDocumentacion, Integer>{

}
