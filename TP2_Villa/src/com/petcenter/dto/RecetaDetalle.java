package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;

public class RecetaDetalle implements Serializable{

	private static final long serialVersionUID = 3724177471017086685L;
	
	private int idRecetaDetalle;
	private int idReceta;
	private String nombreMedicamento;
	private String via;
	private String dosis;
	private String indicacion;
	private String duracion;
	private String cantidad;
	private int estado;
	private Date actualizado;
	private Date registrado;
	public int getIdRecetaDetalle() {
		return idRecetaDetalle;
	}
	public void setIdRecetaDetalle(int idRecetaDetalle) {
		this.idRecetaDetalle = idRecetaDetalle;
	}
	public int getIdReceta() {
		return idReceta;
	}
	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}
	public String getNombreMedicamento() {
		return nombreMedicamento;
	}
	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	public String getIndicacion() {
		return indicacion;
	}
	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
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
		return "RecetaDetalle [idRecetaDetalle=" + idRecetaDetalle + ", idReceta=" + idReceta + ", nombreMedicamento="
				+ nombreMedicamento + ", via=" + via + ", dosis=" + dosis + ", indicacion=" + indicacion + ", duracion="
				+ duracion + ", cantidad=" + cantidad + ", estado=" + estado + ", actualizado=" + actualizado
				+ ", registrado=" + registrado + "]";
	}

}
