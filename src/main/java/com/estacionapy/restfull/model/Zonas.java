package com.estacionapy.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zonas")
public class Zonas {
	private long id_zona;
	private String descripcion;
	private String costo;
	private Boolean estado_zona;
	
	public Zonas() {
		
	}
	
	public Zonas(String descripcion, String costo, Boolean estado_zona) {
		this.descripcion=descripcion;
		this.costo=costo;
		this.estado_zona=estado_zona;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long getId_zona() {
		return id_zona;
	}
	public void setId_zona(long id_zona) {
		this.id_zona=id_zona;
	}
	
	@Column(name="costo", nullable=false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	@Column(name="costo", nullable=false)
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo=costo;
	}
	
	@Column(name="estado_zona")
	public Boolean getEstado_zona() {
		return estado_zona;
	}
	public void setEstado_zona(Boolean estado_zona) {
		this.estado_zona=estado_zona;
	}
}
