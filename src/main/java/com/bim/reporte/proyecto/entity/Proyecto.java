package com.bim.reporte.proyecto.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="proyecto")
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proyecto")
	public int idProyecto;
	
	@Column(name = "proyecto_vch")
	public String proyecto;
	
	public int status;
	
	@OneToOne(mappedBy = "catProyecto")
	@JsonIgnore
	private DetalleProyecto detalleProyecto;
	
	/*@ManyToMany
	@JoinTable(name = "proyecto_objetivo",
	joinColumns = @JoinColumn(name="id_proyecto"),
	inverseJoinColumns = @JoinColumn(name="id_objetivo"))
	private List<Objetivo> objetivos;*/
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Objetivo> objetivos;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	    @JoinTable(
	            name = "proyecto_recurso",
	            joinColumns = @JoinColumn(name = "id_proyecto"),
	            inverseJoinColumns = @JoinColumn(name = "id_usuario")
	            )
	    private Set<Usuario> usuario;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinTable(
            name = "proyecto_recurso",
            joinColumns = @JoinColumn(name = "id_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "id_gerencia")
            )
    private Set<Gerencia> gerencia;
	 
	/*@OneToMany(mappedBy = "proyecto")
    Set<ProyectoRecurso> registrations;*/
	
	/*@ManyToMany
    @JoinTable(name = "proyecto_recurso",
        joinColumns =@JoinColumn(name="id_proyecto"),
        inverseJoinColumns = @JoinColumn(name= "id_usuario"))
	@JsonIgnore
	private List<Usuario> usuarios;*/
	
	public Proyecto(String proyecto) {
		// TODO Auto-generated constructor stub
	}
	

}
