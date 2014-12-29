package org.amicofragile.gmonopoly

class MonopolyMain {
	private Scanner input
	private PrintStream output
	
	def MonopolyMain(Scanner input, PrintStream output) {
		this.input = input
		this.output = output
	}
	
	def playTheGame() {
		output.println "Welcome to Monopoly"
		output.println "Bye."
	}
}
