package TP3;



//My bad
public class Equipe {
    public String resultat;
    public int victoires;
    public int numeroMatch;
    public int defaites;
    public int egalite;
    public int pour;
    public int contre;
    public String nomEquipe = "";
    public int nombreMatch;
    public int Diff;
    public int moy;
    public int total;
    public int[] valeursMoyenne;
    public int[] valeursPoints;
    public int espacement;


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

    public String getNomEquipe(){
        return nomEquipe;
    }

    public String toString(){
        Formateur formateur = new Formateur(espacement);
        String unBonTP = nomEquipe;
        unBonTP += formateur.genererInt(numeroMatch);
        unBonTP += formateur.genererInt(victoires);
        unBonTP += formateur.genererInt(defaites);
        unBonTP += formateur.genererInt(egalite);
        unBonTP += formateur.genererInt(pour);
        unBonTP += formateur.genererInt(contre);
        unBonTP += formateur.genererInt(Diff);
        unBonTP += formateur.genererInt(moy);
        unBonTP += formateur.genererInt(total);

        return unBonTP;
    }
    private int getMatch(int nombreMatch , int victoires ,int defaites , int egalite){
        nombreMatch = victoires + defaites + egalite; //Le nombre de matchs
        return nombreMatch;
    }

    private int setDiff(int Diff , int pour , int contre){
        Diff = pour - contre; //La différence de Pour et Contre (skill issue)
        return Diff;
    }

    //Cette méthode retourne une moyenne pondérée des trois premiers paramètres par rapport aux règles imposées par le quatrième
    private int calculMoyenne(int victores, int egalite, int defaites, int[] valeurs){
        return victoires * valeurs[0] + defaites * valeurs[1] + egalite * valeurs[2];
    }

    //Calcul de la moyenne (voir méthode)
    private int getMoy(int victoires,int egalite, int defaites, int[] valeursMoyenne , int moy , int numeroMatch){
        moy = calculMoyenne(victoires, egalite, defaites, valeursMoyenne) / numeroMatch;
        return moy;
    }

    public int getPoints(){
        return total;
    }



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