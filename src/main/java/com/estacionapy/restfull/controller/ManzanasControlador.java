package com.estacionapy.restfull.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/manzanas/{id}")
	public ResponseEntity<Manzanas> updateManzanas(@PathVariable(value="id") Long manzanaId,
			@Valid @RequestBody Manzanas manzanaDetails) throws ResourceNotFoundException{
		Manzanas manzana = manzanasRepository.findById(manzanaId)
				.orElseThrow(()-> new ResourceNotFoundException("No se encuentran manzanas con este id :: "+manzanaId));
		manzana.setNum_manzana(manzanaDetails.getNum_manzana());
		manzana.setUbicacion(manzanaDetails.getUbicacion());
		
		final Manzanas updatedManzana = manzanasRepository.save(manzana);
		return ResponseEntity.ok(updatedManzana);
	}
	
	@DeleteMapping("/manzanas/{id}")
	public Map<String, Boolean> deleteManzana(@PathVariable(value = "id") Long manzanaId)
			throws ResourceNotFoundException{
		Manzanas manzana = manzanasRepository.findById(manzanaId)
				.orElseThrow(()->new ResourceNotFoundException("No se encuentran manzanas con este id :: "+manzanaId));
		
		manzanasRepository.delete(manzana);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
