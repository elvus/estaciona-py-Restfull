package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Vehiculos;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculos, Long> {
}
