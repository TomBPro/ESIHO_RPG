package GameData.Ressources.Contenu;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class Tile {
    private String id;
    private Image image;
    private Boolean collision;

    public Tile(String id, Image image) {
        this.id = id;
        this.image = image;
        this.collision = false;
    }

    public Tile(String id, BufferedImage img) {
        this.id = id;
        this.image = SwingFXUtils.toFXImage(img, null);
        this.collision = false;
    }

    public Tile(String id, Boolean collision) {
        this.id = id;
        this.collision = collision;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

//    public static Tile tileVide(){
//        Tile tile = null;
//        return tile;
//    }


    public void setCollision(Boolean collision) {
        this.collision = collision;
    }

    public Boolean getCollision() {
        return collision;
    }
}
