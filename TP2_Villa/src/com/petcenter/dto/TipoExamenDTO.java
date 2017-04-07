package com.petcenter.dto;

import java.io.Serializable;
import java.util.List;

public class TipoExamenDTO implements Serializable {
	
	private String idExamenClinico;
	private String nombreExamenClinico;
	private String descripcionExamenClinico;
	private EspecialidadDTO especialidad;
	private NormativaDTO normativa;
	private EstandarDTO estandar;
	private Integer diasCultivo;
	private List<AtributoExamenClinicoDTO> atributos;
	private EstadoDTO estado;
	private List<PrecioExamenDTO> precios;
	
	public TipoExamenDTO() {
		super();
	}

	public TipoExamenDTO(String idExamenClinico, String nombreExamenClinico, String descripcionExamenClinico,
			EspecialidadDTO especialidad, NormativaDTO normativa, EstandarDTO estandar, Integer diasCultivo,
			EstadoDTO estado) {
		super();
		this.idExamenClinico = idExamenClinico;
		this.nombreExamenClinico = nombreExamenClinico;
		this.descripcionExamenClinico = descripcionExamenClinico;
		this.especialidad = especialidad;
		this.normativa = normativa;
		this.estandar = estandar;
		this.diasCultivo = diasCultivo;
		this.estado = estado;
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

	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public NormativaDTO getNormativa() {
		return normativa;
	}

	public void setNormativa(NormativaDTO normativa) {
		this.normativa = normativa;
	}

	public EstandarDTO getEstandar() {
		return estandar;
	}

	public void setEstandar(EstandarDTO estandar) {
		this.estandar = estandar;
	}

	public Integer getDiasCultivo() {
		return diasCultivo;
	}

	public void setDiasCultivo(Integer diasCultivo) {
		this.diasCultivo = diasCultivo;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public List<AtributoExamenClinicoDTO> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<AtributoExamenClinicoDTO> atributos) {
		this.atributos = atributos;
	}

	public List<PrecioExamenDTO> getPrecios() {
		return precios;
	}

	public void setPrecios(List<PrecioExamenDTO> precios) {
		this.precios = precios;
	}
	
}
