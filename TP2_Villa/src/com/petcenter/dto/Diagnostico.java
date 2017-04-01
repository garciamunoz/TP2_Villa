package com.petcenter.dto;

import java.io.Serializable;

public class Diagnostico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idDIAG;
	private String descripcion;
	private String observacion;
	
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
