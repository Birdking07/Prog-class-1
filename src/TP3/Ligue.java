package TP3;

// On utilise File + Scanneur pour chercher les données dans le fichier
import java.io.File;
import java.util.Scanner;


public class Ligue {

    // va sauvegarder le nombre total d'équipes.

    public static int nombreEquipes;

    // initialisation du string titre qui va recevoir le nom de l'équipe.

    private String titre = "";

    // Le nombre total des colonnes (victoires , défaites etc).

    private String[] colonnes;

    // espacement entre chaque colonne

    private int espacement;

    // les 3 valeurs pour le calcul du pointage dans une table

    private int[] valeursPoints;

    // les 3 valeurs pour le calcul de la moyenne aussi dans une table

    private int[] valeursMoyenne;

    // initialisation de la classe équipe

    private Equipe[] equipes;

    // recherche des données du fichier avec getInfos ensuite on les envoie vers setInfos
    public Ligue(String Filename) {

        // recherche des données de base dans la méthode dessiner
       String[] getInfos = ChercherInfos(Filename);

        //envoi de getInfos vers setInfos
        setInfos(getInfos);

        //trierEquipes();


    }
    // Les valeurs pour notre affichage final qui se trouvent directement dans le fichier
    private void setInfos(String[] Lignes){

        //le titre de la Ligue
      titre = Lignes[0];

        //Recherche des noms de chaque colonne dans l'affichage
        colonnes = Lignes[1].split(";");

        //Recherche de l'espacement entre chaque colonne sous valeur int pour faire le calcul plus tard dans Affichage
        espacement = Integer.parseInt(Lignes[2]);

        // Envoie des valeurs vers la méthode PlusieursNombres ou lignes se représente par PointValeurs
        valeursPoints = PlusieursNombres(Lignes[3]);
        valeursMoyenne = PlusieursNombres(Lignes[4]);

        // Transformation en int pour la boucle for qui va suivre
        nombreEquipes = Integer.parseInt(Lignes[5]);

        // va boucler l'instance de la classe equipe pour chaque ligne
        equipes = new Equipe[nombreEquipes];
        for(int i = 0; i < nombreEquipes; i++){
            equipes[i] = new Equipe(valeursPoints, valeursMoyenne, espacement, Lignes[i + 6]);
        }
        trierEquipes();
    }

    // methode qui va lire le fichier
    public String[] ChercherInfos(String filename) {
        String vide = "";
        // initiation du scanner Liseur_fichier avec l'utilisation de File nommé newfile
        try {
            File newfile = new File(filename);
            Scanner Liseur_fichier = new Scanner(newfile);

            //lorsqu'il y a une autre ligne notre string vide va contatiner les résultats avec un espacement ajouté.
            while (Liseur_fichier.hasNextLine()) {
                vide += Liseur_fichier.nextLine() + "\n";
            }
            // l'espacement ajouté va servir à briser le résultat qui va être retourné sous forme de table à getInfos
            return vide.split("\n");

            //catch obligatoire avec le liseur de fichier qui doit utiliser try
        } catch (Exception e) {
            System.out.println(e);
        }
        // on pourrait retourner n'importe quoi ici alors null est suffisant.
        return null;
    }

    // va chercher les valeurs soit pour le pointage ou la moyenne des lignes 4 et 5 dans classement.txt

    private int[] PlusieursNombres(String PointValeurs){

        // on cherche les valeurs du pointage et la moyenne
        String[] stockage_temp = PointValeurs.split(";");
        int[] returnValeur = new int[stockage_temp.length];

        // on transforme les valeurs en int
        for(int i = 0; i < returnValeur.length; i++){
            returnValeur[i] = Integer.parseInt(stockage_temp[i]);
        }
        // on retourne la table des valeurs obtenues.
        return returnValeur;
    }

    //
    public String toString(){
        Formateur forTitle = new Formateur(espacement * 10);
        Formateur forReste = new Formateur(espacement);
        String head = forTitle.genererString(titre) + "\n";
        for(int i = 0; i < colonnes.length; i++){
            head += forReste.genererString(colonnes[i]);
        }


        return head;


    }

    private void trierEquipes(){
        // en faire une copie
        Equipe[] copie = new Equipe[equipes.length];

        for(int i = 0; i < equipes.length; i++) copie[i] = equipes[i];


        int j = 0; // la position de la prochaine équipe
        for(int i = 0; i < equipes.length; i++) {
            int pos = trouverPositionDuPlusGrand(copie);
            equipes[j] = copie[pos];
            j++;
            //on l'élimine de la copie
            copie[pos] = null;
        }
    }

    private int trouverPositionDuPlusGrand(Equipe[] equipe){
        int pos = 0;

        while(equipe[pos] == null){
            pos++;
        }

        int total = equipe[pos].getPoints();
        for(int i = 0; i < equipe.length; i++){

            if(equipe[i] != null){
                if(equipe[i].getPoints() > total){
                    pos = i;
                    total = equipe[i].getPoints();
                }
            }
        }
        return pos;
    }





}

