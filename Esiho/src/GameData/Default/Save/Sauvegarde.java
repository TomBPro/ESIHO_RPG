package GameData.Default.Save;

import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.Move;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sauvegarde {
    private String dateSv;
    private File fichier;
    private Path chemin;


    public Sauvegarde(InitContenu contenu){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.dateSv = dateFormat.format(date);
        directory();
        file();
        fileWrite(contenu);
    }

    private void directory(){
        try{
            Path currentPath = Paths.get(System.getProperty("user.dir"));
            Path filePath = Paths.get(currentPath.toString(), "Esiho", "Save");
            String chemin = filePath.toString();

            File dossier = new File(chemin);//Création du répertoire où les sauvegardes vont être faites
            if (!dossier.exists()){
                dossier.mkdirs();
            }
            this.chemin=filePath;
        }catch (Exception creation_arborescence){
            //Erreur dans la création de l'arborescence
        }
    }//Crée l'arborescence du répertoire

    private void file() {
        try{
            Boolean fin = false;
            Integer compteur = 1;
            File fichier = new File(this.chemin + "sauvegarde1.txt");//Vide
            while (fin = false) {
                //Création du fichier
                if (fichier.createNewFile()) {
                    //Le fichier se crée
                    fin=true;
                } else {
                    //Le fichier existe déjà
                    compteur++;
                    fichier = new File(this.chemin + "sauvegarde"+compteur+".txt");
                }
            }
            this.fichier=fichier;
        }catch (Exception creation_fichier){
            //Erreur lors de la création du fichier de sauvegarde
        }
    }//Crée le fichier de sauvegarde

    private void fileWrite(InitContenu contenu){
        try{
            PrintWriter writer = new PrintWriter(fichier.getName(), "UTF-8");
            for (Team equipe: contenu.getListeTeams()) {
                writer.print(equipe.getId());
                writer.println(equipe.getArgent());
                writer.println(equipe.getPosition());
                for (Item objet:equipe.getInventaire().getInventaire()) {
                    writer.println(objet.getId());
                }
                writer.println("FIN_ITEM");
                for (Pnj pnj:equipe.getListePNJ()) {
                    writer.println(pnj.getId());
                    writer.println(pnj.getEntite().getName());
                    writer.println(pnj.getEntite().getLvl());
                    writer.println(pnj.getEntite().getXpmax());
                    writer.println(pnj.getEntite().getXp());
                    writer.println(pnj.getEntite().getPV().getPvmax());
                    writer.println(pnj.getEntite().getPV().getPv());
                    writer.println(pnj.getEntite().getType().getNomType());
                    writer.println(pnj.getEntite().getAtt());
                    writer.println(pnj.getEntite().getAttspe());
                    writer.println(pnj.getEntite().getDef());
                    writer.println(pnj.getEntite().getDefspe());
                    writer.println(pnj.getEntite().getVitesse());
                    for (Move movePhy:pnj.getEntite().getMovesPhy().getMovelist()) {
                        writer.println(movePhy.getId());
                    }
                    writer.println("FIN_MOVEPHY");
                    for (Move movePhy:pnj.getEntite().getMovesSpe().getMovelist()) {
                        writer.println(movePhy.getId());
                    }
                    writer.println("FIN_MOVESPE");
                    writer.println(pnj.getEntite().getArme().getId());
                    writer.println(pnj.getEntite().getArmure().getId());
                }
                writer.println("FIN_PNJ");
                writer.println("FIN_TEAM");
                writer.println("");
            }
            writer.close();
        }catch (Exception ecriture_sauvegarde){

        }
    }
}
