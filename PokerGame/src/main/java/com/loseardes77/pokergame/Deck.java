package com.loseardes77.pokergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        // Add all 52 cards to the deck
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }

    // Methods to deal and shuffle the deck
}

