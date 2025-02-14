package com.example.project;
import java.util.ArrayList;


public class Game{
    public static String deteremineWinner(Player p1, Player p2,String p1Hand, String p2Hand,ArrayList<Card> communityCards){
        int p1Result = getHandRanking(p1Hand);
        int p2Result = getHandRanking(p2Hand);

        if(p1Result>p2Result){
            return "Player 1 wins!"; //player two wins!
        }else if(p1Result<p2Result){
            return "Player 2 wins!";
        }else{//we have a draw, we must determine who wins 
            //impossible for two players to both get royal flush 
            //impossible for two players to both get a straight flush 
            //impossible for two players to both have a 4 of a kind
            int p1_c1 = p1.getHand().get(0).getRankValue();
            int p1_c2 = p1.getHand().get(1).getRankValue();
            int p2_c1 = p2.getHand().get(0).getRankValue();
            int p2_c2 = p2.getHand().get(1).getRankValue();

                    
            //possible for two players to get full house 3p and 2p
            //community cards must be 3p so deteremine who has the higher pair
            if(p1Result== 8 && p2Result == 8){ //FULL HOUSE DRAW
                if(p1_c1>p2_c1){
                    return "Player 1 wins!";
                }else if(p1_c1<p2_c1){
                    return "Player 2 wins!";
                }else{ //tie
                    return "Tie! Both players have the same pair rank";
                }
            }else if(p1Result == 7 && p2Result == 7){ //FLUSH DRAW. Determine who has the higher card in hand
                //find max card for each player 
                int p1_max=-1; int p2_max=-1;
                if(p1_c1>p1_c2){
                    p1_max = p1_c1;
                }else{
                    p1_max = p1_c2;
                }

                if(p2_c1>p2_c2){
                    p2_max = p2_c1;
                }else{
                    p2_max = p2_c2;
                }

                //compare players max cards 
                if(p1_max>p2_max){
                    return "Player 1 wins!";
                }else if(p1_max<p2_max){
                    return "Player 2 wins!";
                } //there is no draw. If both players have a flush, one person will win
            }
            


            
                
            }


        
        return "error";
        
    }

    public static int getHandRanking(String result){
        switch(result){
            case "Royal Flush": return 11;
            case "Straight Flush": return 10;
            case "Four of a Kind": return 9;
            case "Full House": return 8;
            case "Flush": return 7;
            case "Straight": return 6;
            case "Three of a Kind": return 5;
            case "Two Pair": return 4;
            case "A Pair": return 3;
            case "High Card": return 2;
            case "Nothing": return 1;
        }
        return -1;
    }

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