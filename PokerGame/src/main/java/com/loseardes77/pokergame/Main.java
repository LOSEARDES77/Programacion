package com.loseardes77.pokergame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));

        // Deal five cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                Card card = deck.dealCard();
                player.getHand().addCard(card);
            }
        }

        // Evaluate and display hands
        for (Player player : players) {
            System.out.println(player.getName() + "'s Hand: " + player.getHand());
            System.out.println("Hand Value: " + player.getHand().getHandValue());
        }

        // Determine the winner based on hand value
        Player winner = determineWinner(players);
        System.out.println("Winner: " + winner.getName());
    }

    public static Player determineWinner(List<Player> players) {
        Player winner = players.get(0); // Default winner
        for (Player player : players) {
            if (player.getHand().getHandValue() > winner.getHand().getHandValue()) {
                winner = player;
            }
        }
        return winner;
    }
}