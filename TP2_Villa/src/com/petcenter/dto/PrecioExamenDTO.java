package com.petcenter.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PrecioExamenDTO {
	
	private String idExamenClinico;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fechaInicial;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fechaFinal;
	private String idMoneda;
	private Double precio;
	private Double descuento;
	private String indVigente;
	
	private Date fechaFinal2;
	
	public PrecioExamenDTO(){}

	public PrecioExamenDTO(String idExamenClinico, Date fechaInicial, Date fechaFinal, String idMoneda, 
						   Double precio, Double descuento, String indVigente) {
		super();
		this.idExamenClinico = idExamenClinico;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.idMoneda = idMoneda;
		this.precio = precio;
		this.descuento = descuento;
		this.indVigente = indVigente;
	}

	public String getIdExamenClinico() {
		return idExamenClinico;
	}

	public void setIdExamenClinico(String idExamenClinico) {
		this.idExamenClinico = idExamenClinico;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public String getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getIndVigente() {
		return indVigente;
	}

	public void setIndVigente(String indVigente) {
		this.indVigente = indVigente;
	}

	public Date getFechaFinal2() {
		return fechaFinal2;
	}

	public void setFechaFinal2(Date fechaFinal2) {
		this.fechaFinal2 = fechaFinal2;
	}

}
