package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public  void initializeDeck(){
        String[] suits  = {"Hearts","Diamonds","Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for(int i =0; i < suits.length; i++){
            for(int j=0;j<ranks.length;j++){
                cards.add(new Card(ranks[j],suit[i]));
            }
        }
    }

    public  void shuffleDeck(){ //make students ceate a shuffle algorithm?
        Collections.shuffle(cards);
    }

    public  Card drawCard(){
        if(!cards.isEmpty()){
            return cards.remove(0);
        }
        return null;
    }

    public  boolean isEmpty(){
        return cards.isEmpty();
    }

   


}