package com.annuity.generator.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LoanDetails {
	@NotNull
	Double loanAmount; 		/* THE TARGET LOAN AMOUNT */
	@NotNull
	Float nominalRate;		/* THE INTEREST RATE */
	@NotNull
	Integer duration; 		/* duration in months eg.(24 for 2 years) */
	@NotNull @DateTimeFormat
	Date startDate; 		/* THE DATE OF FIRST INSTALLMENT WITH FORMAT (YYYY-MM-DDTHH:mm:HHZ)*/
}
