/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lottó;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krisztián
 */
public class Lottó {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem az 52. hét lottószámait");
        
        //bekérem az adatokat
        int utolsoHet[] = new int[5];
        for (int i = 0; i < 5; i++) {
            utolsoHet[i] = sc.nextInt();
        }
        
        //sorrendbe állítom a bekért adatokat
        int csere;
        for (int i = 0; i < utolsoHet.length - 1; i++) {
            for (int j = i + 1; j < utolsoHet.length; j++) {
                if (utolsoHet[i] > utolsoHet[j]) {
                    csere = utolsoHet[i];
                    utolsoHet[i] = utolsoHet[j];
                    utolsoHet[j] = csere;
                }
            }
        }
        
        //kiiratom a bekért adatokat
        for (int i = 0; i < utolsoHet.length; i++) {
            System.out.print(utolsoHet[i] + " ");
        }
        System.out.println();
        System.out.println("************************");
        
        //3. feladat, bekérem a hetet
        System.out.println("Adj meg egy számot 1 és 51 között");
        int het = sc.nextInt();
        
        //beolvasom a filet 4. feladathoz
        int nyeroSzamok[][] = new int[51][5];
        String heti;
        String[] szamok;
        try {
        FileReader  fr = new FileReader("lottosz.dat");
        BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < 51; i++) {
                heti = br.readLine();
                szamok = heti.split(" ");
                for (int j = 0; j < szamok.length; j++) {
                  nyeroSzamok[i][j] = Integer.parseInt(szamok[j]);
                }  
            }
               } catch (FileNotFoundException ex) {
            Logger.getLogger(Lottó.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lottó.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //4. feladat, kiírom a megadott hét számait
        System.out.println("A/az " + het + ". hét lottószámai:");
        for (int i = 0; i < 5; i++) {
            System.out.print(nyeroSzamok[het-1][i]+" ");
        }
        System.out.println();
        System.out.println("**************************");
        
        //5. feladat, egyszer sem húzták ki?
        int[] szamokDb = new int[90];
        for (int i = 0; i < nyeroSzamok.length ; i++) {
            for (int j = 0; j < nyeroSzamok[i].length; j++) {
                szamokDb[nyeroSzamok[i][j]-1]++;
            }
        }
        boolean van = false;
        for( int sz : szamokDb ){
            if( sz == 0 ){
                van = true;
                break;
            }
        }
        
        if( van == true )
            System.out.println("Van");
        else{
            System.out.println("Nincs");
        }
        
        //6. feladat, a kihúzott számok közül mennyi volt a páratlan?
        
    } 

}
