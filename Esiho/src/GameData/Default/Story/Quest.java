package GameData.Default.Story;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.Pnj;

import java.util.ArrayList;

public abstract class Quest {
    private String id;//Id de quête, ex : Q14
    private String nomQuete;//Le nom de la quête, ex : Les cris dans la grotte
    private String description;//La description de la quête
    private boolean status;//L'état de la quête, false = pas terminée, true = terminée
    private ArrayList<Item> recompenseObjets;//La liste des objets à gagner
    private Integer recompenseOr;//La quantité d'or à gagner
    private Integer recompenseXp;//La quantité d'expérience à gagner

    public Quest(String id, String nomQuete, String description, ArrayList<Item> recompenseObjets, Integer recompenseOr, Integer recompenseXp){
        this.id=id;
        this.nomQuete=nomQuete;
        this.description=description;
        this.recompenseObjets=recompenseObjets;
        this.recompenseOr=recompenseOr;
        this.recompenseXp=recompenseXp;
        status=false;
    }

    public abstract void verifQuete();//Méthode abstraite qui vérifie si les conditions sont remplies pour terminer la quête.
                                     // ATTENTION, il faudra lancer la méthode win() pour appliquer les récompense et terminer la quête.

    private void win(Team equipe){
        for (Item objetGagné:recompenseObjets) {
            equipe.getInventaire().addItem(objetGagné);
        }
        equipe.addArgent(recompenseOr);
        for (Pnj pnj:equipe.getListePNJ()) {
            pnj.getEntite().addXp(recompenseXp/equipe.getListePNJ().size());
        }
        this.status=true;
    }//Méthode de victoire de l'équipe. À lancer dès que la quête est terminée.

}
