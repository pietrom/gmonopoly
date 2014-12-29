package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

import org.junit.Before;

class MonopolyMainTest {
	private Scanner input
	private ByteArrayOutputStream outputBuffer
	private PrintStream output
	
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
	
	@org.junit.Test
	void singleRoundAndExit() {
		setInput("exit") 
		def main = new MonopolyMain(input, output)
		main.playTheGame()
		assertOutputContains("Welcome to Monopoly")
		assertOutputContains("Bye.")
	}
}
