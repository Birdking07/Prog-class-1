package TP3;

import java.io.File;

import java.util.Scanner;

public class Classement {
    public static String[] sauvegarde_info_classement;
    public static String titre_ligue = "";


    public Classement(String Nom_fichier_classement) {

        try {

        File fichier_classement = new File(Nom_fichier_classement);
        Scanner liseur_fichier = new Scanner(fichier_classement);
        String information = "";
            while(liseur_fichier.hasNextLine()){
                information += liseur_fichier.nextLine() + "\n";
            }
            sauvegarde_info_classement = information.split("\n");
          for(int i = 0; i < sauvegarde_info_classement.length; i++){
            System.out.println(sauvegarde_info_classement[i]);
           }
          titre_ligue += sauvegarde_info_classement[0];
        liseur_fichier.close();
    } catch (Exception e){
            System.out.println("Une erreur s'est produite en lisant le fichier classement.txt" +
                    "\n verifier le contenu du fichier et essayez encore");
            e.printStackTrace();
        }



    }
    public Classement(String[] infoequipe , String[] infopoints ,
                      int[] infoMoyenne , String infoLargeurFormat){
        final int lignes_info_fichier = 6;

        int victoires = 0;
        int defaites = 0;
        int match_nul = 0;

        int nombreequipes = Integer.parseInt(sauvegarde_info_classement[5]);

        infoequipe = new String[nombreequipes];
        infopoints = new String[nombreequipes];
        infoMoyenne = new int[nombreequipes];

        for (int i = 0 ; i < nombreequipes; i++){
            infoequipe[i] = sauvegarde_info_classement[6 + i].split(";")[0];
            infoequipe[i].trim();
        }

        for (int a = 0 ; a < nombreequipes; a++){

            for (int d = 1 ; d <= 5 ; d++){
                infopoints[a] += sauvegarde_info_classement[7 + a].split(";")[a + d];
            }
        }


        infopoints[0]



        infoLargeurFormat = sauvegarde_info_classement[2];

    }
}
