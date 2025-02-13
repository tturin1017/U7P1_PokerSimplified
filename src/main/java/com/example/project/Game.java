package com.example.project;
import java.util.ArrayList;


public class Game{
    public static void play(){
            //initialize a deck
            Deck deck = new Deck();
            //initialize players 
            Player p1 = new Player();
            Player p2 = new Player ();
    
             // Deal two cards to each player
             for (int i = 0; i < 2; i++) {
                p1.addCard(deck.drawCard());
                p2.addCard(deck.drawCard());
            }
    
            // Deal three community cards
            ArrayList<Card> communityCards = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                communityCards.add(deck.drawCard());
            }
    
            // Print the community cards
            System.out.println("Community Cards: " + communityCards);
    
            // Print each player's hand
            System.out.println("Player 1's Hand: " + p1.getHand().toString());
            System.out.println("Player 2's Hand: " + p2.getHand().toString());
    
            // Evaluate each player's hand
            String p1Result = p1.playHand(communityCards);
            String p2Result = p2.playHand(communityCards);
    
            // Print the results
            System.out.println("Player 1's Hand Ranking: " + p1Result);
            System.out.println("Player 2's Hand Ranking: " + p2Result);
    
            // Determine the winner
            // if (p1Result.compareTo(p2Result) > 0) {
            //     System.out.println("Player 1 wins!");
            // } else if (p1Result.compareTo(p2Result) < 0) {
            //     System.out.println("Player 2 wins!");
            // } else {
            //     System.out.println("It's a tie!");
            // }
    
            
        }
        
        public static void main(String[] args) {
            play();
    }

}