package TP3;

public class TP3_Main {



    public static void main(String[] Args){

        //initialisation de la classe ligue en utilisant le fichier classement.txt
     Ligue ligue = new Ligue("classement.txt");

        String resultat1 = ligue.toString();

        System.out.println(resultat1);

        Ligue ligue2 = new Ligue("premierleague.txt");





    }
}
