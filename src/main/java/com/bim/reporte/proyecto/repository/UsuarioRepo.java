package com.bim.reporte.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bim.reporte.proyecto.entity.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

}
