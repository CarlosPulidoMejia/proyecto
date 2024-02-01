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
@Table(name="cat_estado_proyecto")
@Data
public class CatEstadoProyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado")
	public int idTipoEstado;

	@Column(name = "tipo_estado_vch")
	public String tipoEstado;
	
	public Boolean status;
	
	@OneToOne(mappedBy = "catEstadoProyecto")
	private DetalleProyecto detalleProyecto;
	
}
