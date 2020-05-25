package GameData.Default.Items;

import GameData.Ressources.Contenu.InitContenu;
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

    public static Item getItem(String id){
        Item item;
        Integer idItem = 0;
        try{
            idItem = Integer.parseInt(id.substring(1));
        }catch (Exception erreur_transtypage_getItem){
            System.out.println("Erreur lors du transtypage de chaine de caractère en Integer à getItem");
        }
        switch (idItem){
            case 0:
                if (!isItemInArray(idItem)){
                    item = Item.epee();
                    InitContenu.listeItems.set(idItem, item);
                }else{
                    item = InitContenu.listeItems.get(idItem);
                }
                break;
            default:
                item = Item.epee();
        }
        return item;
    }

    public static Boolean isItemInArray(Integer position){
        try{
            Boolean exist = false;
            if (InitContenu.listeItems.get(position)!=null){
                exist=true;
            }
            return exist;
        }catch (Exception erreur_lecture_liste_tileset){
            System.out.println("Il y a eu une erreur dans la lecture de la liste des Tilesets.");
        }
        return null;
    }

    public static Arme epee(){
        Arme epee = new Arme("I3","Épée légendaire",500,5);
        return epee;
    }
}
