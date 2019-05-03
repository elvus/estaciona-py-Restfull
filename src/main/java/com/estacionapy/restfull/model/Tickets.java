package com.estacionapy.restfull.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tickets")
public class Tickets {
	private long id_ticket;
	private Date hora_inicio;
	private Date hora_fin;
	private String monto_total;
	
	public Tickets() {
		
	}
	
	public Tickets(Date hora_inicio, Date hora_fin, String monto_total) {
		this.hora_inicio=hora_inicio;
		this.hora_fin=hora_fin;
		this.monto_total=monto_total;
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public long getId_ticket() {
		return id_ticket;
	}
	public void setId_ticket(long id_ticket) {
		this.id_ticket=id_ticket;
	}
	
	@Column(name="hora_inicio", nullable=false)
	public Date getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio=hora_inicio;
	}
	
	@Column(name="hora_fin", nullable=false)
	public Date getHora_fin() {
		return hora_fin;
	}
	public void setHora_fin(Date hora_fin) {
		this.hora_fin=hora_fin;
	}

	@Column(name="monto_total", nullable=false)
	public String getMonto_total() {
		return monto_total;
	}
	public void setMonto_total(String monto_total) {
		this.monto_total=monto_total;
	}
}
