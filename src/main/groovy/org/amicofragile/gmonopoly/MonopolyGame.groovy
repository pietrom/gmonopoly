package org.amicofragile.gmonopoly

class MonopolyGame {
	private Board board
	private List players
	
	def MonopolyGame(Board board, List players) {
		this.board = board
		this.players = players
		players.each {
			it.location = board.first
		}
	}
}
