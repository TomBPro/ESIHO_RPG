package GameData.Default.Items;

import java.awt.*;

public class Armure extends Item {//Ce type d'objet réfère aux objets à equiper donnant de l'armure
//    private String id;
//    private String nom;
//    private Integer valeur;
//    private javafx.scene.image.Image image;
    private Integer coeffProtection;

    public Armure(String id, String nom, Integer valeur, javafx.scene.image.Image image, Integer coeffProtection, String typeI){
        super(id,nom,valeur,image,typeI);
        this.coeffProtection=coeffProtection;
    }

    public Armure(String id, String nom, Integer valeur, Integer coeffProtection){
       super(id, nom, valeur);
        this.coeffProtection=coeffProtection;
    }

    public void useItem(){
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public Integer getValeur() {
//        return valeur;
//    }
//
//    public void setValeur(Integer valeur) {
//        this.valeur = valeur;
//    }
//
//    public javafx.scene.image.Image getImage() {
//        return image;
//    }
//
//    public void setImage(javafx.scene.image.Image image) {
//        this.image = image;
//    }

    public Integer getCoeffProtection() {
        return coeffProtection;
    }

    public void setCoeffProtection(Integer coeffProtection) {
        this.coeffProtection = coeffProtection;
    }

    //    public static Armure banale(){
//        Armure banale = new Armure("I5", "Armure banale", 100, "Armure.png", 2);
//        return banale;
//    }

    //    public static Armure legendaire(){
//        Armure leg = new Armure("I6", "Armure légendaire", 500, "Armure.png", 5);
//        return leg;
//    }
}
