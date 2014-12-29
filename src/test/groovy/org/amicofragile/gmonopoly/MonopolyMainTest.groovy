package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

import org.junit.Before;

class MonopolyMainTest {
	private Scanner input
	private ByteArrayOutputStream outputBuffer
	private PrintStream output
	def static final PLAYERS = [new Player("Horse"), new Player("Cat")]
	
	@Before
	public void initOutput() {
		outputBuffer = new ByteArrayOutputStream();
		output = new PrintStream(outputBuffer);
	}
	
	def setInput(String inputTokens) {
		input = new Scanner(inputTokens)
		input.useDelimiter(" ")
	}
	
	def assertOutputContains(String s) {
		def outputInConsole = outputBuffer.toString()
		assertTrue(outputInConsole.contains(s))
	}
	
	def assertOutputContains(String s, int expectedCount) {
		String outputInConsole = outputBuffer.toString()
		int howManyTimes = 0
		int index = outputInConsole.indexOf(s)
		while(index >= 0 && outputInConsole.size() > index) {
			howManyTimes++
			index = outputInConsole.indexOf(s, index + 1)
		}
		assertEquals(expectedCount, howManyTimes)
	}
	
	@org.junit.Test
	void welcomeAndGoodBye() {
		setInput("exit")
		def main = new MonopolyMain(input, output)
		main.playTheGame(PLAYERS)
		assertOutputContains("Welcome to Monopoly")
		assertOutputContains("Bye.")
	}
	
	@org.junit.Test
	void showsBoardLayout() {
		setInput("exit")
		def main = new MonopolyMain(input, output)
		final String fixedLayout = "MONOPOLY BOARD LAYOUT"
		Board.metaClass.toString = { ->
			fixedLayout
		}
		main.playTheGame(PLAYERS)
		assertOutputContains(fixedLayout)
	}
	
	@org.junit.Test
	void threeIterations() {
		setInput("A A exit")
		def main = new MonopolyMain(input, output)
		final String fixedLayout = "MONOPOLY BOARD LAYOUT"
		Board.metaClass.toString = { ->
			fixedLayout
		}
		main.playTheGame(PLAYERS)
		assertOutputContains(fixedLayout, 3)
	}
}
