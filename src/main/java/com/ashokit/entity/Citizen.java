package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CITIZEN_PLANS_INFO")
public class Citizen {
	
	@Id
	private Integer CITIZEN_ID;
	
	private String CITIZEN_NAME;
	private String GENDER;
    private String PLAN_NAME;
	private String PLAN_STATUS;
	private LocalDate PLAN_START_DATE;
	private LocalDate PLAN_END_DATE;
	private Integer BENEFIT_AMOUNT;
	private String DENIAL_REASON;
	private LocalDate TERMINATED_DATE;
	private String TERMINATION_REASON;
	
}
