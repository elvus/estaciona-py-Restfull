package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Manzanas;

@Repository
public interface ManzanasRepository extends JpaRepository<Manzanas, Long> {
	
}
