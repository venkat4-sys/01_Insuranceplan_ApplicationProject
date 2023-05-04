package com.ashokit.searchreq;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
	
	private String Plan_Name ;
	private String Plan_Status;
	private String gender;
	private String startDate;
	private String endDate;

}
