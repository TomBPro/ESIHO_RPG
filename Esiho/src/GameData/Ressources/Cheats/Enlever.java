package GameData.Ressources.Cheats;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import sample.MainActivity;

public class Enlever {

    public Enlever(String id) {
        if (id.substring(0, 1) == "P") {
            Team.getTeam("T0").removePNJ(Pnj.getPnj(id));
            //Ajout d'un PNJ à l'équipe du joueur
        } else if (id.substring(0, 1) == "I") {
            Team.getTeam("T0").getInventaire().removeItem(Item.getItem(id));
            //Ajout d'un objet à l'inventaire de l'équipe du joueur
        }
    }

    public Enlever(String id, String idTeam){
        if (idTeam.substring(0, 1)=="T"){
            if (id.substring(0, 1)=="P"){
                Team.getTeam(idTeam).removePNJ(Pnj.getPnj(id));
                //Ajout d'un PNJ à l'équipe donnée
            }else if (id.substring(0, 1)=="I"){
                Team.getTeam(idTeam).getInventaire().removeItem(Item.getItem(id));
                //Ajout d'un objet à l'inventaire de l'équipe donnée
            }
        }else{
            System.out.println("Erreur ! Id de team est incorrect");
        }
    }

    public Enlever(String id, Integer quantite){
        if (id.substring(0, 1)=="P"){
            for (int a = 0; a<quantite; a++){
                Team.getTeam("T0").removePNJ(Pnj.getPnj(id));
                //Ajout d'une quantité de Pnj dans l'équipe du joueur
            }
        }else if (id.substring(0, 1)=="I"){
            for (int a = 0; a<quantite; a++){
                Team.getTeam("T0").getInventaire().removeItem(Item.getItem(id));
                //Ajout d'une quantité d'objets à l'inventaire de l'équipe du joueur
            }
        }
    }

    public Enlever(String id, String idTeam, Integer quantite){
        if (idTeam.substring(0, 1)=="T"){
            if (id.substring(0, 1)=="P"){
                for (int a = 0; a<quantite; a++){
                    Team.getTeam(idTeam).removePNJ(Pnj.getPnj(id));
                }
            }else if (id.substring(0, 1)=="I"){
                for (int a = 0; a<quantite; a++){
                    Team.getTeam(idTeam).getInventaire().removeItem(Item.getItem(id));
                    //Ajout d'une quantité d'objets à l'inventaire de l'équipe donnée
                }
            }
        }else{
            System.out.println("Erreur ! Id de team est incorrect");
        }
    }

    public Enlever(Integer quantiteArgent){
        Team.getTeam("T0").removeArgent(quantiteArgent);
    }//Ajout d'une certaine quantité d'argent à l'équipe du joueur

    public Enlever(Integer quantiteArgent, String idTeam){
        if (idTeam.substring(0, 1)=="T"){
            Team.getTeam(idTeam).removeArgent(quantiteArgent);
        }else{
            System.out.println("Erreur ! Id de team est incorrect");
        }
    }//Ajout d'une certaine quantité d'argent à l'équipe donnée

}
