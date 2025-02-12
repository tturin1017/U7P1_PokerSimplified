package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestMain{

    @Test
    public void testInsertAfterI(){
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"this", "is", "not", "a", "trivial", "task", "right?");
        ArrayList<String> expected = new ArrayList<>();
        Collections.addAll(expected,"this", "bob","is","bob","not", "a", "trivial", "bob","task", "right?", "bob" );
        assertEquals(expected, Main.insertAfterI(list, "bob"));
    }
    @Test
    public void testRemove3(){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("the", "not", "skim", "pat", "a", "rat", "cat", "sit", "truck", "par", "tar"));
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("skim","a","truck"));
        assertEquals(expected, Main.removeThree(list));
    }

    @Test
    public void testReverseArray(){
        int[] intList = {1, 2, 3, 4, 5, 6, 7};
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(7,6,5,4,3,2,1));
        assertEquals(expected, Main.reverseArray(intList));
    }
    @Test
    public void testDuplicateUpperEnd(){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("hello", "my", "best", "friend", "whats", "up"));
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("hello", "my", "best", "friend", "whats", "up", "HELLO","MY", "BEST", "FRIEND", "WHATS", "UP"));
        assertEquals(expected, Main.duplicateUpperEnd(list));
    }

    @Test
    public void testParseSentence(){
        String sentence = "This is a sentence!";
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("This", "is", "a", "sentence!"));
        assertEquals(expected,Main.parseSentence(sentence));

        String sentence2 = "This is another random sentence! It is slightly longer.";
        ArrayList<String> expected2 = new ArrayList<String>(Arrays.asList("This","is","another", "random", "sentence!", "It", "is", "slightly","longer."));
        assertEquals(expected2, Main.parseSentence(sentence2));
    }

    @Test
    public void testMoveBWords(){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"));
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"));
        assertEquals(expected, Main.moveBWords(list));
    }

    @Test
    public void testRemoveDuplicates(){
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2));
        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 4, 6, 8, 7));
        assertEquals(expected,Main.removeDuplicates(list));
    }

    
    @Test
    public void testSameFirstLast(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        assertEquals(false,Main.sameFirstLast(list));
        list.add(1);list.add(2);list.add(3);
        assertEquals(false,Main.sameFirstLast(list));
        list.add(1);
        assertEquals(true,Main.sameFirstLast(list));
        list.clear(); list.add(1);list.add(2);list.add(1);
        assertEquals(true,Main.sameFirstLast(list));
    }

    @Test
    public void testSwapEnds(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1,2,3,4);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        Collections.addAll(expected,4,2,3,1);
        assertEquals(expected,Main.swapEnds(list));
        list.clear();
        Collections.addAll(list,8,6,7,9,5);
        expected.clear();
        Collections.addAll(expected,5,6,7,9,8);
        assertEquals(expected,Main.swapEnds(list));
        list.clear();expected.clear();
        assertEquals(expected,Main.swapEnds(list));
    }


    @Test
    public void testZeroFront(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,0,0,1);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,0,0,1,1);
        assertEquals(expected,Main.zeroFront(list));
        list.clear();expected.clear();

        Collections.addAll(list,0,1,1,0,1);
        Collections.addAll(expected,0,0,1,1,1);
        assertEquals(expected,Main.zeroFront(list));
        list.clear();expected.clear();

        Collections.addAll(list,1,0);
        Collections.addAll(expected,0,1);

        assertEquals(expected,Main.zeroFront(list));
 
    }

    @Test
    public void testNotAlone(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,2,3);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,1,3,3);
        assertEquals(expected,Main.notAlone(list,2));

        list.clear();expected.clear();
        Collections.addAll(list, 1,2,3,2,5,2);
        Collections.addAll(expected,1,3,3,5,5,5);
        assertEquals(expected,Main.notAlone(list,2));
     
        list.clear();expected.clear();
        Collections.addAll(list, 3,4);
        Collections.addAll(expected,4,4);
        assertEquals(expected,Main.notAlone(list,3));

        list.clear();expected.clear();
        Collections.addAll(list, 4,3,4,4);
        Collections.addAll(expected,4,3,4,4);
        assertEquals(expected,Main.notAlone(list,4));
    }


    @Test
    public void TestShiftLeft(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,6,2,5,3);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,2,5,3,6);
        assertEquals(expected,Main.shiftLeft(list));
        list.clear();expected.clear();

        Collections.addAll(list,1,2);
        Collections.addAll(expected,2,1);
        assertEquals(expected,Main.shiftLeft(list));
        list.clear();expected.clear();

        Collections.addAll(list,1);
        Collections.addAll(expected,1);
        assertEquals(expected,Main.shiftLeft(list));
    }


    @Test
    public void testFix34(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list,1,3,1,4);
        ArrayList<Integer> expected = new ArrayList<>();
        Collections.addAll(expected,1,3,4,1);
        assertEquals(expected,Main.fix34(list));
        list.clear();expected.clear();

        Collections.addAll(list,1, 3, 1, 4, 4, 3, 1);
        Collections.addAll(expected,1, 3, 4, 1, 1, 3, 4);
        assertEquals(expected,Main.fix34(list));
        list.clear();expected.clear();

        Collections.addAll(list,3,2,2,4);
        Collections.addAll(expected,3,4,2,2);
        assertEquals(expected,Main.fix34(list));
    }

    @Test
    public void testMode(){
        int[] intList18 = {1, 2, 3, 2, 4, 5, 5, 6};
        ArrayList<Integer> modes = Main.modes(intList18);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2,5));
        assertEquals(expected,modes);

        int[] intList19 = {1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7};
        ArrayList<Integer> modes2 = Main.modes(intList19);
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(6));
        assertEquals(expected2,modes2);

        int[] intList20 = {1, 2, 1, 2, 4, 1, 2, 4, 1, 1, 3};
        ArrayList<Integer> modes3 = Main.modes(intList20);
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(1));
        assertEquals(expected3,modes3);

        int[] intList21 = {1, 2, 3, 4, 3, 2, 1, 4, 1, 2, 3};
        ArrayList<Integer> modes4 = Main.modes(intList21);
        ArrayList<Integer> expected4 = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(expected4,modes4);

        // all numbers appear 1 time
        int[] intList22 = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> modes5 = Main.modes(intList22);
        ArrayList<Integer> expected5 = new ArrayList<>();
        assertEquals(expected5,modes5);

        // all numbers appear 3 times
        int[] intList23 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 1, 2, 3, 4, 5, 6};
        ArrayList<Integer> modes6 = Main.modes(intList23);
        ArrayList<Integer> expected6 = new ArrayList<>();
        assertEquals(expected6,modes6);

        // this one has an extra 7, so 1, 2, 3, 4, 5, and 6 are all modes!
        int[] intList24 = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6};
        ArrayList<Integer> modes7 = Main.modes(intList24);
        ArrayList<Integer> expected7 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        assertEquals(expected7,modes7);
    }
}