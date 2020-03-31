package GameData.Combat.Entities;

import GameData.Default.Inventaire;
import GameData.Ressources.Contenu.Pnj;

import java.util.ArrayList;

public class Team {
    private String id;
    private ArrayList<Pnj> listePNJ;
    private Inventaire inventaire;
    private Integer argent;

    public Team(String id, Integer argent){
        this.id=id;
        this.argent=argent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addPNJ(Pnj pnjAjoute){
        this.listePNJ.add(pnjAjoute);
    }

    public void removePNJ(Pnj pnjEnleve){
        this.listePNJ.remove(pnjEnleve);
    }

    public Inventaire getInventaire(){
        return inventaire;
    }

    public ArrayList<Pnj> getListePNJ() {
        return listePNJ;
    }

    public void addArgent(Integer argentAjoutee){
        this.argent+=argentAjoutee;
    }

    public void removeArgent(Integer argentRetiree){
        if (this.argent-argentRetiree>=0){//Si le résultat de la déduction est supérieur ou égal à zero
            this.argent-=argentRetiree;
        }/*S'il n'y a pas assez d'argent pour en déduire*/else{
            this.argent=0;
        }
    }

    public Integer getArgent(){
        return this.argent;
    }
}
