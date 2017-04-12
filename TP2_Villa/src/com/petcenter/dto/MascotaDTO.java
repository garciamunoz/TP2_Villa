package com.petcenter.dto;

public class MascotaDTO {
	
	private int idMascota;
	private String nomMascota;
	private String idCliente;
	
	public MascotaDTO() {
		super();
	}
	
	public MascotaDTO(int idMascota, String nomMascota, String idCliente) {
		super();
		this.idMascota = idMascota;
		this.nomMascota = nomMascota;
		this.idCliente = idCliente;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNomMascota() {
		return nomMascota;
	}

	public void setNomMascota(String nomMascota) {
		this.nomMascota = nomMascota;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	
}
