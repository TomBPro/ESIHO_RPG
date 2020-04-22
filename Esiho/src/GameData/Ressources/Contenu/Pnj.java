package GameData.Ressources.Contenu;

import GameData.Combat.Entities.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Pnj {
    private String id;
    private String nom;
    private ArrayList<Image> listeImage;
    private Entity entite;

    public Pnj(){
        //Pnj vide
    }

    public Pnj(String id, String nom, ArrayList<Image> image, Entity entite) {
        this.id = id;
        this.nom = nom;
        this.listeImage = image;
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

    public ArrayList<Image> getListeImage() {
        return listeImage;
    }

    public void setListeImage(ArrayList<Image> image) {
        this.listeImage = image;
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
}
