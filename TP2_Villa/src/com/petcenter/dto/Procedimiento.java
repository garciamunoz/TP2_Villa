package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;

public class Procedimiento implements Serializable {

	private static final long serialVersionUID = -7654123562970006587L;
	
	private int idProcedimiento;
	private int idAM;
	private String tipoProcedimiento;
	private String descripcion;
	private String observacion;
	private int estado;
	private Date actualizado;
	private Date registrado;
	public int getIdProcedimiento() {
		return idProcedimiento;
	}
	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	public int getIdAM() {
		return idAM;
	}
	public void setIdAM(int idAM) {
		this.idAM = idAM;
	}
	public String getTipoProcedimiento() {
		return tipoProcedimiento;
	}
	public void setTipoProcedimiento(String tipoProcedimiento) {
		this.tipoProcedimiento = tipoProcedimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Date getActualizado() {
		return actualizado;
	}
	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}
	public Date getRegistrado() {
		return registrado;
	}
	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}
	@Override
	public String toString() {
		return "Procedimiento [idProcedimiento=" + idProcedimiento + ", idAM=" + idAM + ", tipoProcedimiento="
				+ tipoProcedimiento + ", descripcion=" + descripcion + ", observacion=" + observacion + ", estado="
				+ estado + ", actualizado=" + actualizado + ", registrado=" + registrado + "]";
	}
	
}
