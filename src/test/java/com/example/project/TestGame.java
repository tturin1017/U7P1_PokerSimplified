package com.example.project;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class TestGame {
    @Test
    public void testDetermineWinnerPlayer1Wins() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        player1.addCard(new Card("A", "♠"));
        player1.addCard(new Card("K", "♠"));
        
        player2.addCard(new Card("9", "♠"));
        player2.addCard(new Card("10", "♠"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♠"));
        communityCards.add(new Card("A", "♣"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 1 wins!", winner); // Player 1 should win (high card Ace)
    }

    @Test
    public void testDetermineWinnerPlayer2Wins() {
        Player player1 = new Player();
        Player player2 = new Player();
        //two pair determine high card winner
        
        player1.addCard(new Card("7", "♠"));
        player1.addCard(new Card("8", "♠"));
        
        player2.addCard(new Card("9", "♠"));
        player2.addCard(new Card("10", "♠"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♣"));
        communityCards.add(new Card("A", "♠"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 2 wins!", winner); // Player 2 should win (high card 10)
    }

    @Test
    public void testTieGame() {
        Player player1 = new Player();
        Player player2 = new Player();

        //high card draw
        player1.addCard(new Card("K", "♠"));
        player1.addCard(new Card("Q", "♠"));
        
        player2.addCard(new Card("K", "♠"));
        player2.addCard(new Card("Q", "♠"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♠"));
        communityCards.add(new Card("A", "♣"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Tie!", winner); // It's a tie between both players
    }

    @Test
    public void testDetermineWinnerWithFullHouse() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has a Full House
        player1.addCard(new Card("7", "♠"));
        player1.addCard(new Card("7", "♣"));
        
        // Player 2 has a Full House
        player2.addCard(new Card("8", "♠"));
        player2.addCard(new Card("8", "♣"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♥"));
        communityCards.add(new Card("A", "♠"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 2 wins! Full House Draw", winner); // Player 2 wins with a higher Full House
    }



    // 1. Test for "Player 1 wins!" due to higher hand ranking. full house vs 3 of a kind
    @Test
    public void testDetermineWinner_Player1WinsByHigherHand() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has a Full House (7s full of 8s)
        player1.addCard(new Card("7", "♠"));
        player1.addCard(new Card("7", "♣"));
        
        // Player 2 has Three of a Kind (8s)
        player2.addCard(new Card("8", "♠"));
        player2.addCard(new Card("8", "♣"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♥"));
        communityCards.add(new Card("A", "♠"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 1 wins!", winner); // Player 1 wins with Full House
    }

    // 2. Test for "Player 2 wins!" due to higher hand ranking. Both players have a full house but player 2 has a higher pair
    @Test
    public void testDetermineWinner_Player2WinsByHigherHand() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has a Full House (7s full of 8s)
        player1.addCard(new Card("7", "♠"));
        player1.addCard(new Card("7", "♣"));
        
        // Player 2 has a Full House (8s full of 7s)
        player2.addCard(new Card("8", "♠"));
        player2.addCard(new Card("8", "♣"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♥"));
        communityCards.add(new Card("A", "♠"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 2 wins!", winner); 
    }

    // 3. Test for "Tie!" message when both players have identical rankings and highest cards.
    @Test
    public void testDetermineWinner_TieDueToEqualHands() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has Two Pair (8s and 7s)
        player1.addCard(new Card("8", "♠"));
        player1.addCard(new Card("7", "♠"));
        
        // Player 2 has Two Pair (8s and 7s)
        player2.addCard(new Card("8", "♠"));
        player2.addCard(new Card("7", "♣"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("8", "♦"));
        communityCards.add(new Card("7", "♠"));
        communityCards.add(new Card("7", "♣"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Tie!", winner); 
    }

    // 4. Test for "Player 1 wins!" due to higher rank in Three of a Kind draw.
    @Test
    public void testDetermineWinner_Player1WinsInThreeOfAKindDraw() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has Three of a Kind (Aces)
        player1.addCard(new Card("A", "♠"));
        player1.addCard(new Card("A", "♣"));
        
        // Player 2 has Three of a Kind (Kings)
        player2.addCard(new Card("K", "♠"));
        player2.addCard(new Card("K", "♣"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("A", "♦"));
        communityCards.add(new Card("K", "♥"));
        communityCards.add(new Card("9", "♠"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 1 wins!", winner); 
    }

    // 5. Test for "Player 2 wins!" due to higher rank in Two Pair draw.
    @Test
    public void testDetermineWinner_Player2WinsInTwoPairDraw() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has Two Pair (9s and 7s)
        player1.addCard(new Card("9", "♠"));
        player1.addCard(new Card("7", "♠"));
        
        // Player 2 has Two Pair (10s and 7s)
        player2.addCard(new Card("10", "♠"));
        player2.addCard(new Card("7", "♠"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("9", "♦"));
        communityCards.add(new Card("10", "♠"));
        communityCards.add(new Card("7", "♣"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 2 wins!", winner); 
    }

    // 6. Test for "Player 1 wins!" due to higher card in High Card draw.
    @Test
    public void testDetermineWinner_Player1WinsInHighCardDraw() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has a High Card (Ace)
        player1.addCard(new Card("A", "♠"));
        player1.addCard(new Card("2", "♠"));
        
        // Player 2 has a High Card (King)
        player2.addCard(new Card("K", "♠"));
        player2.addCard(new Card("3", "♠"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♠"));
        communityCards.add(new Card("9", "♣"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 1 wins!", winner); 
    }

    // 7. Test for "Player 2 wins!" when they have the higher high card in a High Card draw.
    @Test
    public void testDetermineWinner_Player2WinsInHighCardDraw() {
        Player player1 = new Player();
        Player player2 = new Player();
        
        // Player 1 has a High Card (Jack)
        player1.addCard(new Card("J", "♠"));
        player1.addCard(new Card("4", "♠"));
        
        // Player 2 has a High Card (Queen)
        player2.addCard(new Card("Q", "♠"));
        player2.addCard(new Card("2", "♠"));
        
        ArrayList<Card> communityCards = new ArrayList<>();
        communityCards.add(new Card("7", "♦"));
        communityCards.add(new Card("8", "♠"));
        communityCards.add(new Card("9", "♣"));
        
        String p1Result = player1.playHand(communityCards);
        String p2Result = player2.playHand(communityCards);
        
        String winner = Game.determineWinner(player1, player2, p1Result, p2Result, communityCards);
        
        assertEquals("Player 2 wins!", winner); // Player 2 wins with Queen high
    }
    
   
}
