package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Saldos;

@Repository
public interface SaldosRepository extends JpaRepository<Saldos, Long>{

}
