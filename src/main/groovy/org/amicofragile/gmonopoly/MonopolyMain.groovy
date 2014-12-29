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
		boolean go = true
		while(go) {
			output.println board.toString()
			game.playARound()
			def inputToken = input.next()
			go = (!"exit".equalsIgnoreCase(inputToken))
		}
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
