package org.bpmnwithactiviti.chapter9;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.bpmnwithactiviti.chapter9.logic.CreditCheckRuleRunner;
import org.bpmnwithactiviti.chapter9.model.CreditCheckResult;
import org.bpmnwithactiviti.chapter9.model.LoanApplicant;
import org.junit.Test;

public class CreditCheckTest {
	
	@Test
	public void testCreditCheckFailed(){
		LoanApplicant piggy = new LoanApplicant();
		piggy.setName("Miss Piggy");
		piggy.setIncome(100);
		piggy.setLoanAmount(90);
		
		CreditCheckResult result = null;
		
		try {
			 result = CreditCheckRuleRunner.runRules(piggy);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		assertFalse(result.isCreditCheckPassed());
	}
	
	@Test
	public void testCreditCheckPassed(){
		LoanApplicant kermit = new LoanApplicant();
		kermit.setName("Kermit");
		kermit.setIncome(1000);
		kermit.setLoanAmount(10);
		
		CreditCheckResult result = null;
		
		try {
			 result = CreditCheckRuleRunner.runRules(kermit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(result.isCreditCheckPassed());
	}
	
}
