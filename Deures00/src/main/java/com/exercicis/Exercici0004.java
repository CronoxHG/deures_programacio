package com.exercicis;



import java.util.Scanner;

public class Exercici0004 {

    public static int contaMajuscules(String text) {
        int total = 0;
        for (char lletra : text.toCharArray()) {
            if (Character.isUpperCase(lletra)) {
                total++;
            }
        }
        return total;
    }

    public static int contaMinuscules(String text) {
        int total = 0;
        for (char lletra : text.toCharArray()) {
            if (Character.isLowerCase(lletra)) {
                total++;
            }
        }
        return total;
    }

    public static String validaContrasenya(String text) {
        if (text.length() >= 8 &&
            contaMajuscules(text) >= 2 &&
            contaMinuscules(text) >= 2) {
            return "La contrasenya és vàlida";
        } else {
            return "La contrasenya NO és vàlida";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Escriu una contrasenya: ");
        String input = sc.nextLine();

        String validacio = validaContrasenya(input);

        System.out.printf("La contrasenya '%s': %s\n", input, validacio);

        sc.close();
    }
}
