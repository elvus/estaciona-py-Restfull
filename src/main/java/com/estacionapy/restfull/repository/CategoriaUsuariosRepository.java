package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.CategoriaUsuarios;

@Repository
public interface CategoriaUsuariosRepository extends JpaRepository<CategoriaUsuarios, Long>{

}
