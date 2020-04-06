package GameData.Default.Items;

import java.awt.*;

public class Arme extends Item{//Ce type d'objet réfère aux objets servant d'armes à équiper
    private String id;
    private String nom;
    private Integer valeur;
    private Image image;
    private Integer coeffDegats;

    public Arme(String id, String nom, Integer valeur, Image image, Integer coeffDegats){
        this.id=id;
        this.nom=nom;
        this.valeur=valeur;
        this.image=image;
        this.coeffDegats=coeffDegats;
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

    public Integer getCoeffDegats() {
        return coeffDegats;
    }

    public void setCoeffDegats(Integer coeffDegats) {
        this.coeffDegats = coeffDegats;
    }
}
