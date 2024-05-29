package com.ay.service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.repo.IrctcTicketRepo;
import com.ay.request.PassengerRequest;
import com.ay.response.TicketResponse;

@Service
public class IrctcService {

	@Autowired
	private IrctcTicketRepo repo;

	public Long saveTicket(PassengerRequest req) {
		TicketResponse res = new TicketResponse();
		res.setName(req.getName());
		res.setStatus("Confirmed");
		res.setCost(1512.30);
		res.setDestFrom(req.getFrom());
		res.setDestTo(req.getTo());
		res.setJDate(new Date());
		res.setMid(req.getEmail());
		res.setPhno(req.getPhno());
		res.setTrainNo(req.getTrainNo());
		res.setSeatNo(new Random().nextInt(1, 74));

		TicketResponse response = repo.save(res);
		return response.getPnrNo();
	}

	public TicketResponse getTicketByPnr(Long pnr) {

		Optional<TicketResponse> opt = repo.findById(pnr);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	public String updateTicket(TicketResponse res) {
		 repo.save(res);
		return "Ticket Updated";
	}

	public String deleteTicket(Long pnr) {
		repo.deleteById(pnr);
		return "Ticket Deleted";
	}
}
