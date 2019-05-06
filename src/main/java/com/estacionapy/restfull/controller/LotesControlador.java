package com.estacionapy.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionapy.restfull.repository.LotesRepository;
import com.estacionapy.restfull.model.Lotes;

@RestController
@RequestMapping("/api/v1")
public class LotesControlador {
	@Autowired
	private LotesRepository lotesRepository;
	
	@GetMapping("/lotes")
	public List<Lotes> getAllUsuarios(){
		return lotesRepository
	}
}
