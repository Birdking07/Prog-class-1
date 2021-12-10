package TP3;

import java.io.File;

import java.util.Scanner;

public class Equipe {
    String nomEquipe = "";
    int[] nombreMatch;
    String[] stringMatchtemp;
    int[] diff;
    String[] difftemp;
    int[] moy;
    String[] moytemp;
    int[] total;
    String[] totaltemp;

    public Equipe(int[] valeursPoints, int[] valeursMoyenne, int espacement, String info) {

        Ligue monkey = new Ligue("classement.txt");
        int nombreequipes = Ligue.nombreEquipes;
        String[] Lignes_equipe = monkey.Stockage_lignes;

        String[] table_info_equipes = new String[nombreequipes];
        System.out.println(nombreequipes);

        for (int i = 0 ; i < nombreequipes ; i++){
            stringMatchtemp[i] = String.valueOf(Lignes_equipe[i + 6].split(";")[0]);
            nombreMatch[i] = Integer.parseInt(stringMatchtemp[i]);
        }

        for (int a = 0 ; a < nombreequipes ; a++){
            difftemp[a] = String.valueOf(Lignes_equipe[a + 6].split(";")[6]);
            diff[a] = Integer.parseInt(difftemp[a]);
        }
    }
}