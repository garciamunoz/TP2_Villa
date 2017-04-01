package com.petcenter.dto;

public class EstadoDTO {

	private String idEstado;
	private String nombreEstado;
	private String descripcionEstado;
	private String indMante;
	
	public EstadoDTO(){}
	
	public EstadoDTO(String idEstado, String nombreEstado, String descripcionEstado, String indMante){
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
		this.descripcionEstado = descripcionEstado;
		this.indMante = indMante;
	}
	public String getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public String getIndMante() {
		return indMante;
	}

	public void setIndMante(String indMante) {
		this.indMante = indMante;
	}
	
}
