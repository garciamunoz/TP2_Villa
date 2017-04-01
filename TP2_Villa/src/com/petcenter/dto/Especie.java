package com.petcenter.dto;

import java.io.Serializable;

public class Especie implements Serializable{

	private static final long serialVersionUID = 6176156590093235352L;

	private int idEspecie;
	private String descripcionEspecie;
	private String observacion;
	public int getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}
	public String getDescripcionEspecie() {
		return descripcionEspecie;
	}
	public void setDescripcionEspecie(String descripcionEspecie) {
		this.descripcionEspecie = descripcionEspecie;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "Especie [idEspecie=" + idEspecie + ", descripcionEspecie=" + descripcionEspecie + ", observacion="
				+ observacion + "]";
	}
}
