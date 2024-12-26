package com.exercicis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercici0011 {

    public static List<String> escullNomsAleatoris(List<String> noms, int quantitat) {
        if (quantitat > noms.size()) {
            throw new IllegalArgumentException("La quantitat no pot ser més gran que " + noms.size() + ".");
        }

        List<String> seleccionats = new ArrayList<>();
        Random random = new Random();

        List<String> copiaNoms = new ArrayList<>(noms); // Evitar duplicats
        while (seleccionats.size() < quantitat) {
            int index = random.nextInt(copiaNoms.size());
            seleccionats.add(copiaNoms.remove(index));
        }

        return seleccionats;
    }

    public static List<String> nomsAcabenVocal(List<String> noms) {
        List<String> resultat = new ArrayList<>();
        for (String nom : noms) {
            if ("aeiou".indexOf(Character.toLowerCase(nom.charAt(nom.length() - 1))) != -1) {
                resultat.add(nom);
            }
        }
        return resultat;
    }

    public static List<String> nomsCompostos(List<String> noms) {
        List<String> resultat = new ArrayList<>();
        for (String nom : noms) {
            if (nom.contains(" ")) {
                resultat.add(nom);
            }
        }
        return resultat;
    }

    public static void main(String[] args) {
        List<String> noms = List.of(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        );

        // N'escull 5 a l'atzar
        List<String> nomsAleatoris = escullNomsAleatoris(noms, 5);
        System.out.println("Noms escollits a l'atzar: " + nomsAleatoris);

        // Cas incorrecte
        try {
            List<String> seleccionatsError = escullNomsAleatoris(noms, 25);
            System.out.println("Noms escollits: " + seleccionatsError);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Noms que acaben amb vocal
        List<String> nomsVocal = nomsAcabenVocal(noms);
        System.out.println("Noms que acaben amb vocal: " + nomsVocal);

        // Noms compostos
        List<String> nomsCompostos = nomsCompostos(noms);
        System.out.println("Noms compostos: " + nomsCompostos);
    }
}
