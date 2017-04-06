package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;

public class Diagnostico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idDIAG;
	private String descripcion;
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
	public int getIdDIAG() {
		return idDIAG;
	}
	public void setIdDIAG(int idDIAG) {
		this.idDIAG = idDIAG;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "Diagnostico [idDIAG=" + idDIAG + ", descripcion=" + descripcion + ", observacion=" + observacion + "]";
	}
}
