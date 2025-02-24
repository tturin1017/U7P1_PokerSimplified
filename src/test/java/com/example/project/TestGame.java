package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestGame {
     @Test
    public void testDetermineWinnerWithDifferentHandRanks() {
        Player player1 = new Player();
        Player player2 = new Player();

        // Set up player hands
        player1.addCard(new Card("A", "Spades"));
        player1.addCard(new Card("K", "Spades"));
        player2.addCard(new Card("10", "Hearts"));
        player2.addCard(new Card("9", "Hearts"));

        // Simulate community cards
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("Q", "Spades"));
        communityCards.add(new Card("J", "Spades"));
        communityCards.add(new Card("10", "Spades"));

        // Evaluate hands
        String result1 = player1.playHand(communityCards);
        String result2 = player2.playHand(communityCards);

        assertEquals("Royal Flush", result1);
        assertEquals("Straight", result2);

        // Test winner determination
        String winner = Game.determineWinner(player1, player2, result1, result2, communityCards);
        assertEquals("Player 1 wins!", winner);
    }

    @Test
    public void testDetermineWinnerWithSameHand() {
        Player player1 = new Player();
        Player player2 = new Player();

        // Set up player hands
        player1.addCard(new Card("10", "Hearts"));
        player1.addCard(new Card("J", "Hearts"));
        player2.addCard(new Card("Q", "Clubs"));
        player2.addCard(new Card("K", "Spades"));

        // Simulate community cards
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("A", "Diamonds"));
        communityCards.add(new Card("K", "Diamonds"));
        communityCards.add(new Card("J", "Clubs"));

        // Evaluate hands
        String result1 = player1.playHand(communityCards);
        String result2 = player2.playHand(communityCards);

        assertEquals("Straight", result1);
        assertEquals("Straight", result2);

        // Test winner determination
        String winner = Game.determineWinner(player1, player2, result1, result2, communityCards);
        assertEquals("Player 2 wins!", winner);
    }
}
