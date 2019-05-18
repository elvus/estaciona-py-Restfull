package com.estacionapy.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lotes")
public class Lotes {
	private long id_lote;
	private String dimension;
	private Boolean estado_lote;
	
	public Lotes() {
		
	}
	
	public Lotes(String dimension, Boolean estado_lote) {
		this.dimension=dimension;
		this.estado_lote=estado_lote;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long getId_lote() {
		return id_lote;
	}
	public void setid_lote(long id_lote) {
		this.id_lote=id_lote;
	}
	
	@Column(name="dimension", nullable=false)
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension=dimension;
	}
	
	@Column(name="estado_lote", nullable=false)
	public Boolean getEstado_lote() {
		return estado_lote;
	}
	public void setEstado_lote(Boolean estado_lote) {
		this.estado_lote=estado_lote;
	}
	
}
