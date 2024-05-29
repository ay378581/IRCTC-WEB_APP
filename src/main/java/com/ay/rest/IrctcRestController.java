package com.ay.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ay.request.PassengerRequest;
import com.ay.response.TicketResponse;
import com.ay.service.IrctcService;

@RestController
public class IrctcRestController {

	@Autowired
	private IrctcService service;

	@PostMapping(value = "/bookticket", consumes = { "application/xml", "application/json" }

	)
	public ResponseEntity<String> bookTicket(@RequestBody PassengerRequest request) {
		Long pnr = service.saveTicket(request);
		String msg = "Ticket Booking Completed :: " + pnr;
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{pnr}", produces = { "application/xml", "application/json" }

	)
	public ResponseEntity<TicketResponse> getTicket(@PathVariable Long pnr) {
		TicketResponse res = service.getTicketByPnr(pnr);
		return new ResponseEntity<TicketResponse>(res, HttpStatus.OK);
	}

	@PutMapping(value = "/ticket/update", consumes = { "application/xml", "application/json" }

	)
	public ResponseEntity<String> updateTicket(@RequestBody TicketResponse response) {
		String msg = service.updateTicket(response);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/ticket/{pnr}", produces = { "application/xml", "application/json" }

	)
	public ResponseEntity<String> deleteTicket(@PathVariable Long pnr) {
		String msg = service.deleteTicket(pnr);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
