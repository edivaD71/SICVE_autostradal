package com.defoult;

// creo la class autoBean

public class autoBean {
	private String targa,marca,modello,email;
	private int anno;
	
	public autoBean() {
		super();
	}
	public autoBean(String targa, String marca, String modello, int anno, String email) {
		super();
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.email = email;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModelo(String modello) {
		this.modello = modello;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	
}
