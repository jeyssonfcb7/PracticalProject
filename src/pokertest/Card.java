/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertest;

public class Card{
    private short rank, suit;

    private static String[] suits = { "hearts", "spades", "diamonds", "clubs" };
    private static String[] ranks  = { "Ace", "2", "3", "4", "5", "6", "7", 
                                       "8", "9", "T", "Jack", "Queen", "King" };

    public static String rankAsString( int __rank ) {
        return ranks[__rank];
    }

    Card(short suit, short rank)
    {
        this.rank=rank;
        this.suit=suit;
    }

    public @Override String toString()
    {
          return ranks[rank] + " of " + suits[suit];
    }

    public short getRank() {
         return rank;
    }

    public short getSuit() {
        return suit;
    }
}