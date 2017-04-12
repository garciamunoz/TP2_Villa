package com.petcenter.dto;

public class EspecialidadDTO {
	
	private String idEspecialidad;
	private String nombreEspecialidad;
	private String descripcionEspecialidad;
	private Integer idEstado;
	
	public EspecialidadDTO(){}
	
	public EspecialidadDTO(String idEspecialidad,String nombreEspecialidad,
			String descripcionEspecialidad,Integer idEstado){
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
		this.descripcionEspecialidad = descripcionEspecialidad;
		this.idEstado =  idEstado;
	}
	
	public String getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(String idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
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

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	
	
}
