package org.amicofragile.gmonopoly

class MonopolyMain {
	private Scanner input
	private PrintStream output
	
	def MonopolyMain(Scanner input, PrintStream output) {
		this.input = input
		this.output = output
	}
	
	def playTheGame(List players) {
		output.println "Welcome to Monopoly"
		def board = buildBoard()
		def game = new MonopolyGame(board, players)
		output.println board.toString()
		output.println "Bye."
	}
	
	private buildBoard() {
		Board board = new Board()
		(0..39).each {
			board.addLocation(new BoardLocation("LOC ${it}"))
		}
		return board
	}
}
