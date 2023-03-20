package com.dao;
// class avgVelocita per gestire l'elenco della velocita media per ogni autostrada
public class avgVelocita {
	private String avgNome;
	private Double avgMedia;
	
	public avgVelocita(String nome,Double media)
	{
		this.avgNome = nome;
		this.avgMedia = media;
	}

	public String getAvgNome() {
		return avgNome;
	}

	public void setAvgNome(String avgNome) {
		this.avgNome = avgNome;
	}

	public Double getAvgMedia() {
		return avgMedia;
	}

	public void setAvgMedia(Double avgMedia) {
		this.avgMedia = avgMedia;
	}
	
}
