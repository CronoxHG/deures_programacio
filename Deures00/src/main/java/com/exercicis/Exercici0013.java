package com.exercicis;

import java.util.*;

public class Exercici0013 {

    private static int generarId(ArrayList<HashMap<String, Object>> ciutats) {
        Random aleatori = new Random();
        int id;
        do {
            id = 1000 + aleatori.nextInt(9000);
        } while (existeixId(ciutats, id));
        return id;
    }

    private static boolean existeixId(ArrayList<HashMap<String, Object>> ciutats, int id) {
        for (HashMap<String, Object> ciutat : ciutats) {
            if ((int) ciutat.get("id") == id) {
                return true;
            }
        }
        return false;
    }

    private static int obtenirIdPerNom(ArrayList<HashMap<String, Object>> ciutats, String nom) {
        for (HashMap<String, Object> ciutat : ciutats) {
            if (ciutat.get("nom").equals(nom)) {
                return (int) ciutat.get("id");
            }
        }
        return -1;
    }

    private static void afegirCiutat(ArrayList<HashMap<String, Object>> ciutats, String nom, int poblacio, int altitud, boolean aLaCosta) {
        HashMap<String, Object> ciutat = new HashMap<>();
        ciutat.put("id", generarId(ciutats));
        ciutat.put("nom", nom);
        ciutat.put("poblacio", poblacio);
        ciutat.put("altitud", altitud);
        ciutat.put("aLaCosta", aLaCosta);
        ciutats.add(ciutat);
    }

    private static void eliminarCiutat(ArrayList<HashMap<String, Object>> ciutats, int id) {
        ciutats.removeIf(ciutat -> (int) ciutat.get("id") == id);
    }

    private static void actualitzarDades(ArrayList<HashMap<String, Object>> ciutats, int id, String camp, Object valor) {
        for (HashMap<String, Object> ciutat : ciutats) {
            if ((int) ciutat.get("id") == id) {
                ciutat.put(camp, valor);
                break;
            }
        }
    }

    private static void mostrarCiutats(ArrayList<HashMap<String, Object>> ciutats) {
        int ampleId = 5;
        int ampleNom = 12;
        int amplePoblacio = 10;
        int ampleAltitud = 8;
        int ampleCosta = 9;
        int ampleTotal = ampleId + ampleNom + amplePoblacio + ampleAltitud + ampleCosta + 6;

        String format = "|%-" + ampleId + "s|%-" + ampleNom + "s|%" + amplePoblacio + "s|%" + ampleAltitud + "s|%" + ampleCosta + "s|\n";

        System.out.println("-".repeat(ampleTotal));
        System.out.printf(format, "ID", "Nom", "Població", "Altitud", "Costa");
        System.out.println("-".repeat(ampleTotal));

        for (HashMap<String, Object> ciutat : ciutats) {
            System.out.printf(format, ciutat.get("id"), ciutat.get("nom"),
                ciutat.get("poblacio"), ciutat.get("altitud"), ciutat.get("aLaCosta"));
        }

        System.out.println("-".repeat(ampleTotal));
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> ciutats = new ArrayList<>();

        // Afegir les ciutats inicials
        afegirCiutat(ciutats, "Barcelona", 1620343, 12, true);
        afegirCiutat(ciutats, "Madrid", 3207247, 667, false);
        afegirCiutat(ciutats, "València", 791413, 15, true);
        afegirCiutat(ciutats, "Màlaga", 569130, 11, true);
        afegirCiutat(ciutats, "Sevilla", 688711, 7, false);
        afegirCiutat(ciutats, "Alicante", 330525, 12, true);
        afegirCiutat(ciutats, "Zaragoza", 664938, 220, false);
        afegirCiutat(ciutats, "Gijón", 275735, 3, true);
        afegirCiutat(ciutats, "Palma de M", 22610, 14, true);
        afegirCiutat(ciutats, "Bilbao", 345821, 30, false);

        // Eliminar Sevilla
        int idSevilla = obtenirIdPerNom(ciutats, "Sevilla");
        if (idSevilla != -1) {
            eliminarCiutat(ciutats, idSevilla);
        }

        // Actualitzar diverses dades
        int idBarcelona = obtenirIdPerNom(ciutats, "Barcelona");
        actualitzarDades(ciutats, idBarcelona, "poblacio", 1621000);

        int idValencia = obtenirIdPerNom(ciutats, "València");
        actualitzarDades(ciutats, idValencia, "altitud", 16);

        int idPalma = obtenirIdPerNom(ciutats, "Palma de M");
        actualitzarDades(ciutats, idPalma, "nom", "Palma");

        int idZaragoza = obtenirIdPerNom(ciutats, "Zaragoza");
        actualitzarDades(ciutats, idZaragoza, "aLaCosta", false);

        // Afegir una nova ciutat
        afegirCiutat(ciutats, "Tarragona", 132299, 70, true);

        // Mostrar la informació final
        mostrarCiutats(ciutats);
    }
}


