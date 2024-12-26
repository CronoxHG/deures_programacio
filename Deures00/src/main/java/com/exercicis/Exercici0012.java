package com.exercicis;

import java.util.*;

public class Exercici0012 {

    private static HashMap<String, Object> crearMeravella(String nom, String ubicacio, int antiguitat) {
        HashMap<String, Object> meravella = new HashMap<>();
        meravella.put("nom", nom);
        meravella.put("ubicacio", ubicacio);
        meravella.put("antiguitat", antiguitat);
        return meravella;
    }

    private static void mostrarInformacio(ArrayList<HashMap<String, Object>> llista) {
        for (HashMap<String, Object> meravella : llista) {
            System.out.println("- Nom: " + meravella.get("nom"));
            System.out.println("  Ubicació: " + meravella.get("ubicacio"));
            System.out.println("  Antiguitat: " + meravella.get("antiguitat") + " anys");
        }
    }

    private static ArrayList<HashMap<String, Object>> ordenarPerNom(ArrayList<HashMap<String, Object>> llista) {
        ArrayList<HashMap<String, Object>> copia = new ArrayList<>(llista);
        copia.sort(Comparator.comparing(meravella -> (String) meravella.get("nom")));
        return copia;
    }

    private static ArrayList<HashMap<String, Object>> obtenirMeravellesAntigues(ArrayList<HashMap<String, Object>> llista, int quantes) {
        ArrayList<HashMap<String, Object>> copia = new ArrayList<>(llista);
        copia.sort((a, b) -> ((Integer) b.get("antiguitat")).compareTo((Integer) a.get("antiguitat")));
        return new ArrayList<>(copia.subList(0, Math.min(quantes, copia.size())));
    }

    private static ArrayList<HashMap<String, Object>> filtrarPerRegio(ArrayList<HashMap<String, Object>> llista, String regio) {
        ArrayList<HashMap<String, Object>> filtrades = new ArrayList<>();
        for (HashMap<String, Object> meravella : llista) {
            if (((String) meravella.get("ubicacio")).contains(regio)) {
                filtrades.add(meravella);
            }
        }
        return filtrades;
    }

    private static ArrayList<String> obtenirNomsOrdenats(ArrayList<HashMap<String, Object>> llista) {
        ArrayList<HashMap<String, Object>> ordenades = ordenarPerNom(llista);
        ArrayList<String> noms = new ArrayList<>();
        for (HashMap<String, Object> meravella : ordenades) {
            noms.add((String) meravella.get("nom"));
        }
        return noms;
    }

    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> meravelles = new ArrayList<>(Arrays.asList(
            crearMeravella("Gran Piràmide de Giza", "Egipte", 4500),
            crearMeravella("Jardins Penjants de Babilònia", "Babilònia, Mesopotàmia", 2500),
            crearMeravella("Estàtua de Zeus a Olímpia", "Olímpia, Grècia", 2500),
            crearMeravella("Temple d'Àrtemis a Efes", "Efes, Turquia", 2400),
            crearMeravella("Mausoleu d'Halicarnàs", "Halicarnàs, Turquia", 2300),
            crearMeravella("Colós de Rodes", "Illes Rodes, Grècia", 2300),
            crearMeravella("Faro d'Alexandria", "Alexandria, Egipte", 2200)
        ));

        System.out.println("Totes les Meravelles:");
        mostrarInformacio(meravelles);

        System.out.println("-".repeat(30));
        System.out.println("Noms ordenats:");
        System.out.println(obtenirNomsOrdenats(meravelles));

        System.out.println("-".repeat(30));
        System.out.println("Les 3 més antigues:");
        mostrarInformacio(obtenirMeravellesAntigues(meravelles, 3));

        System.out.println("-".repeat(30));
        System.out.println("Meravelles de Turquia:");
        mostrarInformacio(filtrarPerRegio(meravelles, "Turquia"));
    }
}
