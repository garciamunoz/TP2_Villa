package com.petcenter.dto;

import java.io.Serializable;

public class Examen implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idEXAM;
	private String descripcion;
	public int getIdEXAM() {
		return idEXAM;
	}
	public void setIdEXAM(int idEXAM) {
		this.idEXAM = idEXAM;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Examen [idEXAM=" + idEXAM + ", descripcion=" + descripcion + "]";
	}
}
