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

import com.estacionapy.restfull.repository.LotesRepository;
import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Lotes;

@RestController
@RequestMapping("/api/v1")
public class LotesControlador {
	@Autowired
	private LotesRepository lotesRepository;
	
	@GetMapping("/lotes")
	public List<Lotes> getAllUsuarios(){
		return lotesRepository.findAll();
	}
	
	@GetMapping("/lotes/{id}")
	public ResponseEntity<Lotes> getLotesById(@PathVariable(value="id") Long loteId)
	throws ResourceNotFoundException{
		Lotes lotes = lotesRepository.findById(loteId)
				.orElseThrow(()->new ResourceNotFoundException("No se encuentran lotes con este id :: "+loteId));
	return ResponseEntity.ok().body(lotes);
	}
	
	@PostMapping("/lotes")
	public Lotes createLote(@Valid @RequestBody Lotes lote) {
		return lotesRepository.save(lote);
	}
	
	@PutMapping("/lotes/{id}")
	public ResponseEntity<Lotes> updateLote(@PathVariable(value="id")Long loteId,
			@Valid @RequestBody Lotes loteDetails) throws ResourceNotFoundException{
		Lotes lote = lotesRepository.findById(loteId)
				.orElseThrow(()-> new ResourceNotFoundException("No se encuentran lotes con este id :: "+loteId));
		lote.setEstado_lote(loteDetails.getEstado_lote());
		lote.setDimension(loteDetails.getDimension());
		
		final Lotes updatedLote = lotesRepository.save(lote);
		return ResponseEntity.ok(updatedLote);
	}
	
	@DeleteMapping("/lotes/{id}")
	public Map<String, Boolean> deleteLote(@PathVariable(value="id") Long loteId)
	throws ResourceNotFoundException{
		Lotes lote = lotesRepository.findById(loteId)
				.orElseThrow(()->new ResourceNotFoundException("No se encuentran lotes con este id :: "+loteId));
		lotesRepository.delete(lote);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
