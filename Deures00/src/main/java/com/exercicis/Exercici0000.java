package com.exercicis;


import java.util.Scanner;

public class Exercici0000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escriu el primer número: ");
        int num1 = sc.nextInt();

        System.out.print("Escriu el segon número: ");
        int num2 = sc.nextInt();

        int resultat = num1 - num2;

        System.out.println("El resultat de calcular " + num1 + " - " + num2 + " és " + resultat);

        sc.close();
    }
}
