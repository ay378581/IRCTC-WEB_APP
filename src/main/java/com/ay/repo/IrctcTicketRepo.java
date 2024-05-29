package com.ay.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ay.response.TicketResponse;

@Repository
public interface IrctcTicketRepo extends JpaRepository<TicketResponse, Long> {
}
