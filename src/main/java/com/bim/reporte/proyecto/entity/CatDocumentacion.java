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
@Table(name="cat_documentacion")
@Data
public class CatDocumentacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_documentacion")
	public int idDocumentacion;

	@Column(name = "tipo_documentacion_vch")
	public String tipoDocumentacion;
	
	public Boolean status;
	
	@OneToOne(mappedBy = "catDocumentacion")
	private DetalleProyecto detalleProyecto;
	
}
