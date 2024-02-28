package com.bim.reporte.proyecto.entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data

public class Gerencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerencia")
	private int idGerencia;
	
	private String gerencia;
	
	/*@ManyToMany
    @JoinTable(name = "usuario_gerencia",
        joinColumns =@JoinColumn(name="id_gerencia"),
        inverseJoinColumns = @JoinColumn(name= "id_usuario"))
	private List<Usuario> usuarios;*/
	
	@ManyToMany(mappedBy = "gerencias")
	@JsonIgnore
    private List<Usuario> usuarios;
	
	
}
