package com.bim.reporte.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cat_dependencia")
@Data
public class CatDependencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dependencia")
	public int idDependencia;

	@Column(name = "tipo_dependencia_vch")
	public String tipoDependencia;
	
	public Boolean status;
	
	@OneToOne(mappedBy = "catDependencias")
	private DetalleProyecto detalleProyecto;
}
