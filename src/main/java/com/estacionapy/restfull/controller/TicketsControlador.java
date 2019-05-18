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

import com.estacionapy.restfull.repository.TicketsRepository;
import com.estacionapy.restfull.exception.ResourceNotFoundException;
import com.estacionapy.restfull.model.Tickets;

@RestController
@RequestMapping("/api/v1")
public class TicketsControlador {
	@Autowired
	private TicketsRepository ticketsRepository;
	
	@GetMapping("/tickets")
	public List<Tickets> getAllTickets(){
		return ticketsRepository.findAll();
	}
	
	@GetMapping("/tickets/{id}")
	public ResponseEntity<Tickets> getTicketById(@PathVariable(value="id") Long ticketId) 
			 throws ResourceNotFoundException {
		  Tickets ticket = ticketsRepository.findById(ticketId)
		          .orElseThrow(() -> new ResourceNotFoundException("No se encuentran tickets con este id :: " + ticketId));
		        return ResponseEntity.ok().body(ticket);
	}
	
	@PostMapping("/tickets")
   public Tickets createTicket(@Valid @RequestBody Tickets ticket) {
       return ticketsRepository.save(ticket);
   }
	
	@PutMapping("/tickets/{id}")
   public ResponseEntity<Tickets> updateTickets(@PathVariable(value = "id") Long ticketId,
        @Valid @RequestBody Tickets ticketDetails) throws ResourceNotFoundException {
		Tickets ticket = ticketsRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encuentran tickets con este id :: " + ticketId));

		ticket.setHora_inicio(ticketDetails.getHora_inicio());
		ticket.setHora_fin(ticketDetails.getHora_fin());
		ticket.setMonto_total(ticketDetails.getMonto_total());

		final Tickets updatedTicket = ticketsRepository.save(ticket);
		return ResponseEntity.ok(updatedTicket);
   }

	@DeleteMapping("/tickets/{id}")
   public Map<String, Boolean> deleteTicket(@PathVariable(value = "id") Long ticketId)
        throws ResourceNotFoundException {
		Tickets ticket = ticketsRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("No se encuentran tickets con este id :: " + ticketId));

		ticketsRepository.delete(ticket);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}
