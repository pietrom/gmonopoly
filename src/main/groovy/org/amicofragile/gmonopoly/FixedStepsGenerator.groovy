package org.amicofragile.gmonopoly

class FixedStepsGenerator implements StepsGenerator {
	private final int stepsNumber
	
	def FixedStepsGenerator(int stepsNumber) {
		this.stepsNumber = stepsNumber
	}
	
	@Override
	public int generateStepsNumber() {
		stepsNumber
	}
}
