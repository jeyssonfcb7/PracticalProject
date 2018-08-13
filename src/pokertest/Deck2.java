/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertest;

/**
 *
 * @author jeyss
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck2 {

    private ArrayList<Card> cards;
    /**
     * *var cards*
     */
    ArrayList<String> pokerHands = new ArrayList<String>();
    ArrayList<String> player1 = new ArrayList<String>();
    ArrayList<String> player2 = new ArrayList<String>();

    String[] playerData = new String[1000];

    String line;
    String array[];

    /**
     * end varcars
     */
    Deck2() throws IOException {
        cards = new ArrayList<Card>();
        int index_1, index_2;
        Random generator = new Random();
        Card temp;
        /**
         * ****************
         */
        //reading s file for obtain hands
        BufferedReader bf = new BufferedReader(new FileReader("C:\\pokerdata.txt"));
        String sCadena;
        short crank = 0;
        short csuit = 0;
        while ((sCadena = bf.readLine()) != null) {
            //System.out.println(sCadena);
            String[] split = sCadena.split("");
            for (int i = 14; i < 29; i++) {
                System.out.println(split[i]);
                crank = obtainRank(split[i]);
                csuit = obtainSuit(split[i + 1]);
                System.out.println(crank);
                if (crank != -1 || csuit != -1) {
                    cards.add(new Card(crank, csuit));//hasta aqui tiuene generadas todas las cartas
                }
            }
        }

        /**
         * ***********************************
         */
//a suits b ranks
        /*    for (short a=0; a<=3; a++)
        {
            for (short b=0; b<=12; b++)
             {
               cards.add( new Card(a,b) );//hasta aqui tiuene generadas todas las cartas
             }
        }

        int size = cards.size() -1;

        for (short i=0; i<100; i++)
        {
            index_1 = generator.nextInt( size );
            index_2 = generator.nextInt( size );

            temp = (Card) cards.get( index_2 );
            cards.set( index_2 , cards.get( index_1 ) );
            cards.set( index_1, temp );
        }*/
    }

    public Card drawFromDeck() {
        return cards.remove(cards.size() - 1);
    }

    public int getTotalCards() {
        return cards.size();
        //we could use this method when making 
        //a complete poker game to see if we needed a new deck
    }

        public static Short obtainRank(String r) {
        short cardrank = 0;
        List<String> rank = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K");
        //  System.out.println(supplierNames.get(1));

        for (int i = 0; i < rank.size(); i++) {
            if (r.equals(rank.get(i))) {
                cardrank = (short) i;
                return cardrank;
            } else {
                cardrank = -1;
            }
        }
        return cardrank;

    }

    public static Short obtainSuit(String s) {
        short cardsuit = 0;
        List<String> suit = Arrays.asList("H", "S", "D", "C");
        //  System.out.println(supplierNames.get(1));

        for (int i = 0; i < suit.size(); i++) {
            if (s.equals(suit.get(i))) {
                cardsuit = (short) i;
                return cardsuit;
            } else {
                cardsuit = -1;
            }
        }
        return cardsuit;

    }

    public void splitArray(String card) {
        String[] data = card.split(" ");
        player2.add("");
        player2.add("");
        player2.add("");
        player2.add("");
        player2.add("");
        int j = 9;
        for (int i = 0; i < 5; i++) {

            player1.add(i, data[i]);
            obtainRank(data[i]);
        }

        for (int i = 5; i < 10; i++) {

            player2.add(i, data[i]);

        }

        while (j > -1) {

            if ("".equals(player2.get(j))) {
                player2.remove(j);
            }
            j--;
        }

    }
}
