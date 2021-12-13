package TP3;

public class Formateur {
    private int largeur;
    public Formateur(int largeur){
        this.largeur = largeur;
    }

    public String genererString(String chaine){
        String resultat = chaine;
        int i = 0;
        while(resultat.length() < largeur){
            if(i % 2 == 0) resultat += " "; // un espace à la fin
            else resultat = " " + resultat; // un espace au début
            i++;
        }
        return resultat;
    }

    public String genererInt(int valeur){
        return genererString(Integer.toString(valeur));
    }

}
