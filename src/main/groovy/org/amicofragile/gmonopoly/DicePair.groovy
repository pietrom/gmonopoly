package org.amicofragile.gmonopoly;

import java.util.Random;

class DicePair {
	private final Random random = new Random()
	
	public int generateStepsNumber() {
		random.nextInt(12) + 1
	}
}
