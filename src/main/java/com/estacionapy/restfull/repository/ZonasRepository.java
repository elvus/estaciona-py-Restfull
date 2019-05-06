package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Zonas;

@Repository
public interface ZonasRepository extends JpaRepository<Zonas, Long>{
}
