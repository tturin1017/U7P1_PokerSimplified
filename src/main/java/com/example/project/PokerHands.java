package com.example.project;
import java.util.ArrayList;

public class PokerHands{
    private static String[] ranking = {
        "Royal Flush",
        "Straight Flush",
        "Four of a kind",
        "Full House",
        "Flush",
        "Straight",
        "Three of a kind",
        "Two Pair",
        "Pair",
        "High Card"
    };


    public static String[] getRanking(){
        return ranking;
    }
}