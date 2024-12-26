package com.exercicis;


import java.util.Locale;

public class Exercici0006 {

    public static double calculaEntrada(int adults, int nens, int grans, String diaSetmana) {
        final double PREU_ADULT = 10.0;
        final double PREU_NEN = 5.0;
        final double PREU_GRAN = 6.0;

        double total = (adults * PREU_ADULT) + (nens * PREU_NEN) + (grans * PREU_GRAN);

        if ("dimarts".equalsIgnoreCase(diaSetmana)) {
            total *= 0.8; // Reducció del 20%
        }

        else if ("dijous".equalsIgnoreCase(diaSetmana) && nens > 0 && adults > 0) {
            total -= PREU_NEN * 0.5; 
            if (nens > 1) {
                total -= PREU_NEN * (nens - 1); 
            }
        }

        return total;
    }

    public static void main(String[] args) {
        String format = "%-35s%.2f€";

        System.out.println(String.format(Locale.US, format, "Cas 1 (2 adults, 2 nens, 1 gran):", calculaEntrada(2, 2, 1, "dimarts")));
        System.out.println(String.format(Locale.US, format, "Cas 2 (1 adult,  2 nens, 0 grans):", calculaEntrada(1, 2, 0, "dijous")));
        System.out.println(String.format(Locale.US, format, "Cas 3 (0 adults, 0 nens, 2 grans):", calculaEntrada(0, 0, 2, "dissabte")));
        System.out.println(String.format(Locale.US, format, "Cas 4 (1 adult,  0 nens, 0 grans):", calculaEntrada(1, 0, 0, "diumenge")));
        System.out.println(String.format(Locale.US, format, "Cas 5 (1 adult,  3 nens, 4 grans):", calculaEntrada(1, 3, 4, "dijous")));
        System.out.println(String.format(Locale.US, format, "Cas 6 (2 adults, 2 nens, 1 gran):", calculaEntrada(2, 2, 1, "diumenge")));
    }
}
