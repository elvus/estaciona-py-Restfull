package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Infracciones;

@Repository
public interface InfraccionesRepository extends JpaRepository<Infracciones, Long>{

}
