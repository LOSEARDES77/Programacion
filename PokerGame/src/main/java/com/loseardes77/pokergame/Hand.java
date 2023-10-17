package com.loseardes77.pokergame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    public int getHandValue() {
        // Simplified hand evaluation (based on pairs, two pairs, and three of a kind)
        Map<String, Integer> rankCount = new HashMap<>();
        for (Card card : cards) {
            String rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        int value = 0;
        for (int count : rankCount.values()) {
            if (count == 2) {
                value += 2; // One pair
            } else if (count == 3) {
                value += 6; // Three of a kind
            }
        }

        return value;
    }
}
