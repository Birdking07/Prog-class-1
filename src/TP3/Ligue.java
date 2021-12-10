package TP3;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Ligue {
    public String[] Stockage_lignes;
    public static int nombreEquipes;
    private String[] infos;
    private String titre = "";
    private String[] colonnes;
    private int espacement;
    private int[] valeursPoints;
    private int[] valeursMoyenne;
    private Equipe[] equipes;


    public Ligue(String Filename) {
        final int lignes_info_fichier = 6;

       String[] Lignes = Fichier_classe();



        String equipes_string = Lignes[5];
        int nombreequipes = Integer.parseInt(equipes_string);
       Stockage_lignes = new String[nombreequipes];

        for (int i = 0 ; i < nombreequipes ; i++){
            Stockage_lignes[i] = Lignes[i];
        }


    }

    private void Infos_Table_Final_1(String[] Lignes){
      titre = Lignes[0];
        colonnes = infos[1].split(";");
        espacement = Integer.parseInt(infos[2]);
        valeursPoints = PlusieursNombres(infos[3]);
        valeursMoyenne = PlusieursNombres(infos[4]);
        nombreEquipes = Integer.parseInt(infos[5]);
        equipes = new Equipe[nombreEquipes];
        for(int i = 0; i < nombreEquipes; i++)
            equipes[i] = new Equipe(valeursPoints, valeursMoyenne, espacement, infos[6 + i]);
    }

    private String[] Fichier_classe() {
        String vide = "";
        try {
            File newfile = new File("classement.txt");
            Scanner Liseur_fichier = new Scanner(newfile);
            while (Liseur_fichier.hasNextLine()) {
                vide += Liseur_fichier.nextLine() + "\n";
            }
            return vide.split("\n");
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private int[] PlusieursNombres(String PointMoyenne){
        String[] temp = PointMoyenne.split(";");
        int[] returnValue = new int[temp.length];
        for(int i = 0; i < returnValue.length; i++){
            returnValue[i] = Integer.parseInt(temp[i]);
        }
        return returnValue;
    }
}

