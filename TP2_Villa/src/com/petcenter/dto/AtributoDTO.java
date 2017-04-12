package com.petcenter.dto;

public class AtributoDTO {
	
	private String idAtributo;
	private String nombreAtributo;
	private String descripcionAtributo;
	private CaracteristicaDTO caracteristica;
	private EstadoDTO estado;
	
	public AtributoDTO() {
		super();
	}
	
	public AtributoDTO(String idAtributo, String nombreAtributo, String descripcionAtributo,
			CaracteristicaDTO caracteristica, EstadoDTO estado) {
		super();
		this.idAtributo = idAtributo;
		this.nombreAtributo = nombreAtributo;
		this.descripcionAtributo = descripcionAtributo;
		this.caracteristica = caracteristica;
		this.estado = estado;
	}
	
	public String getIdAtributo() {
		return idAtributo;
	}
	public void setIdAtributo(String idAtributo) {
		this.idAtributo = idAtributo;
	}
	public String getNombreAtributo() {
		return nombreAtributo;
	}
	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}
	public String getDescripcionAtributo() {
		return descripcionAtributo;
	}
	public void setDescripcionAtributo(String descripcionAtributo) {
		this.descripcionAtributo = descripcionAtributo;
	}
	public CaracteristicaDTO getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(CaracteristicaDTO caracteristica) {
		this.caracteristica = caracteristica;
	}
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

}
