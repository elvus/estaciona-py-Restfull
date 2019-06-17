package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String>{

}
