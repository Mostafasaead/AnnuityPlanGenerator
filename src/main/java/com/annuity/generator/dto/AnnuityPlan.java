package com.annuity.generator.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import lombok.Data;

@Data
public class AnnuityPlan {
	Double borrowerPaymentAmount;			/* THE MONTHLY INSTALLMENT AMOUNT */
	Date date; 								/* THE INSTALLMENT DATE */
	Double initialOutstandingPrincipal; 	/* THE INITIAL OUTSTANING PRINCIPAL */
	Float interest; 						/* THE INTEREST AMOUNT PER MONTH */
	Double principal; 						/* THE INSTALLMENT AMOUNT PER MONTH WITHOUT THE INTREST */
	Double remainingOutstandingPrincipal; 	/* THE REMAING OUTSTANDING PRINCIPAL */
	
	
	
	
	   public void setBorrowerPaymentAmount(Double borrowerPaymentAmount) {
	        BigDecimal bd = new BigDecimal(borrowerPaymentAmount).setScale(2, RoundingMode.HALF_UP);
	        this.borrowerPaymentAmount = bd.doubleValue();
	    }
	   public void setInitialOutstandingPrincipal(Double initialOutstandingPrincipal) {
	        BigDecimal bd = new BigDecimal(initialOutstandingPrincipal).setScale(2, RoundingMode.HALF_UP);
	        this.initialOutstandingPrincipal = bd.doubleValue();
	    }
	   public void setInterest(Float interest) {
	        BigDecimal bd = new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP);
	        this.interest = bd.floatValue();
	    }
	   public void setPrincipal(Double principal) {
	        BigDecimal bd = new BigDecimal(principal).setScale(2, RoundingMode.HALF_UP);
	        this.principal = bd.doubleValue();
	    }
	   public void setRemainingOutstandingPrincipal(Double remainingOutstandingPrincipal) {
	        BigDecimal bd = new BigDecimal(remainingOutstandingPrincipal).setScale(2, RoundingMode.HALF_UP);
	        this.remainingOutstandingPrincipal = bd.doubleValue();
	    }
	   
}
