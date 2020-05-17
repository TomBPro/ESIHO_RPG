package GameData.Ressources.Contenu;

import GameData.Combat.Entities.Entity;
import GameData.Combat.Entities.Pv;
import GameData.Combat.Moves.Move;
import GameData.Combat.Moves.MoveList;
import GameData.Combat.Types.Feu;
import GameData.Combat.Types.Plante;
import GameData.Combat.Types.Types;
import GameData.Default.Items.Arme;
import GameData.Default.Items.Armure;
import javafx.embed.swing.SwingFXUtils;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Pnj {
    private String id;
    private String nom;
    private ArrayList<Tile> listeSprites;
    private Entity entite;

    public Pnj(){
        //Pnj vide
    }

    public Pnj(String id, String nom, ArrayList<Tile> listeSprites, Entity entite) {
        this.id = id;
        this.nom = nom;
        this.listeSprites = listeSprites;
        this.entite = entite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Tile> getListeSprites() {
        return this.listeSprites;
    }

    public void setListeImage(ArrayList<Tile> listSprites) {
        this.listeSprites = listSprites;
    }

    public Entity getEntite() {
        return entite;
    }

    public void setEntite(Entity entite) {
        this.entite = entite;
    }

    public void sethpmax(int i) {
        this.entite.getPV().setPvmax(i);
    }

    public void setAtk(int i) {
        this.entite.setAtt(i);
    }

    public void setDef(int i) {
        this.entite.setDef(i);
    }

    public void setAtkSpe(int i) {
        this.entite.setAttspe(i);
    }

    public void setDefSpe(int i) {
        this.entite.setDefspe(i);
    }

    public void setVitesse(int i) {
        this.entite.setVitesse(i);
    }

    public void setLvl(int i) {
        this.entite.setLvl(i);
    }

    public static Pnj joueur(String nomJoueur){
        Types typeFeu = new Feu();
        Plante typePlante = new Plante();
        Pv pv = new Pv(10,10);
        MoveList movesPhy = new MoveList(Move.lameFeu(),Move.coupPoing(),Move.coupEpee(),Move.coupPoing());
        MoveList movesSpe = new MoveList(Move.flecheFeu(),Move.flecheFeu(),Move.flecheFeu(),Move.flecheFeu());
        Arme arme = new Arme("1","Epée",5,2);
        Armure armure = new Armure("2","Bouclier", 5 , 2);
        Entity entity = new Entity("1","Squelette",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy);
        Tileset tileset = Tileset.getTileset(0, "SPRITE");
        ArrayList<Tile> listeSprites = tileset.getListeSprites().get(0);
        Pnj pnj = new Pnj("P0", nomJoueur, listeSprites, entity);
        return pnj;
    }
}
