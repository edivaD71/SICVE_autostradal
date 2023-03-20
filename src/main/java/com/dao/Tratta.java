package com.dao;

//creo la class Tratta 

public class Tratta {
	private String trattaId;
	private String trattaNome;
	private String trattaInizio;
	private String trattaFine;
	private Double trattaLun;
	private Double trattaLim;
	private int trattaCon;

	public Tratta(String id, String nome, String inizio, String fine, Double lun, Double lim, int con) {
		this.trattaId = id;
		this.trattaNome = nome;
		this.trattaInizio = inizio;
		this.trattaFine = fine;
		this.trattaLun = lun;
		this.trattaLim = lim;
		this.trattaCon = con;
	}

	public String getTrattaId() {
		return trattaId;
	}

	public String getTrattaNome() {
		return trattaNome;
	}

	public String getTrattaInizio() {
		return trattaInizio;
	}

	public String getTrattaFine() {
		return trattaFine;
	}

	public Double getTrattaLun() {
		return trattaLun;
	}

	public Double getTrattaLim() {
		return trattaLim;
	}

	public int getTrattaCon() {
		return trattaCon;
	}

}
