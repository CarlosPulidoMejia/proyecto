package com.bim.reporte.proyecto.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Data

public class Gerencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerencia")
	private int idGerencia;
	
	private String gerencia;
	
	/*@OneToMany(mappedBy = "gerencia")
	private List<Usuario> usuarios;*/

}
