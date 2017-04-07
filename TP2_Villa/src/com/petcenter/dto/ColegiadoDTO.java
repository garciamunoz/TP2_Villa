package com.petcenter.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ColegiadoDTO {
	
	private String numeroColegiatura;
	private String nombre; 
	private String apellidoPaterno; 
	private String apellidoMaterno; 
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fechaColegiatura; 
	private EstadoDTO estado;
	
	public ColegiadoDTO() {
		super();
	}

	public ColegiadoDTO(String numeroColegiatura, String nombre, String apellidoPaterno, String apellidoMaterno,
			Date fechaColegiatura, EstadoDTO estado) {
		super();
		this.numeroColegiatura = numeroColegiatura;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaColegiatura = fechaColegiatura;
		this.estado = estado;
	}

	public String getNumeroColegiatura() {
		return numeroColegiatura;
	}

	public void setNumeroColegiatura(String numeroColegiatura) {
		this.numeroColegiatura = numeroColegiatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaColegiatura() {
		return fechaColegiatura;
	}

	public void setFechaColegiatura(Date fechaColegiatura) {
		this.fechaColegiatura = fechaColegiatura;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	
}
