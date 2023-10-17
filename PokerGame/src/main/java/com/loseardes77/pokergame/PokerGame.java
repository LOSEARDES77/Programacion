package com.loseardes77.pokergame;

import java.util.ArrayList;
import java.util.List;

public class PokerGame {
    private Deck deck;
    private List<Player> players;

    public PokerGame(int numPlayers) {
        deck = new Deck();
        players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Player " + i));
        }
    }
}


