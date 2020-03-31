package GameData.Ressources.Contenu;


import javafx.scene.image.Image;

public class Decor {
    private String id;
    private Image image;

    public Decor(String id, Image image) {
        this.id = id;
        this.image = image;
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
}
