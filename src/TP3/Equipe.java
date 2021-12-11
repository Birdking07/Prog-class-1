package TP3;

import java.io.File;

import java.util.Scanner;

//My bad
public class Equipe {
    private static int victoires;
    private static int defaites;
    private static int egalite;
    private static int pour;
    private static int contre;
    private static String nomEquipe = "";
    private static int nombreMatch;
    private static int skillDiff;
    private static int moy;
    private static int total;
    private static int[] valeursMoyenne;
    private static int[] valeursPoints;
    public Equipe(int[] valeursPoints, int[] valeursMoyenne, int espacement, String info) {
        this.valeursPoints = valeursPoints;
        this.valeursMoyenne = valeursMoyenne;
        Match_set(info);
    }

    private static void Match_set(String info){
        //Separation de la chaine d'information d'équipe
        String infos[]  = info.split(";");
        nomEquipe = infos[0]; //Le nom d'équipe est la première information qui se trouve sur la ligne
        victoires = Integer.parseInt(infos[1]); //Victoires
        defaites = Integer.parseInt(infos[2]); //Défaites
        egalite = Integer.parseInt(infos[3]); //Égalités
        nombreMatch = victoires + defaites + egalite; //Le nombre de matchs
        pour = Integer.parseInt(infos[4]); //Pour
        contre = Integer.parseInt(infos[5]); //Contre
        skillDiff = pour - contre; //La différence de Pour et Contre (skill issue)
        moy = calculMoyenne(victoires, egalite, defaites, valeursMoyenne) / nombreMatch; //Calcul de la moyenne (voir méthode)
        total = calculMoyenne(victoires, egalite, defaites, valeursPoints); //Calcul des points (voir méthode)
        System.out.println(nomEquipe + " " + nombreMatch + " " + victoires + " " + defaites + " " + egalite + " " + pour + " " + contre + " " + skillDiff + " " + moy + " " + total);
    }
    //Cette méthode retourne une moyenne pondérée des trois premiers paramètres par rapport aux règles imposées par le quatrième
    private static int calculMoyenne(int victores, int egalite, int defaites, int[] valeurs){
        return victoires * valeurs[0] + defaites * valeurs[1] + egalite * valeurs[2];
    }
}