package com.petcenter.dto;

public class MonedaDTO {
	
	private String idMoneda;
	private String nombreMoneda; 
	private EstadoDTO estado;
	
	public MonedaDTO() {
		super();
	}
	
	public MonedaDTO(String idMoneda, String nombreMoneda, EstadoDTO estado) {
		super();
		this.idMoneda = idMoneda;
		this.nombreMoneda = nombreMoneda;
		this.estado = estado;
	}

	public String getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

}
