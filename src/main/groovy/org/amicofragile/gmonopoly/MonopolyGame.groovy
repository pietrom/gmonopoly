package org.amicofragile.gmonopoly

class MonopolyGame {
	private Board board
	private DicePair dices
	private List players

	def MonopolyGame(Board board, List players) {
		if(players.size() < 2 || players.size() > 8) {
			throw new IllegalArgumentException("Can't play with lesser than two or more than eight Players")
		}
		this.board = board
		this.dices = new DicePair()
		this.players = players
		players.each {
			it.location = board.first
		}
	}

	def play() {
		Collections.shuffle(players)
		20.times {
			players.each { it.play(dices) }
		}
	}
}
