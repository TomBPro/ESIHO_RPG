package GameData.Ressources.Contenu;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class Tile {
    private String id;
    private Image image;

    public Tile(String id, Image image) {
        this.id = id;
        this.image = image;
    }

    public Tile(String id, BufferedImage img) {
        this.id = id;
        this.image = SwingFXUtils.toFXImage(img, null);
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

    public static Tile tileVide(){
        Tile tile = null;
        return tile;
    }
}
