package com.annuity.generator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annuity.generator.dto.AnnuityPlan;
import com.annuity.generator.dto.LoanDetails;
import com.annuity.generator.service.AnnuityService;

@RestController
@RequestMapping("/generate-plan")
public class AnnuityController {
	@Autowired
	AnnuityService annuityService;

	@PostMapping
	public ResponseEntity<List<AnnuityPlan>> generateAnnuityPlan(
			@RequestBody(required = true) LoanDetails loanDetailsReq) {
		return new ResponseEntity<>(annuityService.getAnnuityPlan(loanDetailsReq), HttpStatus.OK);

	}
}
