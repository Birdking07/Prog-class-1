package TP3;

import java.io.File;

import java.util.Scanner;

public class Données_ligue {
    public static String[] sauvegarde_info_ligue;

    public Données_ligue(String Nom_fichier_ligue){

        try {

            File fichier_ligue = new File(Nom_fichier_ligue);
            Scanner liseur_fichier = new Scanner(Nom_fichier_ligue);
            String info = "";
            while(liseur_fichier.hasNextLine()){
                info += liseur_fichier.nextLine() + "\n";
            }
            sauvegarde_info_ligue = info.split("\n");
            for(int i = 0; i < sauvegarde_info_ligue.length; i++){
                System.out.println(sauvegarde_info_ligue[i]);
            }

            liseur_fichier.close();
        } catch (Exception e){
            System.out.println("Une erreur s'est produite en lisant le fichier classement.txt" +
                    "\n verifier le contenu du fichier et essayez encore");
            e.printStackTrace();
        }
        }

}
