package com.petcenter.dto;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Mascota implements Serializable{

	private static final long serialVersionUID = -8150115835412450674L;
	
	private int idMascota;
	private String codMascota;
	private String nomMascota;
	private int idCliente;
	private int idRelClienteMascota;
	private int idRaza;
	private int idEspecie;
	private String fotoMascota;
	private int estadoMascota;
	private String descMascota;
	private int idGeneroMascota;
	private Date fechaNacMascota;
	private String fechaNacMascotaFormateada;
	private Date actualizado;
	
	private String datosMascota;
	private String datosCliente;
	private String descripcionRelClienteMascota;
	private String estadoMascotaDescripcion;
	
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getCodMascota() {
		return codMascota;
	}
	public void setCodMascota(String codMascota) {
		this.codMascota = codMascota;
	}
	public String getNomMascota() {
		return nomMascota;
	}
	public void setNomMascota(String nomMascota) {
		this.nomMascota = nomMascota;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdRelClienteMascota() {
		return idRelClienteMascota;
	}
	public void setIdRelClienteMascota(int idRelClienteMascota) {
		this.idRelClienteMascota = idRelClienteMascota;
	}
	public int getIdRaza() {
		return idRaza;
	}
	public void setIdRaza(int idRaza) {
		this.idRaza = idRaza;
	}
	public String getFotoMascota() {
		return fotoMascota;
	}
	public void setFotoMascota(String fotoMascota) {
		this.fotoMascota = fotoMascota;
	}
	public int getEstadoMascota() {
		return estadoMascota;
	}
	public void setEstadoMascota(int estadoMascota) {
		this.estadoMascota = estadoMascota;
	}
	public String getDescMascota() {
		return descMascota;
	}
	public void setDescMascota(String descMascota) {
		this.descMascota = descMascota;
	}
	public int getIdGeneroMascota() {
		return idGeneroMascota;
	}
	public void setIdGeneroMascota(int idGeneroMascota) {
		this.idGeneroMascota = idGeneroMascota;
	}
	public Date getFechaNacMascota() {
		return fechaNacMascota;
	}
	public void setFechaNacMascota(Date fechaNacMascota) {
		this.fechaNacMascota = fechaNacMascota;
	}
	public Date getActualizado() {
		return actualizado;
	}
	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}
	public String getFechaNacMascotaFormateada() {
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = sfd.format(fechaNacMascota);
		return fecha;
	}
	public void setFechaNacMascotaFormateada(String fechaNacMascotaFormateada) {
		this.fechaNacMascotaFormateada = fechaNacMascotaFormateada;
	}
	public String getDatosMascota() {
		return datosMascota;
	}
	public void setDatosMascota(String datosMascota) {
		this.datosMascota = datosMascota;
	}
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	public String getDescripcionRelClienteMascota() {
		return descripcionRelClienteMascota;
	}
	public void setDescripcionRelClienteMascota(String descripcionRelClienteMascota) {
		this.descripcionRelClienteMascota = descripcionRelClienteMascota;
	}
	public String getEstadoMascotaDescripcion() {
		if(estadoMascota == 0){
			return "INACTIVO";
		}else{
			return "ACTIVO";
		}
	}
	public void setEstadoMascotaDescripcion(String estadoMascotaDescripcion) {
		this.estadoMascotaDescripcion = estadoMascotaDescripcion;
	}
	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", codMascota=" + codMascota + ", nomMascota=" + nomMascota
				+ ", idCliente=" + idCliente + ", idRelClienteMascota=" + idRelClienteMascota + ", idRaza=" + idRaza
				+ ", fotoMascota=" + fotoMascota + ", estadoMascota=" + estadoMascota + ", descMascota=" + descMascota
				+ ", idGeneroMascota=" + idGeneroMascota + ", fechaNacMascota=" + fechaNacMascota
				+ ", fechaNacMascotaFormateada=" + fechaNacMascotaFormateada + ", actualizado=" + actualizado
				+ ", datosMascota=" + datosMascota + ", datosClientes=" + datosCliente
				+ ", descripcionRelClienteMascota=" + descripcionRelClienteMascota + "]";
	}
	public int getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}
	
}
