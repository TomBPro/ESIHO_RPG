package GameData.Default.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Item {
    private String id;
    private String nom;
    private Integer valeur;
    private javafx.scene.image.Image image;

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
