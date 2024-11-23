package com.design_pattern.template;

public class TeaMaker extends BeverageMaker{

	@Override
	protected void addCondiments() {
		 System.out.println("Adding lemon");
		
	}

	@Override
	protected void brew() {
		System.out.println("Steeping the tea");
		
	}
	

}
