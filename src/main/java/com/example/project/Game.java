package com.example.project;
import java.util.ArrayList;


public class Game{
    public static String determineWinner(Player p1, Player p2,String p1Hand, String p2Hand,ArrayList<Card> communityCards){
        int p1Result = Utility.getHandRanking(p1Hand);
        int p2Result = Utility.getHandRanking(p2Hand);

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
                return message;
            }else if(p1Result == 7 && p2Result == 7){ //FLUSH DRAW. Determine who has the higher card in hand
                return message;
            }else if (p1Result == 6 && p2Result == 6){//STRAIGHT DRAW 
                return message;
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
                }else if(Utility.getRankValue(p1_rank)<Utility.getRankValue(p2_rank)){
                    return "Player 2 wins!";
                }else{ //3 pair is the community cards so find the highest card 
                    return message; //max  between cards is calculated
                }
            }else if(p1Result == 4 && p2Result == 4){ //TWO PAIR DRAW
                //scenario 1-> 1 pair is the in the community deck. Check for this
                int p1_i_firstPair  =-1; int p1_i_secondPair = -1; int p2_i_firstPair = -1; int p2_i_secondPair = -1;
                for(int i=0;i<p1_rankFreqList.size();i++){
                    if(p1_rankFreqList.get(i)==2){
                        if(p1_i_firstPair==-1){
                            p1_i_firstPair=i;
                        }else if(p1_i_firstPair!=-1 && p1_i_secondPair == -1){
                            p1_i_secondPair = i;
                        }
                    }
                    if(p2_rankFreqList.get(i)==2){
                        if(p2_i_firstPair==-1){
                            p2_i_firstPair=i;
                        }else if(p2_i_firstPair!=-1 && p2_i_secondPair == -1){
                            p2_i_secondPair = i;
                        }
                    }
                }

                int p1_firstPair_val = Utility.getRankValue(Utility.getRanks()[p1_i_firstPair]);
                int p1_secondPair_val = Utility.getRankValue(Utility.getRanks()[p1_i_firstPair]);
                int p1_firstPair_val = Utility.getRankValue(Utility.getRanks()[p1_i_firstPair]);
                int p1_firstPair_val = Utility.getRankValue(Utility.getRanks()[p1_i_firstPair]);

                if (p1_i_firstPair == p2_i_firstPair){
                    //check other two pairs to determine who is higher 
                    
                }
                
                //|| p1_i_firstPair == p2_i_secondPair || p1_i_secondPair == p2_i_firstPair || p1_i_secondPair == p2_i_secondPair){
                    //community card is a pair
                    //check 
                }
                //now compare rank
                int x = Utility.getRankValue(Utility.getRanks()[i1]); 
                int y  = Utility.getRankValue(Utility.getRanks()[i2]); 
                if(x>y){
                    return "Player 1 wins!"; //two pair draw
                }else if(x>y){
                    return "Player 2 wins!";
                }else{
                    return "Tie!";
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
            //play();
            Player player = new Player();
            player.addCard(new Card("7", "♠"));
            player.addCard(new Card("8", "♣"));
            
            // Community Cards
            ArrayList<Card> communityCards = new ArrayList<>();
            communityCards.add(new Card("7", "♦"));
            communityCards.add(new Card("8", "♥"));
            communityCards.add(new Card("A", "♠"));
            
            player.playHand(communityCards);
            String handResult = player.playHand(communityCards);
            System.out.println(handResult);
    }

}