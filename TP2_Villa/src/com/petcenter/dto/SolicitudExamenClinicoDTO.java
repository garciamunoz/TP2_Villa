package com.petcenter.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.petcenter.controller.CustomJsonDateDeserializer;

public class SolicitudExamenClinicoDTO {
	
	private String idSolicitudexamen;
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date fechaSolicitudexamen;
	private String nroOrdenMedica; 
	private String tipoOrdenMedica;
	private Double subtotal; 
	private Double totalDscto;
	private Double totalIgv; 
	private Double totalPrecio;
	private String nombresClienteExterno;
	private String numeroColegiatura;
	private Integer cantExamenes; 
	private String idEstado;
	
	private AtencionMedica atencionMedica;
	private HistoriaClinica historiaClinica;
	
	private EstadoDTO estado;
	
	private List<DetalleSolicitudExamenClinicoDTO> detalle;
	
	public SolicitudExamenClinicoDTO() {
		super();
	}

	public SolicitudExamenClinicoDTO(String idSolicitudexamen, Date fechaSolicitudexamen, String nroOrdenMedica,
			String tipoOrdenMedica, Double subtotal, Double totalDscto, Double totalIgv, Double totalPrecio,
			String nombresClienteExterno, String numeroColegiatura, Integer cantExamenes, String idEstado) {
		super();
		this.idSolicitudexamen = idSolicitudexamen;
		this.fechaSolicitudexamen = fechaSolicitudexamen;
		this.nroOrdenMedica = nroOrdenMedica;
		this.tipoOrdenMedica = tipoOrdenMedica;
		this.subtotal = subtotal;
		this.totalDscto = totalDscto;
		this.totalIgv = totalIgv;
		this.totalPrecio = totalPrecio;
		this.nombresClienteExterno = nombresClienteExterno;
		this.numeroColegiatura = numeroColegiatura;
		this.cantExamenes = cantExamenes;
		this.idEstado = idEstado;
	}

	public String getIdSolicitudexamen() {
		return idSolicitudexamen;
	}

	public void setIdSolicitudexamen(String idSolicitudexamen) {
		this.idSolicitudexamen = idSolicitudexamen;
	}

	public Date getFechaSolicitudexamen() {
		return fechaSolicitudexamen;
	}

	public void setFechaSolicitudexamen(Date fechaSolicitudexamen) {
		this.fechaSolicitudexamen = fechaSolicitudexamen;
	}

	public String getNroOrdenMedica() {
		return nroOrdenMedica;
	}

	public void setNroOrdenMedica(String nroOrdenMedica) {
		this.nroOrdenMedica = nroOrdenMedica;
	}

	public String getTipoOrdenMedica() {
		return tipoOrdenMedica;
	}

	public void setTipoOrdenMedica(String tipoOrdenMedica) {
		this.tipoOrdenMedica = tipoOrdenMedica;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getTotalDscto() {
		return totalDscto;
	}

	public void setTotalDscto(Double totalDscto) {
		this.totalDscto = totalDscto;
	}

	public Double getTotalIgv() {
		return totalIgv;
	}

	public void setTotalIgv(Double totalIgv) {
		this.totalIgv = totalIgv;
	}

	public Double getTotalPrecio() {
		return totalPrecio;
	}

	public void setTotalPrecio(Double totalPrecio) {
		this.totalPrecio = totalPrecio;
	}

	public String getNombresClienteExterno() {
		return nombresClienteExterno;
	}

	public void setNombresClienteExterno(String nombresClienteExterno) {
		this.nombresClienteExterno = nombresClienteExterno;
	}

	public String getNumeroColegiatura() {
		return numeroColegiatura;
	}

	public void setNumeroColegiatura(String numeroColegiatura) {
		this.numeroColegiatura = numeroColegiatura;
	}

	public Integer getCantExamenes() {
		return cantExamenes;
	}

	public void setCantExamenes(Integer cantExamenes) {
		this.cantExamenes = cantExamenes;
	}

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public AtencionMedica getAtencionMedica() {
		return atencionMedica;
	}

	public void setAtencionMedica(AtencionMedica atencionMedica) {
		this.atencionMedica = atencionMedica;
	}

	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}

	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}

	public List<DetalleSolicitudExamenClinicoDTO> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetalleSolicitudExamenClinicoDTO> detalle) {
		this.detalle = detalle;
	}
}
