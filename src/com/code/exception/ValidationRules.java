package com.code.exception;

import java.time.LocalDate;
import java.util.List;

import com.code.Customer;
import com.code.ServicePlan;

import custom_exceptions.InvalidInputException;

public class ValidationRules {
	
	//method to parse and validate service plan
	public static ServicePlan parseAndValidatePlan(String plan) throws InvalidInputException {
		return ServicePlan.valueOf(plan.toUpperCase());
	}
	
	//method to validate reg amount with plan
	public static void validatePlanAmount(ServicePlan plan,double regAmount)throws InvalidInputException {
		if(plan.getPlanCost()!=regAmount) throw new InvalidInputException("Registration amount does not match with the plan");
		
	}
	
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	//method to validate all i/ps
	

	/*int customerId, String firstName, String lastName, String email, String password, double regAmount,
	LocalDate dob, ServicePlan plan*/
	
	public static Customer validateAllInputs(String firstName, String lastName, String email, String password, double regAmount,
			String dob, String plan,List<Customer> customers) throws InvalidInputException {
		validateEmail(email,customers);
		ServicePlan validatePlan = parseAndValidatePlan(plan);
		validatePlanAmount(validatePlan,regAmount);
		LocalDate date = parseDate(dob);
		return new Customer(firstName,lastName,email,password,regAmount,date,validatePlan);
		
		
		
	}

}
