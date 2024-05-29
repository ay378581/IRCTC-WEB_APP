package com.ay.request;

import java.util.Date;

import lombok.Data;

@Data
public class PassengerRequest {

	private String name,email,from,to;
	private Long phno;
	private Integer trainNo;
	private Date JDate;	
}
