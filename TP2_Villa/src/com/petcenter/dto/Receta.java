package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;

public class Receta implements Serializable{

	private static final long serialVersionUID = 2165782326284803681L;
	
	private int idReceta;
	private int idAM;
	private String observacion;
	private int estado;
	private Date actualizado;
	private Date registrado;
	
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public int getIdAM() {
		return idAM;
	}
	public void setIdAM(int idAM) {
		this.idAM = idAM;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
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
	@Override
	public String toString() {
		return "Receta [idReceta=" + idReceta + ", idAM=" + idAM + ", observacion=" + observacion + ", estado=" + estado
				+ ", actualizado=" + actualizado + ", registrado=" + registrado + "]";
	}
	
}
