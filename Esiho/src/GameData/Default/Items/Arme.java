package GameData.Default.Items;

import javafx.scene.image.Image;

import java.awt.*;

public class Arme extends Item{//Ce type d'objet réfère aux objets servant d'armes à équiper
    private String id;
    private String nom;
    private Integer valeur;
    private javafx.scene.image.Image image;
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

    public javafx.scene.image.Image getImage() {
        return image;
    }

    public void setImage(javafx.scene.image.Image image) {
        this.image = image;
    }

    public Integer getCoeffDegats() {
        return coeffDegats;
    }

    public void setCoeffDegats(Integer coeffDegats) {
        this.coeffDegats = coeffDegats;
    }

//    public static Arme baton(){
//        Arme baton = new Arme("I1","Baton",100, "Baton.png", 1);
//        return baton;
//    }

//    public static Arme dague(){
//        Arme dague = new Arme("I2","dague",250, "Dague.png", 3);
//        return dague;
//    }

//    public static Arme epee(){
//        Arme epee = new Arme("I3","epee légendaire",500, "Epee.png", 5);
//        return epee;
//    }

//    public static Arme arc(){
//        Arme arc = new Arme("I4","arc",300, "Arc.png", 4);
//        return arc;
//    }
}
