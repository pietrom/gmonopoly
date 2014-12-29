package org.amicofragile.gmonopoly

class MonopolyGame {
	private static final int TOTAL_ROUNDS = 20
	private Board board
	private DicePair dices
	private List players
	private int playedRounds = 0

	def MonopolyGame(Board board, List players) {
		if(players.size() < 2 || players.size() > 8) {
			throw new IllegalArgumentException("Can't play with lesser than two or more than eight Players")
		}
		this.board = board
		this.dices = new DicePair()
		this.players = players
		players.each {
			it.checkInTo(board.first)
		}
	}

	def playARound() {
		if(playedRounds == 0) {
			Collections.shuffle(players)
		} 
		if(playedRounds < TOTAL_ROUNDS) {
			players.each { it.play(dices) }
			playedRounds++
		}
	}
	
	def isCompleted() {
		playedRounds == TOTAL_ROUNDS
	}
}
