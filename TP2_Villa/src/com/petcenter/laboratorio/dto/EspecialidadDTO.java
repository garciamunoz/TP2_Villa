package com.petcenter.laboratorio.dto;

public class EspecialidadDTO {
	
	private Integer idEspecialidad;
	private String codigoEspecialidad;
	private String nombreEspecialidad;
	private String descripcionEspecialidad;
	
	public EspecialidadDTO(){}
	
	public EspecialidadDTO(Integer idEspecialidad,String codigoEspecialidad,String nombreEspecialidad,
			String descripcionEspecialidad){
		super();
		this.idEspecialidad = idEspecialidad;
		this.codigoEspecialidad = codigoEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
	
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public String getCodigoEspecialidad() {
		return codigoEspecialidad;
	}
	public void setCodigoEspecialidad(String codigoEspecialidad) {
		this.codigoEspecialidad = codigoEspecialidad;
	}
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}
	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}
	
}
