package com.example.project;
import java.util.ArrayList;


public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Card> allCards; //the current community cards + hand
    private String[] suits  = {"Hearts","Diamonds","Clubs", "Spades"};
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Player(){
        hand = new ArrayList<>();
        deck = new Deck().getCards();
    }

    public getHand(){return hand;}
    public getAllCards(){return allCards;}

    public String playHand(Card[] communityCards){
        allCards = communityCards;
        allCards.add(hand.get(0));
        allCards.add(hand.get(1));
        allCards = sortAllCards();
        
        return "";
    }

    public ArrayList<Card> sortAllCards(){ 
        //use selection sort
        for(int i=0; i<allCards.size(); i++){
            int min_i = i;
            for(int j=i+1;j<allCards.size();j++){
                if(allCards.get(min_i).getRankValue()>allCards.get(j).getRankValue()){
                    min_i = j;
                }
                //swap
                card temp = allCards.get(i);
                allCards.set(i,cards.get(min_i));
                allCards.set(min_i,temp);
            }
        }
        return cards;
    }

    public ArrayList<Integer> findRankingFrequency(){
        ArrayList<Integer> freqList = new ArrayList<>();
        for(String s: ranks){ //loop through ranks {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
            int count = 0;
            for(Card card: allCards){ //loop through community + hand cards
                if(card.getRank().equals(s)){
                    count++;
                }
            }
            freqlist.add(count);
        }
        return freqList; 
    }

    public ArrayList<Integer> findSuitFrequency(){
        ArrayList<Integer> freqList = new ArrayList<>();
        for(String s: suits){ //loop through {"Hearts","Diamonds","Clubs", "Spades"};
            int count = 0;
            for(Card c: allCards){
                if(c.getSuit().equals(s)){
                    count++;
                }
            }
            freqList.add(count);
        }
        return freqList; 
    }

    public boolean isRoyalFlush(){
        //has to be a flush, check
        if(isFlush(allCards)){ //hand + community cards are all of the same suit
            //now check for straight
            if(isStraight(allCards)){
                //now check if lowest card is 10
                //loop through community cards and find min
                int min = Integer.MAX_VALUE;
                for(Card c: allCards){
                    if(c.getRankValue()<min){
                        min = c.getRankValue();
                    }
                }
                if(min==10){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean isStraightFlush(){
        if(isStraight(allCards) && isFlush(allCards)){
            return true;
        }

        return false;
    }

    public boolean isFourOfAKind(){
        //cheak for a frequency of 4
        ArrayList<Integer>freqList = findRankingFrequency();
        for(int i=0;i<freqlist.size();i++){
            if(freqList.get(i)==4){
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse(){ //3 pair and a two pair .. can't reuse 3 of a kind and pair because what if 3 pair is the community cards a
        ArrayList<Integer>freqList = findRankingFrequency();
        int isTrue = 0;
        for(int num : freqList){
            if(num==3){
                isTrue++;
            }else if (num==2){
                isTrue++;
            }
        }
        if(isTrue == 2){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFlush(){
        ArrayList<Integer> suitFreqList = findSuitFrequency(allCards);
        for(int i=0;i<suitFreqList.size(); i++){
            if(suitFreqList.get(i)==5){
                return true;
            }
        }
        return false;
    }

    public boolean isStraight(){
        for(int i =0; i<allCards.size()-1;i++){
            if(allCards.get(i+1).getRankValue()-allCards.get(i).getRankValue()!=1){ //the current rank value should be 1 less than i+1 value
                return false;
            }
        }
        return true;
    }

    public boolean isThreeOfAKind(){
        ArrayList<Integer>freqList = findRankingFrequency();
        for(int i=0 ; i<freqList.size(); i++){
            if(freqList.get(i)==3){
                if(hand.get(0).getRank().equals(rank[i]) || hand.get(1).getRank().equals(rank[i])){
                    //compare hand rank with freqList rank. If at least one of them is the same, its a 3 pair
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isTwoPair(){
        ArrayList<Integer>freqList = findRankingFrequency();
        int count = 0;
        for(int num: freqList){
            if(num == 2){
                count++;
            }
        }

        if(count == 2){
            return true;
        }else{
            return false;
        }
    }

   

    public boolean isPair(){
        ArrayList<Integer> rankingFreqList = findRankingFrequency(allCards);
        for(int i=0; i< rankingFreqList.size();i++){
            if(rankingFreqList.get(i)==2 && //if there is a pair and that pair is a part of the players hand, not just in the community deck
            (hand.get(0).getRank().equals(deck.getCards().get(i).getRank()|| 
            hand.get(1).getRank().equals(deck.getCards().get(i).getRank()
            )))){
               return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return hand.toString();
    }




}
