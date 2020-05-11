package GameData.Ressources.Contenu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Tileset {
    private String id;
    private String nomFichier;
    private Image tileset;
    private ArrayList<Tile> listeTiles = new ArrayList<>();

    public Tileset(String id, String nomFichier){
        this.id=id;
        this.nomFichier=nomFichier;
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Tilesets",nomFichier);
        tileset = new ImageIcon(cheminImage.toString()).getImage();
        ImageObserver observer = new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        };
        Integer compteur = 0;
        for (int a = 0; a<tileset.getHeight(observer)/16; a++){
            for (int b = 0; b<tileset.getWidth(observer)/16; b++){
                listeTiles.add(new Tile("T"+this.id.substring(1,id.length())+"-"+compteur,getImg(toBufferedImage(tileset),16,b,a)));
                compteur++;
            }
        }
    }

    private BufferedImage getImg(BufferedImage img, Integer taille, Integer x, Integer y) {
        BufferedImage newImg = img.getSubimage(16*x, 16*y, taille, taille);
        return newImg;
    }

    public Tile getTile(Integer position){
        return listeTiles.get(position);
    }

    public static BufferedImage toBufferedImage(Image img){
        if (img instanceof BufferedImage){
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }
}
