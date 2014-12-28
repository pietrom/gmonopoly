package org.amicofragile.gmonopoly;

import java.util.Random;

class DicePair implements StepsGenerator {
	private final Random random = new Random()
	
	@Override
	public int generateStepsNumber() {
		random.nextInt(12) + 1
	}
}
