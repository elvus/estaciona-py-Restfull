package com.estacionapy.restfull.controller;


import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Infracciones;
import com.estacionapy.restfull.repository.InfraccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InfraccionesControlador {
    @Autowired
    private InfraccionesRepository infraccionesRepository;

    @GetMapping("/infracciones")
    public List<Infracciones> getAllInfracciones(){
        return infraccionesRepository.findAll();
    }

    @GetMapping("/infracciones/{id}")
    public ResponseEntity<Infracciones> getInfraccionesById(@PathVariable(value="id") Long infraccionesId)
            throws ResourceNotFoundException {
        Infracciones Infracciones = infraccionesRepository.findById(infraccionesId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentran infracciones con este id :: " + infraccionesId));
        return ResponseEntity.ok().body(Infracciones);
    }

    @PostMapping("/infracciones")
    public Infracciones createInfracciones(@Valid @RequestBody Infracciones Infracciones) {
        return infraccionesRepository.save(Infracciones);
    }

    @PutMapping("/infracciones/{id}")
    public ResponseEntity<Infracciones> updateInfracciones(@PathVariable(value = "id") Long infraccionesId,
                                                           @Valid @RequestBody Infracciones infracionesDetails) throws ResourceNotFoundException {
        Infracciones infracciones = infraccionesRepository.findById(infraccionesId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentran infracciones con este id :: " + infraccionesId));

        infracciones.setDescripcion(infracionesDetails.getDescripcion());
        infracciones.setEstado_infraccion(infracionesDetails.getEstado_infraccion());
        final Infracciones updatedInfracciones = infraccionesRepository.save(infracciones);
        return ResponseEntity.ok(updatedInfracciones);
    }

    @DeleteMapping("/infracciones/{id}")
    public Map<String, Boolean> deleteCategoriaUsuario(@PathVariable(value = "id") Long infraccionesId)
            throws ResourceNotFoundException {
        Infracciones infracciones = infraccionesRepository.findById(infraccionesId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentran infracciones con este id :: " + infraccionesId));

        infraccionesRepository.delete(infracciones);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
