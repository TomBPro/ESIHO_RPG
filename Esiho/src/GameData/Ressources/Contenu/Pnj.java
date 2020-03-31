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
}
