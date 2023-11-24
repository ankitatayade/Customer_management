package com.code;

public enum ServicePlan {
	SILVER(3000), GOLD(5000),DIAMOND(7000),PLATINUM(10000);
	
	private int planCost;

	private ServicePlan(int planCost) {
		this.planCost = planCost;
	}

	public int getPlanCost() {
		return planCost;
	}
	
	

}
