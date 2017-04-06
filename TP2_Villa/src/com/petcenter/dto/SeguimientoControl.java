package com.petcenter.dto;

import java.io.Serializable;

public class SeguimientoControl implements Serializable{

	private static final long serialVersionUID = 8040511336585525782L;

	private int idMascota;
	private String datosCliente;
	private String datosMascota;
	private String descripcionEspecie;
	private String fechaUltimaAtencion;
	
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	public String getDatosMascota() {
		return datosMascota;
	}
	public void setDatosMascota(String datosMascota) {
		this.datosMascota = datosMascota;
	}
	public String getDescripcionEspecie() {
		return descripcionEspecie;
	}
	public void setDescripcionEspecie(String descripcionEspecie) {
		this.descripcionEspecie = descripcionEspecie;
	}
	public String getFechaUltimaAtencion() {
		return fechaUltimaAtencion;
	}
	public void setFechaUltimaAtencion(String fechaUltimaAtencion) {
		this.fechaUltimaAtencion = fechaUltimaAtencion;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	@Override
	public String toString() {
		return "SeguimientoControl [datosCliente=" + datosCliente + ", datosMascota=" + datosMascota
				+ ", descripcionEspecie=" + descripcionEspecie + ", fechaUltimaAtencion=" + fechaUltimaAtencion + "]";
	}
	
}
