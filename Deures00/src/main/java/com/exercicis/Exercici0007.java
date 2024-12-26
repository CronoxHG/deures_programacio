package com.exercicis;

import java.util.Locale;

public class Exercici0007 {

    public static double calculaCostLloc(String tipusLloc) {
        tipusLloc = tipusLloc.toLowerCase();
        if (tipusLloc.equals("sala estàndard")) {
            return 100.0;
        } else if (tipusLloc.equals("jardí amb piscina")) {
            return 200.0;
        } else if (tipusLloc.equals("saló gran amb escenari")) {
            return 500.0;
        } else {
            throw new IllegalArgumentException("Tipus de lloc desconegut: " + tipusLloc);
        }
    }

    public static double calculaCostMenjar(String tipusMenjar, int numConvidats) {
        double preuPerConvidat;
        if (tipusMenjar.equalsIgnoreCase("menú bàsic")) {
            preuPerConvidat = 15.0;
        } else if (tipusMenjar.equalsIgnoreCase("menú premium")) {
            preuPerConvidat = 30.0;
        } else {
            throw new IllegalArgumentException("Tipus de menú desconegut: " + tipusMenjar);
        }

        double costTotal = preuPerConvidat * numConvidats;

        // Descompte per més de 50 convidats
        if (numConvidats > 50) {
            costTotal *= 0.95;
        }

        return costTotal;
    }

    public static double calculaCostEntreteniment(String tipusEntreteniment) {
        if (tipusEntreteniment.equalsIgnoreCase("màgia")) {
            return 250.0;
        } else if (tipusEntreteniment.equalsIgnoreCase("música en directe")) {
            return 500.0;
        } else if (tipusEntreteniment.equalsIgnoreCase("cap")) {
            return 0.0;
        } else {
            throw new IllegalArgumentException("Tipus d'entreteniment desconegut: " + tipusEntreteniment);
        }
    }
    

    public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats) {
        double costLloc = calculaCostLloc(tipusLloc);
        double costMenjar = calculaCostMenjar(tipusMenjar, numConvidats);
        double costEntreteniment = calculaCostEntreteniment(tipusEntreteniment);

        // Promoció combinada
        if (tipusLloc.equalsIgnoreCase("saló gran amb escenari") && tipusEntreteniment.equalsIgnoreCase("música en directe")) {
            costEntreteniment -= 100.0;
        }

        return costLloc + costMenjar + costEntreteniment;
    }

    public static void main(String[] args) {
        String format = "%-75s%.2f€";

        System.out.println(String.format(Locale.US, format, "Cas 1 (\"sala estàndard\", \"menú bàsic\", \"cap\", 20):", calculaFesta("sala estàndard", "menú bàsic", "cap", 20)));
        System.out.println(String.format(Locale.US, format, "Cas 2 (\"jardí amb piscina\", \"menú premium\", \"màgia\", 60):", calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)));
        System.out.println(String.format(Locale.US, format, "Cas 3 (\"jardí amb piscina\", \"menú bàsic\", \"música en directe\", 40):", calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)));
        System.out.println(String.format(Locale.US, format, "Cas 4 (\"saló gran amb escenari\", \"menú premium\", \"música en directe\", 70):", calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)));
        System.out.println(String.format(Locale.US, format, "Cas 5 (\"sala estàndard\", \"menú premium\", \"màgia\", 15):", calculaFesta("sala estàndard", "menú premium", "màgia", 15)));
    }
}
