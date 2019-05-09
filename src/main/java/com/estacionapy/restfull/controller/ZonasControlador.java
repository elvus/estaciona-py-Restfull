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

import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Zonas;
import com.estacionapy.restfull.repository.ZonasRepository;

@RestController
@RequestMapping("/api/v1")
public class ZonasControlador {
	@Autowired
	private ZonasRepository zonasRepository;
	
	@GetMapping("/zonas")
	public List<Zonas> getAllZonas(){
		return zonasRepository.findAll();
	}
	
	@GetMapping("/zonas/{id}")
	public ResponseEntity<Zonas> getZonasById(@PathVariable(value="id") Long zonasId) 
			 throws ResourceNotFoundException {
		Zonas zona = zonasRepository.findById(zonasId)
		          .orElseThrow(() -> new ResourceNotFoundException("No se encuentran zonas con este id :: " + zonasId));
		        return ResponseEntity.ok().body(zona);
	}
	
	@PostMapping("/zonas")
	public Zonas createZonas(@Valid @RequestBody Zonas zona) {
		return zonasRepository.save(zona);
	}
	
	@PutMapping("/zonas/{id}")
	public ResponseEntity<Zonas> updateZonas(@PathVariable(value = "id") Long zonasId,
			@Valid @RequestBody Zonas zonaDetails) throws ResourceNotFoundException {
		Zonas zona = zonasRepository.findById(zonasId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encuentran zonas con este id :: " + zonasId));
		zona.setCosto(zonaDetails.getCosto());
		zona.setDescripcion(zonaDetails.getDescripcion());
		zona.setEstado_zona(zonaDetails.getEstado_zona());
		
		final Zonas updatedZona = zonasRepository.save(zona);
		return ResponseEntity.ok(updatedZona);
	}

	@DeleteMapping("/zonas/{id}")
	public Map<String, Boolean> deleteZonas(@PathVariable(value = "id") Long zonasId)
        throws ResourceNotFoundException {
		Zonas zona = zonasRepository.findById(zonasId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encuentran zonas con este id :: " + zonasId));

		zonasRepository.delete(zona);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
