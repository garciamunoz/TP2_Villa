package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;

public class Especie implements Serializable{

	private static final long serialVersionUID = 6176156590093235352L;

	private int idEspecie;
	private String descripcionEspecie;
	private String observacion;
	private Date actualizado;
	private Date registrado;
	
	public Date getActualizado() {
		return actualizado;
	}
	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}
	public Date getRegistrado() {
		return registrado;
	}
	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}
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
