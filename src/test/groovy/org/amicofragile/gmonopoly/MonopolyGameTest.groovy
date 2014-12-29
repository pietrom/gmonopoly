package org.amicofragile.gmonopoly

import static org.junit.Assert.*;

import org.junit.Test;

class MonopolyGameTest {
	@org.junit.Test
	void initialLocationIsTheFirstForEveryUser() {
		def board = new Board()
		(0..10).each {
			board.addLocation(new BoardLocation("BL${it}"))
		}
		def players = []
		(1..3).each {
			players << new Player("PL${it}")
		}
		def game = new MonopolyGame(board, players)
		(0..2).each {
			assertEquals(board.getLocationAt(0), players[it].location)
		}
	}
	
	@org.junit.Test(expected = IllegalArgumentException.class)
	void cantPlayWithLesserThanTwoPlayers() {
		def board = new Board()
		def players = []
		players.add(new Player("Eddie"))
		def game = new MonopolyGame(board, players)
	}
	
	@org.junit.Test(expected = IllegalArgumentException.class)
	void cantPlayWithMoreThanEightPlayers() {
		def board = new Board()
		def players = []
		9.times {
			players.add(new Player("PL${it}"))
		}
		def game = new MonopolyGame(board, players)
	}
	
	@org.junit.Test
	void givenTwoPlayersInHundredGamesThanBothPossibleOrdersOccurAndEachPlayerPlayedTwentyRounds() {
		def accumulator = ""
		def horse = new Player("Horse")
		horse.metaClass.move = { int dicesValue ->
			accumulator += "H"
		}
		def car = new Player("Car")
		car.metaClass.move = { int dicesValue ->
			accumulator += "C"
		}
		def players = []
		players.add(horse)
		players.add(car)
		
		def orderHCoccurred = false
		def orderCHoccurred = false
		100.times {
			def game = new MonopolyGame(new Board(), players)
			accumulator = ""
			playTheGame(game)
			if(accumulator.equals("HC" * 20)) {
				orderHCoccurred = true
			} else if (accumulator.equals("CH" * 20)) {
				orderCHoccurred = true
			} else {
			println accumulator
				fail("Order cant'change during the game")
			}
		}
		assertTrue(orderHCoccurred)
		assertTrue(orderCHoccurred)
	}

	private playTheGame(MonopolyGame game) {
		while(!game.isCompleted()) {
			game.playARound()
		}
	}
	
	@org.junit.Test
	void finalPlayerLocationsAreCasual() {
		def board = new Board()
		(1..40).each {
			board.addLocation(new BoardLocation("LOC-${it}"))
		}
		def players = []
		(1..8).each {
			players << new Player("PL-${it}")
		}
		def game = new MonopolyGame(board, players)
		playTheGame(game)
		def finalLocations = []
		players.each {
			if(!finalLocations.contains(it.location.name)) {
				finalLocations << it.location.name
			}
		}
		assertTrue(finalLocations.size() >= 5)
	}
}
