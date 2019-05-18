package com.estacionapy.restfull.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saldos")
public class Saldos {
	private long id_saldo;
	private String monto_recarga;
	private Date fecha_recarga;

	public Saldos() {
		
	}
	
	public Saldos(String monto_recarga, Date fecha_recarga) {
		this.monto_recarga=monto_recarga;
		this.fecha_recarga=fecha_recarga;
	}
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId_saldo() {
    	return id_saldo;
    }
    public void setId_saldo(Long id_saldo) {
    	this.id_saldo=id_saldo;
    }
    
    @Column(name="monto_recarga", nullable=false)
    public String getMonto_recarga() {
    	return monto_recarga;
    }
    public void setMonto_recarga(String monto_recarga) {
    	this.monto_recarga=monto_recarga;
    }
    
    @Column(name="fecha_recarga", nullable=false)
    public Date getFecha_recarga() {
    	return fecha_recarga;
    }
    public void setFecha_recarga(Date fecha_recarga) {
    	this.fecha_recarga=fecha_recarga;
    }
}
