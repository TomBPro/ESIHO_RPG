package GameData.Default.Items;

import GameData.Ressources.Contenu.Pnj;

import java.awt.*;

public abstract class Consommable extends Item {//Ce type d'objet réfère aux objets qui s'utilisent une fois et font des choses (ex : Potions, nourriture, etc)
//    private String id;
//    private String nom;
//    private Integer valeur;
//    private javafx.scene.image.Image image;
    private Integer type;

    public Consommable(String id, String nom, Integer valeur, javafx.scene.image.Image image, Integer type){
        super(id,nom,valeur,image);
        this.type=type;
        super.setTypeI("CONSOMMABLE");
    }

    public Consommable(String id, String nom, Integer valeur, Integer type){
        super(id,nom,valeur);
        this.type=type;
        super.setTypeI("CONSOMMABLE");
    }

    public abstract void useItem(Pnj pnj, Integer val)//Ce champ sera rempli lorsqu'un Consommable sera initialisé, mais pas lorsqu'il sera utilisé
    ;


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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeI(){
        return super.getTypeI();
    }

//    public static Consommable vie(){
//        Consommable vie = new Consommable("I7", "Potion de vie", 100, "Potion de vie .png", 1);
//        @Override
//        public void useItem() {
//
//            }
//
//            @Override
//            public void useItem(Pnj pnj, Integer val) {
//                if(this.getType()==1){
//                    //Soigner
//                    pnj.getEntite().getPV().addPv(val);
//                }else if (this.getType() == 2){
//                    //Degats
//                    pnj.getEntite().getPV().removePv(val);
//                }
//            }
//        return vie;
//    }

//    public static Consommable degats(){
//        Consommable degats = new Consommable("I8", "Potion de dégâts", 100, "Potion de dégat.png", 2);
//        @Override
//        public void useItem() {
//
//            }
//
//            @Override
//            public void useItem(Pnj pnj, Integer val) {
//                if(this.getType()==1){
//                    //Soigner
//                    pnj.getEntite().getPV().addPv(val);
//                }else if (this.getType() == 2){
//                    //Degats
//                    pnj.getEntite().getPV().removePv(val);
//                }
//            }
//        return degats;
//    }
}
