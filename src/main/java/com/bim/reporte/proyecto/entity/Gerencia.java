package com.bim.reporte.proyecto.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="gerencia")
public class Gerencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGerencia;
	
	private String gerencia;
	
	@OneToMany(mappedBy = "gerencia")
	private List<Usuario> usuarios;

}
