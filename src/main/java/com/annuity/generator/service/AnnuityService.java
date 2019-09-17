package com.annuity.generator.service;

import java.util.List;

import com.annuity.generator.dto.AnnuityPlan;
import com.annuity.generator.dto.LoanDetails;

public interface AnnuityService {
	public List<AnnuityPlan> getAnnuityPlan(LoanDetails loanDetails);
	

}
