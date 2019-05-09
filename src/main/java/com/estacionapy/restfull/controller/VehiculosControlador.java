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
import com.estacionapy.restfull.model.Vehiculos;
import com.estacionapy.restfull.repository.VehiculosRepository;

@RestController
@RequestMapping("/api/v1")
public class VehiculosControlador {
	@Autowired
	private VehiculosRepository vehiculosRepository;
	
	@GetMapping("/vehiculos")
	public List<Vehiculos> getAllVehiculos(){
		return vehiculosRepository.findAll();
	}
	
	@GetMapping("/vehiculos/{id}")
	public ResponseEntity<Vehiculos> getVehiculoById(@PathVariable(value="id") Long vehiculoId) 
			 throws ResourceNotFoundException {
		  Vehiculos vehiculo = vehiculosRepository.findById(vehiculoId)
		          .orElseThrow(() -> new ResourceNotFoundException("No se encuentran vehiculos con este id :: " + vehiculoId));
		        return ResponseEntity.ok().body(vehiculo);
	}
	
	@PostMapping("/vehiculos")
	public Vehiculos createVehiculo(@Valid @RequestBody Vehiculos vehiculo) {
		return vehiculosRepository.save(vehiculo);
	}
	
	@PutMapping("/vehiculos/{id}")
	public ResponseEntity<Vehiculos> updateVehiculo(@PathVariable(value = "id") Long vehiculoId,
			@Valid @RequestBody Vehiculos vehiculoDetails) throws ResourceNotFoundException {
		Vehiculos vehiculo = vehiculosRepository.findById(vehiculoId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encuentran tickets con este id :: " + vehiculoId));
		vehiculo.setChapa(vehiculoDetails.getChapa());
		
		final Vehiculos updatedVehiculo = vehiculosRepository.save(vehiculo);
		return ResponseEntity.ok(updatedVehiculo);
	}

	@DeleteMapping("/vehiculos/{id}")
	public Map<String, Boolean> deleteVehiculo(@PathVariable(value = "id") Long vehiculoId)
        throws ResourceNotFoundException {
		Vehiculos vehiculo = vehiculosRepository.findById(vehiculoId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encuentran vehiculos con este id :: " + vehiculoId));

		vehiculosRepository.delete(vehiculo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
