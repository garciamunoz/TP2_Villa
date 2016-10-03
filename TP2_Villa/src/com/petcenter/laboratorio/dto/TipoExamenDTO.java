package com.petcenter.laboratorio.dto;

public class TipoExamenDTO {
	
	private Integer idTipoExamenMedico;
	private String nombreTipoExamen;
	private String descripcionExamen;
	private String codigoTipoExamen;
	private Integer diasCultivo;
	private Integer idEspecialidad;
	
	public TipoExamenDTO(){}
	
	public TipoExamenDTO(Integer idTipoExamenMedico,String nombreTipoExamen,String descripcionExamen,String codigoTipoExamen,Integer diasCultivo,Integer idEspecialidad){
		
		super();
		this.idTipoExamenMedico = idTipoExamenMedico;
		this.nombreTipoExamen = nombreTipoExamen;
		this.descripcionExamen = descripcionExamen;
		this.codigoTipoExamen = codigoTipoExamen;
		this.diasCultivo = diasCultivo;
		this.idEspecialidad = idEspecialidad;
	}
	
	public Integer getIdTipoExamenMedico() {
		return idTipoExamenMedico;
	}
	public void setIdTipoExamenMedico(Integer idTipoExamenMedico) {
		this.idTipoExamenMedico = idTipoExamenMedico;
	}
	public String getNombreTipoExamen() {
		return nombreTipoExamen;
	}
	public void setNombreTipoExamen(String nombreTipoExamen) {
		this.nombreTipoExamen = nombreTipoExamen;
	}
	public String getDescripcionExamen() {
		return descripcionExamen;
	}
	public void setDescripcionExamen(String descripcionExamen) {
		this.descripcionExamen = descripcionExamen;
	}
	public String getCodigoTipoExamen() {
		return codigoTipoExamen;
	}
	public void setCodigoTipoExamen(String codigoTipoExamen) {
		this.codigoTipoExamen = codigoTipoExamen;
	}
	public Integer getDiasCultivo() {
		return diasCultivo;
	}
	public void setDiasCultivo(Integer diasCultivo) {
		this.diasCultivo = diasCultivo;
	}
	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	
}
