package com.estacionapy.restfull.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
    private long id;
    private String nombre;
    private String documento;
    private String num_documento;
    private String email;
    private String celular;
    private String nacionalidad;
    private Boolean estado;

    public Usuarios(){

    }

    public Usuarios(String nombre, String documento, String num_documento, String email, String celular, String nacionalidad, Boolean estado){
        this.nombre=nombre;
        this.documento=documento;
        this.num_documento=num_documento;
        this.email=email;
        this.celular=celular;
        this.nacionalidad=nacionalidad;
        this.estado=estado;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id=id;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    @Column(name = "documento", nullable = false)
    public String getDocumento(){
        return documento;
    }
    public void setDocumento(String documento){
        this.documento=documento;
    }

    @Column(name = "num_documento", nullable = false)
    public String getNum_documento(){
        return num_documento;
    }
    public void setNum_documento(String num_documento){
        this.num_documento=num_documento;
    }

    @Column(name="email", nullable = false)
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    @Column(name = "celular", nullable = false)
    public String getCelular(){
        return celular;
    }
    public void setCelular(String celular){
        this.celular=celular;
    }
    
    @Column(name = "nacionalidad", nullable = false)
    public String getNacionalidad(){
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }

    @Column(name = "estado", nullable = false)
    public Boolean getEstado(){
        return estado;
    }
    public void setEstado(Boolean estado){
        this.estado=estado;
    }

    @Override
    public String toString() {
        return "Usuarios[" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", num_documento='" + num_documento + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", estado=" + estado +
                ']';
    }
}
