package com.ine.WebSeviceUsuarios.dto;

import java.util.List;

public class ResponseOK {
	private Integer estatus;
	private List<?> resultado;
	private String msj;

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public List<?> getResultado() {
		return resultado;
	}

	public void setResultado(List<?> resultado) {
		this.resultado = resultado;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
}
