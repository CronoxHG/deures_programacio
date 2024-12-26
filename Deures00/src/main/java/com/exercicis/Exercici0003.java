package com.exercicis;



import java.util.Locale;
import java.util.Scanner;

public class Exercici0003 {
    
    public static double calcularPreuFinal(double base, double ivaPercent, double descomptePercent) {
        double ambIva = base + (base * ivaPercent / 100);
        return ambIva - (ambIva * descomptePercent / 100);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale usLocale = Locale.US;

        System.out.print("Introdueix el preu base: ");
        double base = sc.nextDouble();

        System.out.print("Introdueix l'IVA (%): ");
        double iva = sc.nextDouble();

        System.out.print("Introdueix el descompte (%): ");
        double descompte = sc.nextDouble();

        double preuFinal = calcularPreuFinal(base, iva, descompte);

        System.out.printf(usLocale, "El preu final és: %.2f\n", preuFinal);

        sc.close();
    }
}
