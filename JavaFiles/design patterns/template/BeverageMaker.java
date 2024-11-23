package com.design_pattern.template;

abstract class BeverageMaker {
	//Template method
	public final void makeBeverage() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
		
	}

    // Abstract methods to be implemented by subclasses
	protected abstract void addCondiments();
	protected abstract void brew();

	// Common methods
	private void pourInCup() {
		System.out.println("Pouring into cup");
		
	}


	private void boilWater() {
		System.out.println("Boiling water");
		
	}
}
