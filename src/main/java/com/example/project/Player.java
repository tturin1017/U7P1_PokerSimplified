package com.example.project;
import java.util.ArrayList;


public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Deck> deck; //this deck is used for rank and suit sorting

    public Player(){
        hand = new ArrayList<>();
        deck = new Deck().getCards();
    }

    public getHand(){return hand;}

    public String playHand(Card[] communityCards){
        
        
        return "";
    }

    public ArrayList<Card> findRankingFrequency(ArrayList<Card> communityCards){
        ArrayList<Card> freqList = new ArrayList<>();
        for(Card deckCard: deck){
            int count = 0;
            for(Card communityCard: communityCards){ //look through community cards 
                if(deckCard.getRank().equals(communityCard.getRank())){
                    count++;
                }
            }
            for(Card handCard: hand){//look through hand cards 
                if(deckCard.getRank().equals(deckCard.getRank())){
                    count++;
                }
            }
            freqList.add(count);
        }
        return freqList; 
    }

    public ArrayList<Card> findSuitFrequency(ArrayList<Card> communityCards){
        ArrayList<Card> freqList = new ArrayList<>();
        for(Card deckCard: deck){
            int count = 0;
            for(Card communityCard: communityCards){ //look through community cards 
                if(deckCard.getSuit().equals(communityCard.getSuit())){
                    count++;
                }
            }
            for(Card handCard: hand){//look through hand cards 
                if(deckCard.getSuit().equals(deckCard.getSuit())){
                    count++;
                }
            }
            freqList.add(count);
        }
        return freqList; 
    }

    public ArrayList<Card> sort
    
    @Override
    public String toString(){
        return hand.toString();
    }




}
