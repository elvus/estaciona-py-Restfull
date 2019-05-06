package com.estacionapy.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionapy.restfull.model.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long>{
}
