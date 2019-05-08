package com.estacionapy.restfull.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionapy.restfull.repository.ManzanasRepository;
import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Manzanas;

@RestController
@RequestMapping("/api/v1")
public class ManzanasControlador {
	@Autowired
	private ManzanasRepository manzanasRepository;
	
	@GetMapping("/manzanas")
	public List<Manzanas> getAllManzanas(){
		return manzanasRepository.findAll();
	}
	
	@GetMapping("/manzanas/{id}")
	public ResponseEntity<Manzanas> getManzanasById(@PathVariable(value="id") Long manzanaId) 
			throws ResourceNotFoundException{
		Manzanas manzana = manzanasRepository.findById(manzanaId)
				.orElseThrow(()->new ResourceNotFoundException("No se encuentran manzanas con este id :: "+manzanaId));
		return ResponseEntity.ok().body(manzana);
	}
	
	@PostMapping("/manzanas")
	public Manzanas createManzana(@Valid @RequestBody Manzanas manzana) {
		return manzanasRepository.save(manzana);
	}
}
