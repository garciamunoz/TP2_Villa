package com.petcenter.dto;

public class ClienteDTO {
	
	private int idCliente; 
	private String nomCliente; 
	private String apePaternoCliente; 
	private String apeMaternoCliente;
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(int idCliente, String nomCliente, String apePaternoCliente, String apeMaternoCliente) {
		super();
		this.idCliente = idCliente;
		this.nomCliente = nomCliente;
		this.apePaternoCliente = apePaternoCliente;
		this.apeMaternoCliente = apeMaternoCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

}
