package com.ine.WebSeviceUsuarios.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario", schema = "public")
public class Usuarios  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_usuario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="ape_pat")
	private String ape_pat;
	@Column(name="ape_mat")
	private String ape_mat;
	@Column(name="puesto")
	private String puesto;
	@Column(name="entidad")
	private int entidad;
	@Column(name="id_tipo_usuario")
	private int id_tipo_usuario;
	@Column(name="correo")
	private String correo;
	
	@JsonIgnore
	private String password;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe_pat() {
		return ape_pat;
	}

	public void setApe_pat(String ape_pat) {
		this.ape_pat = ape_pat;
	}

	public String getApe_mat() {
		return ape_mat;
	}

	public void setApe_mat(String ape_mat) {
		this.ape_mat = ape_mat;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getEntidad() {
		return entidad;
	}

	public void setEntidad(int entidad) {
		this.entidad = entidad;
	}

	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




}
