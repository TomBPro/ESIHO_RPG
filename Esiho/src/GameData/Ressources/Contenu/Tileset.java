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

//    public static Tileset getTileset(Integer id){
//        Tileset ts;
//        switch (id){
//            case 0 :
//                ts = getTileset0();
//            case 1 :
//                ts = getTileset1();
//            case 2 :
//                ts = getTileset2();
//            case 3 :
//                ts = getTileset3();
//            case 4 :
//                ts = getTileset4();
//            case 5 :
//                ts = getTileset5();
//            case 6 :
//                ts = getTileset6();
//            case 7 :
//                ts = getTileset7();
//            case 8 :
//                ts = getTileset8();
//            case 9 :
//                ts = getTileset9();
//            case 10 :
//                ts = getTileset10();
//            case 11 :
//                ts = getTileset11();
//            case 12 :
//                ts = getTileset12();
//            case 13 :
//                ts = getTileset13();
//            case 14 :
//                ts = getTileset14();
//            case 15 :
//                ts = getTileset15();
//            case 16 :
//                ts = getTileset16();
//            case 17 :
//                ts = getTileset17();
//            case 18 :
//                ts = getTileset18();
//            case 19 :
//                ts = getTileset19();
//            case 20 :
//                ts = getTileset20();
//            case 21 :
//                ts = getTileset21();
//            default:
//                ts = getTileset0();
//        }
//        return ts;
//    }
//
//    protected static Tileset getTileset0(){
//        Tileset ts = new Tileset("Z0","Outside_A1.png");
//        return ts;
//    }
//
//    private static Tileset getTileset1(){
//        Tileset ts = new Tileset("Z1","Outside_A2.png");
//        return ts;
//    }
//
//    private static Tileset getTileset2(){
//        Tileset ts = new Tileset("Z2","Outside_A3.png");
//        return ts;
//    }
//
//    private static Tileset getTileset3(){
//        Tileset ts = new Tileset("Z3","Outside_A4.png");
//        return ts;
//    }
//
//    private static Tileset getTileset4(){
//        Tileset ts = new Tileset("Z4","Outside_A5.png");
//        return ts;
//    }
//
//    private static Tileset getTileset5(){
//        Tileset ts = new Tileset("Z5","Outside_B.png");
//        return ts;
//    }
//
//    private static Tileset getTileset6(){
//        Tileset ts = new Tileset("Z6","Outside_C.png");
//        return ts;
//    }
//
//    private static Tileset getTileset7(){
//        Tileset ts = new Tileset("Z7","Inside_A1.png");
//        return ts;
//    }
//
//    private static Tileset getTileset8(){
//        Tileset ts = new Tileset("Z8","Inside_A2.png");
//        return ts;
//    }
//
//    private static Tileset getTileset9(){
//        Tileset ts = new Tileset("Z9","Inside_A4.png");
//        return ts;
//    }
//
//    private static Tileset getTileset10(){
//        Tileset ts = new Tileset("Z10","Inside_A5.png");
//        return ts;
//    }
//
//    private static Tileset getTileset11(){
//        Tileset ts = new Tileset("Z11","Inside_B.png");
//        return ts;
//    }
//
//    private static Tileset getTileset12(){
//        Tileset ts = new Tileset("Z12","Inside_C.png");
//        return ts;
//    }
//
//    private static Tileset getTileset13(){
//        Tileset ts = new Tileset("Z13","Dungeon_A1.png");
//        return ts;
//    }
//
//    private static Tileset getTileset14(){
//        Tileset ts = new Tileset("Z14","Dungeon_A2.png");
//        return ts;
//    }
//
//    private static Tileset getTileset15(){
//        Tileset ts = new Tileset("Z15","Dungeon_A4.png");
//        return ts;
//    }
//
//    private static Tileset getTileset16(){
//        Tileset ts = new Tileset("Z16","Dungeon_A5.png");
//        return ts;
//    }
//
//    private static Tileset getTileset17(){
//        Tileset ts = new Tileset("Z17","Dungeon_B.png");
//        return ts;
//    }
//
//    private static Tileset getTileset18(){
//        Tileset ts = new Tileset("Z18","Dungeon_C.png");
//        return ts;
//    }
//
//    private static Tileset getTileset19(){
//        Tileset ts = new Tileset("Z19","World_A1.png");
//        return ts;
//    }
//
//    private static Tileset getTileset20(){
//        Tileset ts = new Tileset("Z20","World_A2.png");
//        return ts;
//    }
//
//    private static Tileset getTileset21(){
//        Tileset ts = new Tileset("Z21","World_B.png");
//        return ts;
//    }
}
