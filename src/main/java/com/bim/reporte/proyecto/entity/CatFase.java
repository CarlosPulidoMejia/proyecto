package com.bim.reporte.proyecto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="cat_fase")
@Data
public class CatFase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fase")
	public int idTipoFase;

	@Column(name = "tipo_fase_vch")
	public String tipoFase;
	
	public Boolean status;
	
	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_fase")
	private DetalleProyecto detalleProyecto;
	*/
}
