package GameData.Default.Items;

import java.awt.*;

public class Armure extends Item {//Ce type d'objet réfère aux objets à equiper donnant de l'armure
    private String id;
    private String nom;
    private Integer valeur;
    private Image image;
    private Integer coeffProtection;

    public Armure(String id, String nom, Integer valeur, Image image, Integer coeffProtection){
        this.id=id;
        this.nom=nom;
        this.valeur=valeur;
        this.image=image;
        this.coeffProtection=coeffProtection;
    }

    public void useItem(){
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

    public Integer getCoeffProtection() {
        return coeffProtection;
    }

    public void setCoeffProtection(Integer coeffProtection) {
        this.coeffProtection = coeffProtection;
    }
}
