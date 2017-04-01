package com.petcenter.dto;

public class EstandarDTO {
	
	private String idEstandar;
	private String nombreEstandar;
	private String descripcionEstandar;
	private EstadoDTO estado;
	
	public EstandarDTO(){}

	public EstandarDTO(String idEstandar, String nombreEstandar, String descripcionEstandar, EstadoDTO estado) {
		super();
		this.idEstandar = idEstandar;
		this.nombreEstandar = nombreEstandar;
		this.descripcionEstandar = descripcionEstandar;
		this.estado = estado;
	}

	public String getIdEstandar() {
		return idEstandar;
	}

	public void setIdEstandar(String idEstandar) {
		this.idEstandar = idEstandar;
	}

	public String getNombreEstandar() {
		return nombreEstandar;
	}

	public void setNombreEstandar(String nombreEstandar) {
		this.nombreEstandar = nombreEstandar;
	}

	public String getDescripcionEstandar() {
		return descripcionEstandar;
	}

	public void setDescripcionEstandar(String descripcionEstandar) {
		this.descripcionEstandar = descripcionEstandar;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

}
