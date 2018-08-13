/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokertest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jeyss
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //reading s file for obtain hands
        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:\\pokerdata.txt"));
            String sCadena;

            int PoneWins = 0;
            int PtwoWins = 0;
            int NeitherWins = 0;
            Double ProbPlay1toWin = 0.00;
            Double ProbPlay2toWin = 0.00;
            
            while ((sCadena = bf.readLine()) != null) {

                Deck deck = new Deck();
                deck.allCards(sCadena);
                Hand hand = new Hand(deck);                     
                Hand hand2 = new Hand(deck);
                hand.display();
                ProbPlay1toWin+=hand.display();
                hand.displayAll();
                hand2.display();
                ProbPlay2toWin+=hand2.display();
                hand2.displayAll();
                System.out.println(hand.compareTo(hand2));
                switch (hand.compareTo(hand2)) {
                    case 1:
                        System.out.println("Player 1 wins");
                        PoneWins++;
                        
                        break;
                    case -1:
                        System.out.println("Player 2 wins");
                        PtwoWins++;
                        break;
                    default:
                        System.out.println("neither Player win");
                        NeitherWins++;
                        break;
                }

                System.out.println("---------------------");

            }

            System.out.println("SUMARY");
            System.out.println("Player 1 wins: " + PoneWins + " times");
            System.out.println("Player 2 wins: " + PtwoWins + " times");
            System.out.println("neither Player win: " + NeitherWins + " times");
            System.out.println("Prob Player 1 to win: " + ProbPlay1toWin + " times");
            System.out.println("Prob Player 2 to win: " + ProbPlay2toWin + " times");

            bf.close();
            CreateOutputFile(PoneWins, PtwoWins, NeitherWins, ProbPlay1toWin, ProbPlay2toWin);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void CreateOutputFile(Integer ParOneWins, Integer ParTwoWins, Integer NeitherWins, Double ProbPlay1toWin, Double ProbPlay2toWin  ) throws IOException {
        //writng the answers in the output txt file named Output.txt
        String ruta = "Output.txt";
        File ofile = new File(ruta);
        BufferedWriter bw;
        if (ofile.exists()) {
            bw = new BufferedWriter(new FileWriter(ofile));
            //bw.write("the file has already been created successfully");
        } else {
            bw = new BufferedWriter(new FileWriter(ofile));
            //bw.write("the file has been created successfully");
        }

        bw.write("ANSWERS");
        bw.newLine();
        bw.write("----------------");
        bw.newLine();
        bw.write("1: " + ParOneWins);
        bw.newLine();
        bw.write("2: " + ParTwoWins);
        bw.newLine();
        bw.write("3: " + NeitherWins);
        bw.newLine();
        bw.write("---------PLAYER 1 --------- | ------ PLAYER 2 --------------");
        bw.newLine();
        bw.write("         "+ProbPlay1toWin+"%");
        bw.write("         "+ProbPlay2toWin+"%");
        bw.close();

    }
   
        
    }

