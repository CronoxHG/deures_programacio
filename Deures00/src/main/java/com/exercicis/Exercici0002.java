package com.exercicis;



import java.util.Locale;
import java.util.Scanner;

public class Exercici0002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale usLocale = Locale.US;

        System.out.print("Escriu el valor en Euros: ");
        String entradaEuros = sc.next();
        double euros = Double.parseDouble(entradaEuros.replace(',', '.'));

        System.out.print("Escriu la taxa de conversió (ex: 1.25): ");
        String entradaTaxa = sc.next();
        double taxaConversio = Double.parseDouble(entradaTaxa.replace(',', '.'));

        double dollars = euros * taxaConversio;

        System.out.printf(usLocale, "El valor de %.2f€ són %.2f$%n", euros, dollars);

        sc.close();
    }
}
