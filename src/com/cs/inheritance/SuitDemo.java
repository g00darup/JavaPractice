package com.cs.inheritance;

public class SuitDemo {
    public static void main(String[] args) {
      for( Suit nextSuit: Suit.values()){
          System.out.println(nextSuit.getColor());
      }
    }
}
