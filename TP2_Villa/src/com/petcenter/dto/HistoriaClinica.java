package com.petcenter.dto;

import java.sql.Date;

public class HistoriaClinica {

	private int idHC;
	private int idCliente;
	private int idMascota;
    private int edad;
    private String observaciones;
    private int estadoHC;
    private Date registrado;
    private Date actualizado;
    
    private String datosCliente;
    private String datosMascota;
    
    private ClienteDTO cliente;
    private MascotaDTO mascota;
    
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	public String getDatosMascota() {
		return datosMascota;
	}
	public void setDatosMascota(String datosMascota) {
		this.datosMascota = datosMascota;
	}
	public int getIdHC() {
		return idHC;
	}
	public void setIdHC(int idHC) {
		this.idHC = idHC;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getEstadoHC() {
		return estadoHC;
	}
	public void setEstadoHC(int estadoHC) {
		this.estadoHC = estadoHC;
	}
	public Date getRegistrado() {
		return registrado;
	}
	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}
	public Date getActualizado() {
		return actualizado;
	}
	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public MascotaDTO getMascota() {
		return mascota;
	}
	public void setMascota(MascotaDTO mascota) {
		this.mascota = mascota;
	}
	@Override
	public String toString() {
		return "HistoriaClinica [idHC=" + idHC + ", idCliente=" + idCliente + ", idMascota=" + idMascota + ", edad="
				+ edad + ", observaciones=" + observaciones + ", estadoHC=" + estadoHC + ", registrado=" + registrado
				+ ", actualizado=" + actualizado + ", datosCliente=" + datosCliente + ", datosMascota=" + datosMascota
				+ "]";
	}

}
