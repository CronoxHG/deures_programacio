package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class Exercici0014 {

    private static String obtenirMovimentPC() {
        String[] opcions = {"PEDRA", "PAPER", "TISORES"};
        return opcions[new Random().nextInt(opcions.length)];
    }

    private static String obtenirMovimentJugador(Scanner lector) {
        while (true) {
            System.out.print("Tria PEDRA, PAPER, TISORES o SORTIR: ");
            String moviment = lector.nextLine().toUpperCase();

            if (moviment.equals("SORTIR")) return null;
            if (moviment.equals("PEDRA") || moviment.equals("PAPER") || moviment.equals("TISORES")) {
                return moviment;
            }
        }
    }

    private static String determinarGuanyador(String movimentJugador, String movimentPC) {
        if (movimentJugador.equals(movimentPC)) return "EMPAT";

        switch (movimentJugador) {
            case "PEDRA":
                return movimentPC.equals("TISORES") ? "JUGADOR" : "PC";
            case "PAPER":
                return movimentPC.equals("PEDRA") ? "JUGADOR" : "PC";
            case "TISORES":
                return movimentPC.equals("PAPER") ? "JUGADOR" : "PC";
            default:
                return "ERROR";
        }
    }

    private static String formatarMarcador(int puntsJugador, int puntsPC) {
        return String.format("Marcador: JUGADOR %d - PC %d", puntsJugador, puntsPC);
    }

    private static void actualitzarEstadistiques(HashMap<String, Integer> estadistiques, String moviment, boolean haGuanyat) {
        String clauMoviment = moviment + "_COUNT";
        estadistiques.put(clauMoviment, estadistiques.get(clauMoviment) + 1);

        if (haGuanyat) {
            String clauVictoria = moviment + "_WINS";
            estadistiques.put(clauVictoria, estadistiques.get(clauVictoria) + 1);
        }
    }

    private static void mostrarEstadistiques(HashMap<String, Integer> estadistiques) {
        int totalJocs = estadistiques.get("PEDRA_COUNT") + estadistiques.get("PAPER_COUNT") + estadistiques.get("TISORES_COUNT");
        int victòriesTotals = estadistiques.get("PEDRA_WINS") + estadistiques.get("PAPER_WINS") + estadistiques.get("TISORES_WINS");

        String movimentMesUsat = "PEDRA";
        int majorUs = estadistiques.get("PEDRA_COUNT");

        if (estadistiques.get("PAPER_COUNT") > majorUs) {
            movimentMesUsat = "PAPER";
            majorUs = estadistiques.get("PAPER_COUNT");
        }
        if (estadistiques.get("TISORES_COUNT") > majorUs) {
            movimentMesUsat = "TISORES";
            majorUs = estadistiques.get("TISORES_COUNT");
        }

        String millorMoviment = "PEDRA";
        double millorTaxa = calcularTaxaVictoria(estadistiques, "PEDRA");

        double taxaPaper = calcularTaxaVictoria(estadistiques, "PAPER");
        if (taxaPaper > millorTaxa) {
            millorMoviment = "PAPER";
            millorTaxa = taxaPaper;
        }

        double taxaTisores = calcularTaxaVictoria(estadistiques, "TISORES");
        if (taxaTisores > millorTaxa) {
            millorMoviment = "TISORES";
            millorTaxa = taxaTisores;
        }

        System.out.println("Estadístiques finals:");
        System.out.println("----------------------");
        System.out.println("Total partides: " + totalJocs);
        System.out.printf(Locale.US, "Percentatge de victòries: %.1f%%\n", calcularPercentatge(totalJocs, victòriesTotals));
        System.out.println("Moviment més utilitzat: " + movimentMesUsat + " (" + majorUs + " vegades)");
        System.out.printf(Locale.US, "Moviment més efectiu: %s (%.1f%% victòries)\n", millorMoviment, millorTaxa);
    }

    private static double calcularTaxaVictoria(HashMap<String, Integer> estadistiques, String moviment) {
        int usat = estadistiques.get(moviment + "_COUNT");
        int guanyat = estadistiques.get(moviment + "_WINS");
        return usat > 0 ? (double) guanyat / usat * 100 : 0;
    }

    private static double calcularPercentatge(int total, int parcial) {
        return total > 0 ? (double) parcial / total * 100 : 0;
    }

    public static void main(String[] args) {
        try (Scanner lector = new Scanner(System.in)) {
            HashMap<String, Integer> estadistiques = inicialitzarEstadistiques();
            int puntsJugador = 0, puntsPC = 0;

            System.out.println("Benvingut a Pedra, Paper, Tisores!");
            System.out.println("El primer que arriba a 3 punts guanya!\n");

            while (puntsJugador < 3 && puntsPC < 3) {
                String movimentJugador = obtenirMovimentJugador(lector);
                if (movimentJugador == null) break;

                String movimentPC = obtenirMovimentPC();
                System.out.println("PC tria: " + movimentPC);

                String resultat = determinarGuanyador(movimentJugador, movimentPC);
                if (resultat.equals("JUGADOR")) puntsJugador++;
                else if (resultat.equals("PC")) puntsPC++;

                System.out.println(formatarMarcador(puntsJugador, puntsPC));
                actualitzarEstadistiques(estadistiques, movimentJugador, resultat.equals("JUGADOR"));
            }

            if (puntsJugador >= 3 || puntsPC >= 3) {
                System.out.println(puntsJugador >= 3 ? "Has guanyat!" : "El PC ha guanyat!");
            }

            mostrarEstadistiques(estadistiques);
        }
    }

    private static HashMap<String, Integer> inicialitzarEstadistiques() {
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("PEDRA_COUNT", 0);
        stats.put("PAPER_COUNT", 0);
        stats.put("TISORES_COUNT", 0);
        stats.put("PEDRA_WINS", 0);
        stats.put("PAPER_WINS", 0);
        stats.put("TISORES_WINS", 0);
        return stats;
    }
}
