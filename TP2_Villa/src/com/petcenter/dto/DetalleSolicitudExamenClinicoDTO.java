package com.petcenter.dto;

public class DetalleSolicitudExamenClinicoDTO {
	
	private String idSolicitudexamen;
	private int item;
	private String tipoExamen;
	private String idExamenClinico;
	private String indMuestras;
	private Double precio;
	private Double descuento;
	
	public DetalleSolicitudExamenClinicoDTO() {
		super();
	}
	
	public DetalleSolicitudExamenClinicoDTO(String idSolicitudexamen, int item, String tipoExamen,
			String idExamenClinico, String indMuestras, Double precio, Double descuento) {
		super();
		this.idSolicitudexamen = idSolicitudexamen;
		this.item = item;
		this.tipoExamen = tipoExamen;
		this.idExamenClinico = idExamenClinico;
		this.indMuestras = indMuestras;
		this.precio = precio;
		this.descuento = descuento;
	}

	public String getIdSolicitudexamen() {
		return idSolicitudexamen;
	}

	public void setIdSolicitudexamen(String idSolicitudexamen) {
		this.idSolicitudexamen = idSolicitudexamen;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public String getIdExamenClinico() {
		return idExamenClinico;
	}

	public void setIdExamenClinico(String idExamenClinico) {
		this.idExamenClinico = idExamenClinico;
	}

	public String getIndMuestras() {
		return indMuestras;
	}

	public void setIndMuestras(String indMuestras) {
		this.indMuestras = indMuestras;
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
