package com.bim.reporte.proyecto.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nombre_vch")
	private String nombre;
	
	@Column(name = "apellido_vch")
	private String apellido;

	@Column(name = "correo_vch")
	private String correo;
	
	
	/*@ManyToMany(mappedBy = "usuarios")
	@JsonIgnore
    private List<Proyecto> proyectos;*/
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	private String nombre;
	
	@ManyToMany
	@JoinTable(name="usuario_gerencia",
	joinColumns = @JoinColumn(name="usuario_id"),
	inverseJoinColumns = @JoinColumn(name="gerencia_id"))
	private List<Gerencia> gerencia;
*/
}
