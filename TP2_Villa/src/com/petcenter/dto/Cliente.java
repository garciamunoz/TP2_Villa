package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 3661137606799629157L;
	
	private int idCliente;
	private String codCliente;
	private int idTipoCliente;
	private int idTipoDocumento;
	private String nroDocumento;
	private String nomCliente;
	private String apePaternoCliente;
	private String apeMaternoCliente;
	private int idGeneroCliente;
	private Date fecNacCliente;
	private String fecNacClienteFormateada;
	private int idSede;
	private int idDistrito;
	private String direcCliente;
	private String celCliente;
	private String telfDomCliente;
	private String telfTraCliente;
	private int indNotificaciones;
	private String correoElectCliente;
	private int estadoCliente;
	
	private String descripcionTipoCliente;
	private String documentoCompleto;
	private String nombreCompleto;
	
	public String getDescripcionTipoCliente() {
		return descripcionTipoCliente;
	}
	public void setDescripcionTipoCliente(String descripcionTipoCliente) {
		this.descripcionTipoCliente = descripcionTipoCliente;
	}
	public String getDocumentoCompleto() {
		return documentoCompleto;
	}
	public void setDocumentoCompleto(String documentoCompleto) {
		this.documentoCompleto = documentoCompleto;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	public int getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	public int getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(int idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApePaternoCliente() {
		return apePaternoCliente;
	}
	public void setApePaternoCliente(String apePaternoCliente) {
		this.apePaternoCliente = apePaternoCliente;
	}
	public String getApeMaternoCliente() {
		return apeMaternoCliente;
	}
	public void setApeMaternoCliente(String apeMaternoCliente) {
		this.apeMaternoCliente = apeMaternoCliente;
	}
	public int getIdGeneroCliente() {
		return idGeneroCliente;
	}
	public void setIdGeneroCliente(int idGeneroCliente) {
		this.idGeneroCliente = idGeneroCliente;
	}
	public Date getFecNacCliente() {
		return fecNacCliente;
	}
	public void setFecNacCliente(Date fecNacCliente) {
		this.fecNacCliente = fecNacCliente;
	}
	public int getIdSede() {
		return idSede;
	}
	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getDirecCliente() {
		return direcCliente;
	}
	public void setDirecCliente(String direcCliente) {
		this.direcCliente = direcCliente;
	}
	public String getCelCliente() {
		return celCliente;
	}
	public void setCelCliente(String celCliente) {
		this.celCliente = celCliente;
	}
	public String getTelfDomCliente() {
		return telfDomCliente;
	}
	public void setTelfDomCliente(String telfDomCliente) {
		this.telfDomCliente = telfDomCliente;
	}
	public String getTelfTraCliente() {
		return telfTraCliente;
	}
	public void setTelfTraCliente(String telfTraCliente) {
		this.telfTraCliente = telfTraCliente;
	}
	public int getIndNotificaciones() {
		return indNotificaciones;
	}
	public void setIndNotificaciones(int indNotificaciones) {
		this.indNotificaciones = indNotificaciones;
	}
	public String getCorreoElectCliente() {
		return correoElectCliente;
	}
	public void setCorreoElectCliente(String correoElectCliente) {
		this.correoElectCliente = correoElectCliente;
	}
	public int getEstadoCliente() {
		return estadoCliente;
	}
	public void setEstadoCliente(int estadoCliente) {
		this.estadoCliente = estadoCliente;
	}
	public String getFecNacClienteFormateada() {
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = sfd.format(fecNacCliente);
		return fecha;
	}
	public void setFecNacClienteFormateada(String fecNacClienteFormateada) {
		this.fecNacClienteFormateada = fecNacClienteFormateada;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", codCliente=" + codCliente + ", idTipoCliente=" + idTipoCliente
				+ ", idTipoDocumento=" + idTipoDocumento + ", nroDocumento=" + nroDocumento + ", nomCliente="
				+ nomCliente + ", apePaternoCliente=" + apePaternoCliente + ", apeMaternoCliente=" + apeMaternoCliente
				+ ", idGeneroCliente=" + idGeneroCliente + ", fecNacCliente=" + fecNacCliente + ", idSede=" + idSede
				+ ", idDistrito=" + idDistrito + ", direcCliente=" + direcCliente + ", celCliente=" + celCliente
				+ ", telfDomCliente=" + telfDomCliente + ", telfTraCliente=" + telfTraCliente + ", indNotificaciones="
				+ indNotificaciones + ", correoElectCliente=" + correoElectCliente + ", estadoCliente=" + estadoCliente
				+ ", descripcionTipoCliente=" + descripcionTipoCliente + ", documentoCompleto=" + documentoCompleto
				+ ", nombreCompleto=" + nombreCompleto + "]";
	}

}
