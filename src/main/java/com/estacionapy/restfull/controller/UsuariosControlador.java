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

import com.estacionapy.restfull.repository.UsuariosRepository;
import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Usuarios;

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
	public ResponseEntity<Usuarios> getUsuarioById(@PathVariable(value="id") Long usuariosId)
			 throws ResourceNotFoundException {
		  Usuarios usuarios = usuariosRepository.findById(usuariosId)
		          .orElseThrow(() -> new ResourceNotFoundException("No se encuentran usuarios con este id :: " + usuariosId));
		        return ResponseEntity.ok().body(usuarios);
	}
	
	@PostMapping("/usuarios")
	public Usuarios createUsuario(@Valid @RequestBody Usuarios usuario) {
		return usuariosRepository.save(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable(value="id") Long usuarioId,
	         @Valid @RequestBody Usuarios usuarioDetails) throws ResourceNotFoundException {
			Usuarios usuario = usuariosRepository.findById(usuarioId)
	        .orElseThrow(() -> new ResourceNotFoundException("No se encuentran usuarios con este id :: " + usuarioId));

			usuario.setNombre(usuarioDetails.getNombre());
			usuario.setDocumento(usuarioDetails.getDocumento());
			usuario.setNum_documento(usuarioDetails.getNum_documento());
			usuario.setEmail(usuarioDetails.getEmail());
			usuario.setCelular(usuarioDetails.getCelular());
			usuario.setNacionalidad(usuarioDetails.getNacionalidad());
			usuario.setEstado(usuarioDetails.getEstado());
			
			final Usuarios updatedUsuarios = usuariosRepository.save(usuario);
	        return ResponseEntity.ok(updatedUsuarios);
	        
	}
	
	@DeleteMapping("/usuarios/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId)
         throws ResourceNotFoundException {
		Usuarios usuarios = usuariosRepository.findById(usuarioId)
       .orElseThrow(() -> new ResourceNotFoundException("No se encuentran usuarios con este id :: " + usuarioId));

		usuariosRepository.delete(usuarios);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
