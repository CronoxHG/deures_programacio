package com.exercicis;

import java.util.Scanner;

public class Exercici0009 {

    public static void dibuixarRectangle(int ample, int alt) {
        if (ample < 2 || alt < 2) {
            System.out.println("L'ample i l'alt han de ser com a mínim 2.");
            return;
        }

        // Dibuixar la primera i última línia
        String liniaExtrem = "*".repeat(ample);
        System.out.println(liniaExtrem);

        // Dibuixar les línies intermèdies
        String liniaIntermitja = "*" + "o".repeat(Math.max(0, ample - 2)) + "*";
        for (int i = 1; i < alt - 1; i++) {
            System.out.println(liniaIntermitja);
        }

        if (alt > 1) {
            System.out.println(liniaExtrem);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Introdueix l'ample del rectangle: ");
            int ample = scanner.nextInt();

            System.out.print("Introdueix l'alt del rectangle: ");
            int alt = scanner.nextInt();

            System.out.println("Resultat:");
            dibuixarRectangle(ample, alt);
        }
    }
}
