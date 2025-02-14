package com.example.project;
import java.util.ArrayList;


public class Game{
    public static String determineWinner(Player p1, Player p2,String p1Hand, String p2Hand,ArrayList<Card> communityCards){
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
            //impossible for two players to have 2 pair
            int p1_c1 = p1.getHand().get(0).getRankValue();
            int p1_c2 = p1.getHand().get(1).getRankValue();
            int p2_c1 = p2.getHand().get(0).getRankValue();
            int p2_c2 = p2.getHand().get(1).getRankValue();
            int p1_max = findMaxCard(p1_c1,p1_c2);
            int p2_max = findMaxCard(p2_c1, p2_c2);
            ArrayList<Integer> p1_rankFreqList = p1.findRankingFrequency();
            ArrayList<Integer> p2_rankFreqList = p2.findRankingFrequency();
            String p1_rank=""; String p2_rank="";
            String message;
            if(p1_max>p2_max){
                message = "Player 1 wins!";
            }else if(p2_max>p1_max){
                message = "Player 2 wins!";
            }else{
                message="Tie!";
            }

                    
            //possible for two players to get full house 3p and 2p
            //community cards must be 3p so deteremine who has the higher pair
            if(p1Result== 8 && p2Result == 8){ //FULL HOUSE DRAW
                return message + "Full House Draw";
            }else if(p1Result == 7 && p2Result == 7){ //FLUSH DRAW. Determine who has the higher card in hand
                return message+ " Flush Draw";
            }else if (p1Result == 6 && p2Result == 6){//STRAIGHT DRAW 
                return message + " Straight Draw";
            }else if(p1Result == 5 && p2Result == 5){ //THREE OF A KIND DRAW
                //find rank frequency list and deteremine who has the highest 3 pair 
                for(int i =0 ; i<p1_rankFreqList.size();i++){
                    if(p1_rankFreqList.get(i)==3){
                        p1_rank = Utility.getRanks()[i];
                    }else if(p2_rankFreqList.get(i)==3){
                        p2_rank = Utility.getRanks()[i];
                    }
                }
                if(Utility.getRankValue(p1_rank)>Utility.getRankValue(p2_rank)){
                    return "Player 1 wins!";
                }else{
                    return "Player 2 wins!";
                }
            }else if(p1Result == 4 && p2Result == 4){
                //check which 2 pair is in the community deck
                int i1 = -1; int i2 = -1;
                for(int i=0;i<p1_rankFreqList.size();i++){
                    if(p1_rankFreqList.get(i)==2 && p2_rankFreqList.get(i)==2){
                    }else if(p1_rankFreqList.get(i)==2){
                        i1 = i;
                    }else if(p2_rankFreqList.get(i)==2){
                        i2=i;
                    }
                }
                //now compare rank
                int x = Utility.getRankValue(Utility.getRanks()[i1]); 
                int y  = Utility.getRankValue(Utility.getRanks()[i2]); 
                if(x>y){
                    return "Player 1 wins! Two Pair Draw";
                }else if(x>y){
                    return "Player 2 wins! Two Pair Draw";
                }else{
                    return "It's a tie!";
                }
            
            
            }else if(p1Result == 3 && p2Result == 3){ //PAIR DRAW. Find out which pair is the highest
                for(int i =0 ; i<p1_rankFreqList.size();i++){
                    if(p1_rankFreqList.get(i)==2){
                        p1_rank = Utility.getRanks()[i];
                    }else if(p2_rankFreqList.get(i)==2){
                        p2_rank = Utility.getRanks()[i];
                    }
                }
                if(Utility.getRankValue(p1_rank)>Utility.getRankValue(p2_rank)){
                    return "Player 1 wins!";
                }else{
                    return "Player 2 wins!";
                }
            }else if (p1Result == 2 && p2Result == 2){ //If they both have a high card, determine, which one is higher
                return message;
            }else if (p1Result == 1 && p2Result == 1){ //Both don't have anything. find the high card
                return message;
            }
        }
        return "Error";
    }

    public static int findMaxCard(int c1, int c2){
        if(c1>c2){
            return c1;
        }else if (c2>c1){
            return c2;
        }
        return -1;
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
            
            //determine the winner 
            System.out.println(determineWinner(p1, p2, p1Result, p2Result, communityCards));
            
        }
        
        public static void main(String[] args) {
            play();
    }

}