package TP3;

public class TP3_Main {



    public static void main(String[] Args){

        //initialisation de la classe ligue en utilisant le fichier classement.txt
     Ligue ligue1 = new Ligue("classement.txt");

        String resultat1 = ligue1.toString();

        System.out.println(resultat1);

        Ligue ligue2 = new Ligue("premierleague.txt");

        String resultat2 = ligue2.toString();

        System.out.println(resultat2);





    }
}
