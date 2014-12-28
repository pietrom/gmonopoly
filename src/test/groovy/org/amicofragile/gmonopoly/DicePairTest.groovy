package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

class DicePairTest {
	@org.junit.Test
	void rollingTheDicesTwoHundredTimesGenerateAtLeastTenDifferentNumbers() {
		StepsGenerator generator = new DicePair()
		def generated = []
		200.times {
			def current = generator.generateStepsNumber()
			if(!generated.contains(current)) {
				generated << current
			}
		}
		assertTrue(generated.size() >= 10)
	}
}
