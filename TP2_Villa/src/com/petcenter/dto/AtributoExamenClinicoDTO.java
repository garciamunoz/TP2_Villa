package com.petcenter.dto;

public class AtributoExamenClinicoDTO {
	private String idExamenClinico;
	private String idAtributo;
	private String nombreAtributo;
	private String observacionesAtributo;
	
	public AtributoExamenClinicoDTO() {
		super();
	}

	public AtributoExamenClinicoDTO(String idExamenClinico, String idAtributo, String nombreAtributo,
			String observacionesAtributo) {
		super();
		this.idExamenClinico = idExamenClinico;
		this.idAtributo = idAtributo;
		this.nombreAtributo = nombreAtributo;
		this.observacionesAtributo = observacionesAtributo;
	}

	public String getIdExamenClinico() {
		return idExamenClinico;
	}

	public void setIdExamenClinico(String idExamenClinico) {
		this.idExamenClinico = idExamenClinico;
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

	public String getObservacionesAtributo() {
		return observacionesAtributo;
	}

	public void setObservacionesAtributo(String observacionesAtributo) {
		this.observacionesAtributo = observacionesAtributo;
	}

}
