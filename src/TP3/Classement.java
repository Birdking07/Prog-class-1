package TP3;

public class Classement {
    public static String[] sauvegarde_info_classement;
    public static String titre_ligue = "";



    public  Classement(String[] infopoints, int[] infoMoyenne, String infolargeurFormat, String[] infoequipe) {
        final int lignes_info_fichier = 6;

        int victoires = 0;
        int defaites = 0;
        int match_nul = 0;

        int nombreequipes = Integer.parseInt(sauvegarde_info_classement[5]);

        infoequipe = new String[nombreequipes];
        infopoints = new String[nombreequipes];
        infoMoyenne = new int[nombreequipes];
        int chiffresmoyenne = 0;


        for (int i = 0; i < nombreequipes; i++) {
            infoequipe[i] = sauvegarde_info_classement[6 + i].split(";")[0];
        }

        for (int a = 0; a < nombreequipes; a++) {

            for (int d = 1; d <= 5; d++) {
                infopoints[a] += sauvegarde_info_classement[7 + a].split(";")[a + d];
                System.out.println(infopoints[a]);
            }
        }
        infolargeurFormat = sauvegarde_info_classement[2];
        int largeurFormat;
        largeurFormat = Integer.parseInt(infolargeurFormat);

    }
}

