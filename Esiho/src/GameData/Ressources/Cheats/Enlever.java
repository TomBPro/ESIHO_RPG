package GameData.Ressources.Cheats;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import sample.MainActivity;

public class Enlever {

    public Enlever(InitContenu contenu, Pnj PNJ){
        contenu.getListeTeams().get(0).removePNJ(PNJ);
    }//Suppression d'un PNJ à l'équipe du joueur

    public Enlever(InitContenu contenu, Pnj PNJ, Team equipe){
        contenu.getListeTeams().get(contenu.getListeTeams().indexOf(equipe)).removePNJ(PNJ);
    }//Suppression d'un PNJ à l'équipe donnée

    public Enlever(InitContenu contenu, Item objet){
        contenu.getListeTeams().get(0).getInventaire().removeItem(objet);
    }//Suppression d'un objet à l'inventaire de l'équipe du joueur

    public Enlever(InitContenu contenu, Item objet, Team equipe){
        contenu.getListeTeams().get(contenu.getListeTeams().indexOf(equipe)).getInventaire().removeItem(objet);
    }//Suppression d'un objet à l'inventaire de l'équipe donnée

    public Enlever(InitContenu contenu, Item objet, Integer quantite){
        for (int a = 0; a<quantite; a++){
            contenu.getListeTeams().get(0).getInventaire().removeItem(objet);
        }
    }//Suppression d'une quantité d'objets à l'inventaire de l'équipe du joueur

    public Enlever(InitContenu contenu, Item objet, Team equipe, Integer quantite){
        for (int a = 0; a<quantite; a++){
            contenu.getListeTeams().get(contenu.getListeTeams().indexOf(equipe)).getInventaire().removeItem(objet);
        }
    }//Suppression d'une quantité d'objets à l'inventaire de l'équipe donnée

    public Enlever(InitContenu contenu, Integer quantiteArgent, Team equipe){
        contenu.getListeTeams().get(contenu.getListeTeams().indexOf(equipe)).removeArgent(quantiteArgent);
    }//Supression d'une certaine quantité d'argent à l'équipe donnée

    public Enlever(InitContenu contenu, Integer quantiteArgent){
        contenu.getListeTeams().get(0).removeArgent(quantiteArgent);
    }//Supression d'une certaine quantité d'argent à l'équipe du joueur
}
