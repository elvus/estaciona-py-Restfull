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
import com.estacionapy.restfull.model.Usuarios;
import com.estacionapy.restfull.repository.UsuariosRepository;

@RestController
@RequestMapping("/api/v1")
public class UsuariosControlador {
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping("/usuarios")
	public List<Usuarios> getAllUsuarios(){
		return usuariosRepository.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> getCategoriaUsuariosById(@PathVariable(value="id") String usuarioId)
			 throws ResourceNotFoundException {
		  Usuarios usuarios = usuariosRepository.findById(usuarioId)
		          .orElseThrow(() -> new ResourceNotFoundException("No se encuentran usuarios con este id :: " + usuarioId));
		        return ResponseEntity.ok().body(usuarios);
	}
	
	@PostMapping("/usuarios")
    public Usuarios createEmployee(@Valid @RequestBody Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }
	
	@PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuarios> updateEmployee(@PathVariable(value = "id") String usuarioId,
         @Valid @RequestBody Usuarios usuariosDetails) throws ResourceNotFoundException {
		Usuarios usuario = usuariosRepository.findById(usuarioId)
        .orElseThrow(() -> new ResourceNotFoundException("No se encuentran usuarios con este id :: " + usuarioId));

		usuario.setNombre(usuariosDetails.getNombre());
		usuario.setDocumento(usuariosDetails.getDocumento());
		usuario.setNum_documento(usuariosDetails.getNum_documento());
		usuario.setEmail(usuariosDetails.getEmail());
		usuario.setCelular(usuariosDetails.getCelular());
		usuario.setNacionalidad(usuariosDetails.getNacionalidad());
		usuario.setEstado(usuariosDetails.getEstado());
		final Usuarios updatedUsuarios = usuariosRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuarios);
    }

	@DeleteMapping("/usuarios/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") String usuarioId)
         throws ResourceNotFoundException {
		Usuarios usuario = usuariosRepository.findById(usuarioId)
       .orElseThrow(() -> new ResourceNotFoundException("No se encuentran usuarios con este id :: " + usuarioId));

		usuariosRepository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
}
