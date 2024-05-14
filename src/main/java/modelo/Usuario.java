package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long id;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "apellidos")
	private String surName;
	
	@Column(name = "telefono")
	private String tel;

	public Usuario() {

	}
	
	public Usuario(String dni, String name, String surName, String tel) {
		super();
		this.dni = dni;
		this.name = name;
		this.surName = surName;
		this.tel = tel;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	

}
