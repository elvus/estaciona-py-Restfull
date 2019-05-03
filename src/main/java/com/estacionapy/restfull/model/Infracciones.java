package com.estacionapy.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="infracciones")
public class Infracciones {
	private long id_infraccion;
	private String descripcion;
	private Boolean estado_infraccion;
	
	public Infracciones() {
		
	}
	public Infracciones(String descripcion, Boolean estado_infracion) {
		this.descripcion=descripcion;
		this.estado_infraccion=estado_infracion;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long getId_infraccion() {
		return id_infraccion;
	}
	public void setId_infraccion(long id_infraccion) {
		this.id_infraccion=id_infraccion;
	}
	
	@Column(name="descripcion", nullable=false)
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	
	@Column(name="estado_infraccion", nullable=false)
	public Boolean getEstado_infraccion() {
		return estado_infraccion;
	}
	public void setDescripcion(Boolean estado_infraccion) {
		this.estado_infraccion=estado_infraccion;
	}
}
