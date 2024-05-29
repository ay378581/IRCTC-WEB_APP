package com.ay.response;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "IrctcTicket")
public class TicketResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pnrNo;
	private Integer seatNo,trainNo;
	private String status, DestFrom, DestTo ,name,mid;
	private Double cost;
	private Date JDate;
	private Long phno;
}
