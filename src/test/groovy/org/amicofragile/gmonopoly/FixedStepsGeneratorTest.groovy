package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

class FixedStepsGeneratorTest {
	@org.junit.Test
	void generateHundredTimesTheSameStepsNumber() {
		int stepsNumber = 7
		StepsGenerator generator = new FixedStepsGenerator(stepsNumber)
		100.times {
			assertEquals(stepsNumber, generator.generateStepsNumber())
		}
	}
}
