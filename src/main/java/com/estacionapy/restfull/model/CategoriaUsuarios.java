package com.estacionapy.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias_usuarios")
public class CategoriaUsuarios{
	private long id;
	private String categoria;
	private Boolean estado_categoria;
	
	public CategoriaUsuarios() {
		
	}
	
	public CategoriaUsuarios(String categoria, Boolean estado_categoria) {
		this.categoria=categoria;
		this.estado_categoria=estado_categoria;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	
	@Column(name="categoria", nullable=false)
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria=categoria;
	}
	
	@Column(name="estado_categoria", nullable=false)
	public Boolean getEstadoCategoria() {
		return estado_categoria;
	}
	public void setEstadoCategoria(Boolean estado_categoria) {
		this.estado_categoria=estado_categoria;
	}
	
	@Override
    public String toString() {
        return "CategoriaUsuarios [id=" + id + ", Categoria=" + categoria + ", EstadoCategoria=" + estado_categoria
       + "]";
    }
}