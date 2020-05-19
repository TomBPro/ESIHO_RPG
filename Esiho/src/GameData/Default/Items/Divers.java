package GameData.Default.Items;

import java.awt.*;

public class Divers extends Item{//Ce type d'objet réfère aux objets sans fonctions
//    private String id;
//    private String nom;
//    private Integer valeur;
//    private javafx.scene.image.Image image;

    public Divers(String id, String nom, Integer valeur, javafx.scene.image.Image image){
        super(id,nom,valeur,image);
        super.setTypeI("DIVERS");
    }

    public Divers(String id, String nom, Integer valeur){
        super(id,nom,valeur);
        super.setTypeI("DIVERS");
    }

    public void useItem(){
        //À compléter
        //Faire un envoi de message comme quoi ça ne s'utilise pas
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

//    public static Divers balle(){
//        Divers balle = new Divers("I10", "balle", 200, "x"));
//        return balle;
//    }

//    public static Divers queue(){
//        Divers queue = new Divers("I9", "queue de rat", 50, "x"));
//        return queue;
//    }

      public String getTypeI(){
        return super.getTypeI();
      }
}
