package TP3;

// on utilise File + Filewriter pour écrire nos données dans leurs fichiers de sortie
import java.io.File;
import java.io.FileWriter;


public class TP3_Main {



    public static void main(String[] Args){


        //initialisation de la classe ligue en utilisant le fichier classement.txt
     Ligue ligue1 = new Ligue("classement.txt");

        String resultat1 = ligue1.toString();

        // affichage du résultat dans la console
        System.out.println(resultat1);

        //utilisation de File ainsi que FileWriter pour écrire le résultat dans le fichier de sortie
        try {
            File sortie_classement = new File("Sortieclassement.txt");
            FileWriter fileWriter = new FileWriter(sortie_classement);
            fileWriter.write(resultat1);
            fileWriter.close();

        }
        catch (Exception e){
            System.out.println("erreur l'ecriture dans le fichier");
        }



        //initialisation de la classe ligue pour le fichier premierleague.txt

        Ligue ligue2 = new Ligue("premierleague.txt");

        String resultat2 = ligue2.toString();


        // affichage du résultat dans la console
        System.out.println(resultat2);

        //utilisation de File ainsi que FileWriter pour écrire le résultat dans le fichier de sortie
        try {
            File sortie_league = new File("Sortieleague.txt");
            FileWriter fileWriter = new FileWriter(sortie_league);
            fileWriter.write(resultat2);
            fileWriter.close();

        }
        catch (Exception e){
            System.out.println("erreur l'ecriture dans le fichier");
        }







    }
}
