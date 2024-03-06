package com.bim.reporte.proyecto.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="objetivo")
@Data
public class Objetivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_objetivo")
	private int idObjetivo;
	
	private int status;
	
	private String detalle;
	
	@Column(name = "comentario_detalle")
	private String comentarioDetalle;
	
	private String fechaCorteUno;
	
	private String fechaCorteDos;
	
	/*@ManyToMany(mappedBy = "objetivos")
	private Set<Proyecto> proyecto;*/
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
}
