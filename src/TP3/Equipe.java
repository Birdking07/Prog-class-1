package TP3;

import java.awt.desktop.AppForegroundListener;
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
    private static int Diff;
    private static int moy;
    private static int total;
    private static int[] valeursMoyenne;
    private static int[] valeursPoints;


    public Equipe(int[] valeursPoints, int[] valeursMoyenne, int espacement, String info) {
        this.valeursPoints = valeursPoints;
        this.valeursMoyenne = valeursMoyenne;
        Match_set(info);
        int getDifferance = Calcul_diff(Diff , pour , contre);
        int numeroMatch = Calcul_match(nombreMatch , victoires , defaites , egalite);
        int moyenne = Appel_moy(victoires , egalite , defaites , valeursMoyenne , moy ,numeroMatch);
        int gettotal = Calcul_total(valeursPoints , victoires, egalite, defaites );





        System.out.println(nomEquipe + " " + numeroMatch + " " + victoires + " " + defaites + " " + egalite + " " + pour + " " + contre + " " + getDifferance + " " + moyenne + " " + gettotal);
    }

    private static int Calcul_match(int nombreMatch , int victoires ,int defaites , int egalite){
        nombreMatch = victoires + defaites + egalite; //Le nombre de matchs
        return nombreMatch;
    }

    private static int Calcul_diff(int Diff , int pour , int contre){
        Diff = pour - contre; //La différence de Pour et Contre (skill issue)
        return Diff;
    }

    private static int Appel_moy(int victoires,int egalite, int defaites, int[] valeursMoyenne , int moy , int numeroMatch){
        moy = calculMoyenne(victoires, egalite, defaites, valeursMoyenne) / numeroMatch; //Calcul de la moyenne (voir méthode)
        return moy;
    }

    //Cette méthode retourne une moyenne pondérée des trois premiers paramètres par rapport aux règles imposées par le quatrième
    private static int calculMoyenne(int victores, int egalite, int defaites, int[] valeurs){
        return victoires * valeurs[0] + defaites * valeurs[1] + egalite * valeurs[2];
    }

    private static int Calcul_total(int[] valeursPoints , int victoires,int egalite,int defaites ){
        total = calculMoyenne(victoires, egalite, defaites, valeursPoints); //Calcul des points (voir méthode)
        return total;
    }

    private static void Match_set(String info){
        //Separation de la chaine d'information d'équipe
        String infos[]  = info.split(";");
        nomEquipe = infos[0]; //Le nom d'équipe est la première information qui se trouve sur la ligne
        victoires = Integer.parseInt(infos[1]); //Victoires
        defaites = Integer.parseInt(infos[2]); //Défaites
        egalite = Integer.parseInt(infos[3]); //Égalités
        pour = Integer.parseInt(infos[4]); //Pour
        contre = Integer.parseInt(infos[5]); //Contre

    }
}