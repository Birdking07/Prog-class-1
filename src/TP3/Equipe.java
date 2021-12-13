package TP3;



//My bad
public class Equipe {
    // le nombre de victoires
    private int victoires;

    //le nombre de match
    private int numeroMatch;

    // sert au calcul du nombre de match et il est utilisé avec numeromatch
    private int nombreMatch;

    //le nombre de défaites
    private int defaites;

    //le nombre d'égalité
    private int egalite;

    //le nombre de matchs identifiés comme étant pour
    private int pour;

    //le nombre de matchs identifiés comme étant contre
    private int contre;

    //initialisation du string qui va contenir le nom des équipes
    public String nomEquipe = "";

    //la différence
    private int Diff;

    //la moyenne
    private int moy;

    // le total
    private int total;

    //les règles imposé sur la moyenne dans le fichier
    private int[] valeursMoyenne;

    //les règles imposé sur le pointage dans le fichier
    private int[] valeursPoints;

    //espacement utilisé lorsqu'on appelle la classe Formateur
    public int espacement;

    // Appel de chaque methode qui sert à calculer les valeurs pour la table finale
    public Equipe(int[] valeursPoints, int[] valeursMoyenne, int espacement, String info) {
        this.valeursPoints = valeursPoints;
        this.valeursMoyenne = valeursMoyenne;
        Match_set(info);
        Diff = setDiff(Diff , pour , contre);
        numeroMatch = getMatch(nombreMatch , victoires , defaites , egalite);
        moy = getMoy(victoires , egalite , defaites , valeursMoyenne , moy ,numeroMatch);
        Calcul_total(valeursPoints , victoires, egalite, defaites );
        this.espacement = espacement;

    }


    // Passe les valeurs par le Formateur et ensuite vont revenir à la méthode toString dans ligue
    // Afin d'avoir toutes nos valeurs pour la table finale écrite dans main
    public String toString(){
        Formateur formateur = new Formateur(espacement);
        String Calculs_Equipe = nomEquipe;
        Calculs_Equipe += formateur.genererInt(numeroMatch);
        Calculs_Equipe += formateur.genererInt(victoires);
        Calculs_Equipe += formateur.genererInt(defaites);
        Calculs_Equipe += formateur.genererInt(egalite);
        Calculs_Equipe += formateur.genererInt(pour);
        Calculs_Equipe += formateur.genererInt(contre);
        Calculs_Equipe += formateur.genererInt(Diff);
        Calculs_Equipe += formateur.genererInt(moy);
        Calculs_Equipe += formateur.genererInt(total);

        return Calculs_Equipe;
    }


    //Le nombre de matchs
    private int getMatch(int nombreMatch , int victoires ,int defaites , int egalite){
        nombreMatch = victoires + defaites + egalite;
        return nombreMatch;
    }
    //La différence de Pour et Contre
    private int setDiff(int Diff , int pour , int contre){
        Diff = pour - contre;
        return Diff;
    }

    //Cette méthode retourne une moyenne des trois premiers chiffres par rapport aux règles imposées par le quatrième
    private int calculMoyenne(int victores, int egalite, int defaites, int[] valeurs){
        return victoires * valeurs[0] + defaites * valeurs[1] + egalite * valeurs[2];
    }

    //Calcul de la moyenne (voir méthode)
    private int getMoy(int victoires,int egalite, int defaites, int[] valeursMoyenne , int moy , int numeroMatch){
        moy = calculMoyenne(victoires, egalite, defaites, valeursMoyenne) / numeroMatch;
        return moy;
    }

    // retourne le total des points vers trouverpositionduplusgrand dans ligue
    public int getPoints(){
        return total;
    }


    // calcul du total des points
    private int Calcul_total(int[] valeursPoints , int victoires,int egalite,int defaites ){
        total = calculMoyenne(victoires, egalite, defaites, valeursPoints); //Calcul des points (voir méthode)
        return total;
    }

    private void Match_set(String info){
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