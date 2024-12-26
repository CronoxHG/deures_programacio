
package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale usLocale = Locale.US;

        System.out.print("Escriu el pes (kg): ");
        double pesKg = sc.nextDouble();

        System.out.print("Escriu l'alçada (cm): ");
        double alçadaCm = sc.nextDouble();

        double alçadaMetres = alçadaCm / 100;
        double imcResultat = pesKg / (alçadaMetres * alçadaMetres);

        System.out.printf(usLocale, "imc = %.2f%n", imcResultat);

        sc.close();
    }
}
