package com.petcenter.dto;

public class TipoExamPrecioExamVigDTO {
	
	private String idExamenClinico;
	private String nombreExamenClinico; 
	private String descripcionExamenClinico;
	private Integer diasCultivo; 
	private Double precio;
	private Double descuento;
	
	public TipoExamPrecioExamVigDTO() {
		super();
	}

	public TipoExamPrecioExamVigDTO(String idExamenClinico, String nombreExamenClinico, String descripcionExamenClinico,
			Integer diasCultivo, Double precio, Double descuento) {
		super();
		this.idExamenClinico = idExamenClinico;
		this.nombreExamenClinico = nombreExamenClinico;
		this.descripcionExamenClinico = descripcionExamenClinico;
		this.diasCultivo = diasCultivo;
		this.precio = precio;
		this.descuento = descuento;
	}

	public String getIdExamenClinico() {
		return idExamenClinico;
	}

	public void setIdExamenClinico(String idExamenClinico) {
		this.idExamenClinico = idExamenClinico;
	}

	public String getNombreExamenClinico() {
		return nombreExamenClinico;
	}

	public void setNombreExamenClinico(String nombreExamenClinico) {
		this.nombreExamenClinico = nombreExamenClinico;
	}

	public String getDescripcionExamenClinico() {
		return descripcionExamenClinico;
	}

	public void setDescripcionExamenClinico(String descripcionExamenClinico) {
		this.descripcionExamenClinico = descripcionExamenClinico;
	}

	public Integer getDiasCultivo() {
		return diasCultivo;
	}

	public void setDiasCultivo(Integer diasCultivo) {
		this.diasCultivo = diasCultivo;
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

}
