package org.amicofragile.gmonopoly

class MonopolyGame {
	private Board board
	private List players
	
	def MonopolyGame(Board board, List players) {
		if(players.size() < 2 || players.size() > 8) {
			throw new IllegalArgumentException("Can't play with lesser than two or more than eight Players")
		}
		this.board = board
		this.players = players
		players.each {
			it.location = board.first
		}
	}
}
