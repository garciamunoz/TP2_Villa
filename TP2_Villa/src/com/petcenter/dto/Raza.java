package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;

public class Raza implements Serializable{

	private static final long serialVersionUID = 731002213913596533L;
	
	private int idRaza;
	private String descripcionRaza;
	private String observacion;
	private int idEspecie;
	private String descripcionEspecie;
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
	public int getIdRaza() {
		return idRaza;
	}
	public void setIdRaza(int idRaza) {
		this.idRaza = idRaza;
	}
	public String getDescripcionRaza() {
		return descripcionRaza;
	}
	public void setDescripcionRaza(String descripcionRaza) {
		this.descripcionRaza = descripcionRaza;
	}
	public int getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getDescripcionEspecie() {
		return descripcionEspecie;
	}
	public void setDescripcionEspecie(String descripcionEspecie) {
		this.descripcionEspecie = descripcionEspecie;
	}
	@Override
	public String toString() {
		return "Raza [idRaza=" + idRaza + ", descripcionRaza=" + descripcionRaza + ", observacion=" + observacion
				+ ", idEspecie=" + idEspecie + ", descripcionEspecie=" + descripcionEspecie + "]";
	}
}
