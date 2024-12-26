package com.exercicis;


public class Exercici0005 {

    public static boolean isPalindrom(String frase) {
        
        frase = normalize(frase);
        
     
        String invers = "";
        for (int i = frase.length() - 1; i >= 0; i--) {
            invers = invers + frase.charAt(i);
        }

        return frase.equals(invers);
    }

    public static String normalize(String frase) {
        String resultat = frase.toLowerCase();
    
       
        String[] accents = {"à", "á", "è", "é", "í", "ò", "ó", "ú", "ù", " ", "'", "!", "\\.", ",", "·"};
        String[] senseAccents = {"a", "a", "e", "e", "i", "o", "o", "u", "u", "", "", "", "", "", ""};
    
        for (int i = 0; i < accents.length; i++) {
            resultat = resultat.replaceAll(accents[i], senseAccents[i]);
        }
        
        return resultat;
    }

    public static void main(String[] args) {

        String[] frases = {
            "Anul·la la lluna",
            "Atrapa la lluna",
            "Atrapa'l o l'aparta",
            "Aparta'l o atrapa'l",
            "No sap pas on",
            "On sap pas qui",
            "Tramaran anar a Mart",
            "A Mart trobaràn art",
            "Un pop nu",
            "Nu pop un"
        };

   
        for (String frase : frases) {
            boolean palindrom = isPalindrom(frase);
            System.out.println(frase + " (" + (palindrom ? "Si" : "No") + ")");
        }
    }
}
