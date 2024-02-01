package com.bim.reporte.proyecto.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "detalle_proyecto")
@Data
public class DetalleProyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idDetalle;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_proyecto",referencedColumnName = "id_proyecto")
	public Proyecto catProyecto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_tipoproy",referencedColumnName = "id_tipo_proyecto")
	public CatTipoProyecto catTipoProyecto;
	
	@Column(name = "hrs_atencion")
	public float hrsAtencion;
	
	@Column(name = "fecha_inicio_dt")
	//@Temporal(TemporalType.DATE)
	public String fechaInicio;
	
	@Column(name = "fecha_fin_dt")
	//@Temporal(TemporalType.DATE)
	public String fechaFin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_fase")
	//@DefaultValue(value = "1")
	private CatFase catFase;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_estado",referencedColumnName = "id_estado")
	public CatEstadoProyecto catEstadoProyecto;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_dependencia",referencedColumnName = "id_dependencia")
	private CatDependencias catDependencias;
	
	private int avance;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "id_documentacion",referencedColumnName = "id_documentacion")
	public CatDocumentacion catDocumentacion;
	
	public String comentario;
	
	public String docAvance;
	
	public String porRealizar;
	
	
}
