package com.estacionapy.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehiculos")
public class Vehiculos {
	private long id_vehiculo;
	private String chapa;
	
	public Vehiculos() {
		
	}
	
	public Vehiculos(String chapa) {
		this.chapa=chapa;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long getId_vehiculo() {
		return id_vehiculo;
	}
	public void setId_vehiculo(long id_vehiculo) {
		this.id_vehiculo=id_vehiculo;
	}
	
	@Column(name="chapa", nullable=false)
	public String getChapa() {
		return chapa;
	}
	public void setChapa(String chapa) {
		this.chapa=chapa;
	}
}
