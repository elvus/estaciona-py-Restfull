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
	private long id_categoria_usuario;
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
	public long getId_categoria_usuario() {
		return id_categoria_usuario;
	}
	public void setId_categoria_usuario(long id_categoria_usuario) {
		this.id_categoria_usuario=id_categoria_usuario;
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
        return "CategoriaUsuarios [id=" + id_categoria_usuario + ", Categoria=" + categoria + ", EstadoCategoria=" + estado_categoria
       + "]";
    }
}