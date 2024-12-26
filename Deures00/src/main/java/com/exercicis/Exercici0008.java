package com.exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici0008 {

    public static ArrayList<Integer> generaImparells(int numero) {
        ArrayList<Integer> imparells = new ArrayList<>();
        
        int i = 3;
        while (i <= numero) {
            imparells.add(i);
            i += 2;
        }
        
        return imparells;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Introdueix un número: ");
            int numero = scanner.nextInt();

            if (numero > 2) {
                ArrayList<Integer> imparells = generaImparells(numero);
                System.out.println("Nombres imparells entre 2 i " + numero + ": " + imparells);
            } else {
                System.out.println("No hi ha nombres imparells entre 2 i " + numero);
            }
        }
    }
}
