package com.estacionapy.restfull.controller;

import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Saldos;
import com.estacionapy.restfull.repository.SaldosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaldosControlador {
    @Autowired
    private SaldosRepository saldosRepository;

    @GetMapping("/saldos")
    public List<Saldos> getAllManzanas(){
        return saldosRepository.findAll();
    }

    @GetMapping("/saldos/{id}")
    public ResponseEntity<Saldos> getSaldosById(@PathVariable(value="id") Long manzanaId)
            throws ResourceNotFoundException {
        Saldos saldos = saldosRepository.findById(manzanaId)
                .orElseThrow(()->new ResourceNotFoundException("No se encuentran manzanas con este id :: "+manzanaId));
        return ResponseEntity.ok().body(saldos);
    }

    @PostMapping("/saldos")
    public Saldos createSaldos(@Valid @RequestBody Saldos saldos) {
        return saldosRepository.save(saldos);
    }

    @PutMapping("/saldos/{id}")
    public ResponseEntity<Saldos> updateSaldos(@PathVariable(value="id") Long saldoId,
        @Valid @RequestBody Saldos saldoDetails) throws ResourceNotFoundException{
        Saldos saldo = saldosRepository.findById(saldoId)
                .orElseThrow(()-> new ResourceNotFoundException("No se encuentran manzanas con este id :: "+saldoId));
        saldo.setMonto_recarga(saldoDetails.getMonto_recarga());
        saldo.setFecha_recarga(saldoDetails.getFecha_recarga());

        final Saldos updatedSaldo = saldosRepository.save(saldo);
        return ResponseEntity.ok(updatedSaldo);
    }

    @DeleteMapping("/saldos/{id}")
    public Map<String, Boolean> deleteSaldos(@PathVariable(value = "id") Long saldoId)
            throws ResourceNotFoundException{
        Saldos saldo = saldosRepository.findById(saldoId)
                .orElseThrow(()->new ResourceNotFoundException("No se encuentran manzanas con este id :: "+saldoId));

        saldosRepository.delete(saldo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
