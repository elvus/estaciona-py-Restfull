package com.estacionapy.restfull.model;


import javax.persistence.*;

@Entity
@Table(name="manzanas")
public class Manzanas {
	long id_manzana;
	String num_manzana;
	String ubicacion;
	
	public Manzanas() {
		
	}
	
	public Manzanas(String num_manzana, String ubicacion) {
		this.num_manzana=num_manzana;
		this.ubicacion=ubicacion;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId_manzana() {
		return id_manzana;
	}
	public void setId_manzana(long id_manzana) {
		this.id_manzana=id_manzana;
	}
	
	@Column (name="num_manzana")
	public String getNum_manzana() {
		return num_manzana;
	}
	public void setNum_manzana(String num_manzana) {
		this.num_manzana=num_manzana;
	}
	
	@Column(name="ubicacion")
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion){
		this.ubicacion=ubicacion;
	}
	
	
	
}
