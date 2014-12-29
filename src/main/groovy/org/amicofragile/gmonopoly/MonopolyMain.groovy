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
			go = (!"exit".equalsIgnoreCase(inputToken) && !game.isCompleted())
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
	
	static main(args) {
		Scanner input = new Scanner(System.in)
		input.useDelimiter(System.getProperty("line.separator"))
		def players = []
		args.each {
			players << new Player(it)
		}
		def main = new MonopolyMain(input, System.out)
		main.playTheGame(players)
	}
}
