package GameData.Default.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public abstract class Item {
    private String id;
    private String nom;
    private Integer valeur;
    private javafx.scene.image.Image image;
    private String typeI;

    public Item(String id, String nom, Integer valeur, Image image) {
        this.id = id;
        this.nom = nom;
        this.valeur = valeur;
        this.image = image;
    }

    public Item(String id, String nom, Integer valeur) {
        this.id = id;
        this.nom = nom;
        this.valeur = valeur;
    }


    public abstract void useItem();

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

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public javafx.scene.image.Image getImage() {
        return image;
    }

    public void setImage(javafx.scene.image.Image image) {
        this.image = image;
    }

    public String getTypeI() {
        return typeI;
    }

    public void setTypeI(String typeI) {
        this.typeI = typeI;
    }

    public static Arme epee(){
        Arme epee = new Arme("I3","Épée légendaire",500,5);
        return epee;
    }
}
