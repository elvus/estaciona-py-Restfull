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

import com.estacionapy.restfull.repository.CategoriaUsuariosRepository;
import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.CategoriaUsuarios;

@RestController
@RequestMapping("/api/v1/")
public class CategoriaUsuariosControlador{
	@Autowired
	private CategoriaUsuariosRepository categoriaUsuariosRepository;
	
	@GetMapping("/categoriaUsuarios")
	public List<CategoriaUsuarios> getAllCategoriaUsuarios(){
		return categoriaUsuariosRepository.findAll();
	}
	
	@GetMapping("/categoriaUsuarios/{id}")
	public ResponseEntity<CategoriaUsuarios> getCategoriaUsuariosById(@PathVariable(value="id") Long categoriaId) 
			 throws ResourceNotFoundException {
		  CategoriaUsuarios categoriaUsuarios = categoriaUsuariosRepository.findById(categoriaId)
		          .orElseThrow(() -> new ResourceNotFoundException("No se encuentran categorias con este id :: " + categoriaId));
		        return ResponseEntity.ok().body(categoriaUsuarios);
	}
	
	@PostMapping("/categoriaUsuarios")
    public CategoriaUsuarios createCategoriaUsuarios(@Valid @RequestBody CategoriaUsuarios categoriaUsuarios) {
        return categoriaUsuariosRepository.save(categoriaUsuarios);
    }
	
	@PutMapping("/categoriaUsuarios/{id}")
    public ResponseEntity<CategoriaUsuarios> updateCategoriaUsuarios(@PathVariable(value = "id") Long categoriaId,
         @Valid @RequestBody CategoriaUsuarios categoriaUsuariosDetails) throws ResourceNotFoundException {
		CategoriaUsuarios categoriaUsuarios = categoriaUsuariosRepository.findById(categoriaId)
        .orElseThrow(() -> new ResourceNotFoundException("No se encuentran categorias con este id :: " + categoriaId));

		categoriaUsuarios.setCategoria(categoriaUsuariosDetails.getCategoria());
		categoriaUsuarios.setEstadoCategoria(categoriaUsuariosDetails.getEstadoCategoria());
		final CategoriaUsuarios updatedCategoriaUsuarios = categoriaUsuariosRepository.save(categoriaUsuarios);
        return ResponseEntity.ok(updatedCategoriaUsuarios);
    }

	@DeleteMapping("/categoriaUsuarios/{id}")
    public Map<String, Boolean> deleteCategoriaUsuarios(@PathVariable(value = "id") Long categoriaId)
         throws ResourceNotFoundException {
		CategoriaUsuarios categoriaUsuarios = categoriaUsuariosRepository.findById(categoriaId)
       .orElseThrow(() -> new ResourceNotFoundException("No se encuentran categorias con este id :: " + categoriaId));

		categoriaUsuariosRepository.delete(categoriaUsuarios);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}