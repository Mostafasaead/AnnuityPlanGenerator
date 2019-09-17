package com.annuity.generator.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.annuity.generator.dto.AnnuityPlan;
import com.annuity.generator.dto.LoanDetails;

@Service
public class AnnuityServiceImpl implements AnnuityService {
	private final static Integer YEAR_DAYS = 360;
	private final static Integer MONTH_DAYS = 30;

	@Override
	public List<AnnuityPlan> getAnnuityPlan(LoanDetails loanDetails) {
		/*
		 * Convert interest rate into a decimal eg. 5% = 0.05
		 */
		double interestRate = loanDetails.getNominalRate() / 100.0;
		double initialOutStandingAmount = loanDetails.getLoanAmount();
		List<AnnuityPlan> annuityPlans = new ArrayList<AnnuityPlan>();
		/*
		 * Monthly interest rate is the yearly rate divided by 12
		 */
		double monthlyRate = interestRate / 12.0;
		Calendar cal = Calendar.getInstance();
		Date date = loanDetails.getStartDate();
		cal.setTime(date);
		while (initialOutStandingAmount > 0) {
			Double monthlyIntrest = (initialOutStandingAmount * interestRate * MONTH_DAYS) / (YEAR_DAYS);
			double annuity = (loanDetails.getLoanAmount() * monthlyRate)
					/ (1 - Math.pow(1 + monthlyRate, -loanDetails.getDuration()));
			if (monthlyIntrest > initialOutStandingAmount) {
				monthlyIntrest = initialOutStandingAmount;
			}
			double principal = annuity - monthlyIntrest;
			annuityPlans.add(createAnnuityPlan(initialOutStandingAmount, annuity, principal, monthlyIntrest, cal));
			initialOutStandingAmount -= principal;
		}

		return annuityPlans;
	}

	private AnnuityPlan createAnnuityPlan(Double initialOutStandingAmount, Double annuity, Double principal,
			Double monthlyIntrest, Calendar cal) {

		AnnuityPlan annuityPlan = new AnnuityPlan();
		annuityPlan.setInitialOutstandingPrincipal(initialOutStandingAmount);
		annuityPlan.setBorrowerPaymentAmount(annuity);
		annuityPlan.setInterest(monthlyIntrest.floatValue());
		annuityPlan.setPrincipal(principal);
		annuityPlan.setDate(cal.getTime());
		annuityPlan.setRemainingOutstandingPrincipal(
				initialOutStandingAmount - principal < 0 ? 0 : initialOutStandingAmount - principal);
		cal.add(Calendar.MONTH, 1);
		return annuityPlan;
	}

	public static void main(String[] args) {
//		double annuity = (5000 * (.05 / 12)) / (1 - Math.pow(1 + (.05 / 12), -24));
//		System.out.println(annuity);
		AnnuityServiceImpl a = new AnnuityServiceImpl();
		LoanDetails l = new LoanDetails();
		l.setDuration(24);
		l.setStartDate(new Date());
		l.setNominalRate(5f);
		l.setLoanAmount(5000d);
		System.out.println("hi");
		List<AnnuityPlan> apl = a.getAnnuityPlan(l);
		System.out.println(a.getAnnuityPlan(l).size());
		for (AnnuityPlan ap : apl) {
			System.out.println(ap.getBorrowerPaymentAmount());
			System.out.println(ap.getDate());
			System.out.println(ap.getInitialOutstandingPrincipal());
			System.out.println(ap.getInterest());
			System.out.println(ap.getPrincipal());
			System.out.println(ap.getRemainingOutstandingPrincipal());
		}

	}

//	private double RoundTo2Decimals(double val) {
//		DecimalFormat df2 = new DecimalFormat("###.##");
//		return Double.valueOf(df2.format(val));
//	}
}
