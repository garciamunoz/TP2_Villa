package com.petcenter.dto;

public class CaracteristicaDTO {
	
	private String idCaracteristica;
	private String descripcionCaracteristica;
	private EstadoDTO estado;
	
	public CaracteristicaDTO() {
		super();
	}

	public CaracteristicaDTO(String idCaracteristica, String descripcionCaracteristica, EstadoDTO estado) {
		super();
		this.idCaracteristica = idCaracteristica;
		this.descripcionCaracteristica = descripcionCaracteristica;
		this.estado = estado;
	}

	public String getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public String getDescripcionCaracteristica() {
		return descripcionCaracteristica;
	}

	public void setDescripcionCaracteristica(String descripcionCaracteristica) {
		this.descripcionCaracteristica = descripcionCaracteristica;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

}
