package GameData.Default.Save;

import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.Move;
import GameData.Default.Items.Item;
import GameData.Default.Story.Quest;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Sauvegarde {
    private String id;
    private ArrayList<Team> listeTeam = new ArrayList<>();
    private ArrayList<Quest> listeQuetes = new ArrayList<>();
    private String date;


    public Sauvegarde(String id){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        this.date = dateFormat.format(date);
        listeTeam = InitContenu.listeTeams;
        listeQuetes = InitContenu.listeQuetes;
        this.id = id;
    }



//    private void fileWrite(InitContenu contenu){
//        try{
//            PrintWriter writer = new PrintWriter(fichier.getName(), "UTF-8");
//            for (Team equipe: contenu.getListeTeams()) {
//                for (Item objet:equipe.getInventaire().getInventaire()) {
//                    writer.println(objet.getId());
//                }
//                writer.println("FIN_ITEM");
//                for (Pnj pnj:equipe.getListePNJ()) {
//                    writer.println(pnj.getId());
//            }
//            writer.close();
//        }catch (Exception ecriture_sauvegarde){
//
//        }
//    }


    public String getId() {
        return id;
    }

    public ArrayList<Quest> getListeQuetes() {
        return listeQuetes;
    }

    public ArrayList<Team> getListeTeam() {
        return listeTeam;
    }

    public String getDate() {
        return date;
    }
}
