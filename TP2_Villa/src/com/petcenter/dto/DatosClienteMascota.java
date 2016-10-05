package com.petcenter.dto;

public class DatosClienteMascota {

	private int idCliente; 
	private String datosCliente;
	private int idMascota;
	private String datosMascota; 
	private byte[] fotoMascota;
	private String fotoString;
    private String descripcionRaza;
    private String descripcionEspecie;
    private String descripcionGenMascota;
    
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getDatosCliente() {
		return datosCliente;
	}
	public void setDatosCliente(String datosCliente) {
		this.datosCliente = datosCliente;
	}
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getDatosMascota() {
		return datosMascota;
	}
	public void setDatosMascota(String datosMascota) {
		this.datosMascota = datosMascota;
	}
	public byte[] getFotoMascota() {
		return fotoMascota;
	}
	public void setFotoMascota(byte[] fotoMascota) {
		this.fotoMascota = fotoMascota;
	}
	public String getDescripcionRaza() {
		return descripcionRaza;
	}
	public void setDescripcionRaza(String descripcionRaza) {
		this.descripcionRaza = descripcionRaza;
	}
	public String getDescripcionEspecie() {
		return descripcionEspecie;
	}
	public void setDescripcionEspecie(String descripcionEspecie) {
		this.descripcionEspecie = descripcionEspecie;
	}
	public String getDescripcionGenMascota() {
		return descripcionGenMascota;
	}
	public void setDescripcionGenMascota(String descripcionGenMascota) {
		this.descripcionGenMascota = descripcionGenMascota;
	}
	public String getFotoString() {		
//		String fotoString = "";
//		try {
//			byte[] imageBytes = fotoMascota.getBytes(1, (int) fotoMascota.length());
//			fotoString = new String(imageBytes);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return fotoString;
	}
	public void setFotoString(String fotoString) {
		this.fotoString = fotoString;
	}
	
}
