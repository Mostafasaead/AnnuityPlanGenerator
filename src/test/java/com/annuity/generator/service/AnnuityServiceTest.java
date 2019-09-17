package com.annuity.generator.service;

import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.annuity.generator.dto.AnnuityPlan;
import com.annuity.generator.dto.LoanDetails;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AnnuityServiceTest {
	@InjectMocks
	private AnnuityServiceImpl annuityService;


	@Test
	public void generateAnnuityPlanTest() {
		List<AnnuityPlan> annuityPlan = annuityService.getAnnuityPlan(createLoanDetails());
		assertFalse(annuityPlan.isEmpty());

	}

	public LoanDetails createLoanDetails() {
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setDuration(24);
		loanDetails.setStartDate(new Date());
		loanDetails.setNominalRate(5f);
		loanDetails.setLoanAmount(5000d);
		return loanDetails;
	}
}
