package GameData.Ressources.Contenu;


import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class Tile {
    private String id;
    private BufferedImage image;

    public Tile(String id, BufferedImage image) {
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

//    private Image getTile(Integer no){
//       Image tile;
//       return tile;
//    }
}
