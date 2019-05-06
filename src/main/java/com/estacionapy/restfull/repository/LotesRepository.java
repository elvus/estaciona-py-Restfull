package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Lotes;

@Repository
public interface LotesRepository extends JpaRepository<Lotes, Long> {
	
}
