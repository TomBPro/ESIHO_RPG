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

    public static Tileset getTileset(Integer id){
        Tileset ts = new Tileset("Z0", "Outside_A1.png");
        try{
            switch (id){
                case 0 :
                    if (!isTilesetInArray(0)){
                        ts = new Tileset("Z0","Outside_A1.png");
                        InitContenu.listeTileset.set(0, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(0);
                    }
                    break;
                case 1 :
                    if (!isTilesetInArray(1)){
                        ts = new Tileset("Z1","Outside_A2.png");
                        InitContenu.listeTileset.set(1, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(1);
                    }
                    break;
                case 2 :
                    if (!isTilesetInArray(2)){
                        ts = new Tileset("Z2","Outside_A3.png");
                        InitContenu.listeTileset.set(2, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(2);
                    }
                    break;
                case 3 :
                    if (!isTilesetInArray(3)){
                        ts = new Tileset("Z3","Outside_A4.png");
                        InitContenu.listeTileset.set(3, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(3);
                    }
                    break;
                case 4 :
                    if (!isTilesetInArray(4)){
                        ts = new Tileset("Z4","Outside_A5.png");
                        InitContenu.listeTileset.set(4, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(4);
                    }
                    break;
                case 5 :
                    if (!isTilesetInArray(5)){
                        ts = new Tileset("Z5","Outside_B.png");
                        InitContenu.listeTileset.set(5, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(5);
                    }
                    break;
                case 6 :
                    if (!isTilesetInArray(6)){
                        ts = new Tileset("Z6","Outside_C.png");
                        InitContenu.listeTileset.set(6, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(6);
                    }
                    break;
                case 7 :
                    if (!isTilesetInArray(7)){
                        ts = new Tileset("Z7","Inside_A1.png");
                        InitContenu.listeTileset.set(7, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(7);
                    }
                    break;
                case 8 :
                    if (!isTilesetInArray(8)){
                        ts = new Tileset("Z8","Inside_A2.png");
                        InitContenu.listeTileset.set(8, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(8);
                    }
                    break;
                case 9 :
                    if (!isTilesetInArray(9)){
                        ts = new Tileset("Z9","Inside_A4.png");
                        InitContenu.listeTileset.set(9, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(9);
                    }
                    break;
                case 10 :
                    if (!isTilesetInArray(10)){
                        ts = new Tileset("Z10","Inside_A5.png");
                        InitContenu.listeTileset.set(10, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(10);
                    }
                    break;
                case 11 :
                    if (!isTilesetInArray(11)){
                        ts = new Tileset("Z11","Inside_B.png");
                        InitContenu.listeTileset.set(11, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(11);
                    }
                    break;
                case 12 :
                    if (!isTilesetInArray(12)){
                        ts = new Tileset("Z12","Inside_C.png");
                        InitContenu.listeTileset.set(12, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(12);
                    }
                    break;
                case 13 :
                    if (!isTilesetInArray(13)){
                        ts = new Tileset("Z13","Dungeon_A1.png");
                        InitContenu.listeTileset.set(13, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(13);
                    }
                    break;
                case 14 :
                    if (!isTilesetInArray(14)){
                        ts = new Tileset("Z14","Dungeon_A2.png");
                        InitContenu.listeTileset.set(14, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(14);
                    }
                    break;
                case 15 :
                    if (!isTilesetInArray(15)){
                        ts = new Tileset("Z15","Dungeon_A4.png");
                        InitContenu.listeTileset.set(15, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(15);
                    }
                    break;
                case 16 :
                    if (!isTilesetInArray(16)){
                        ts = new Tileset("Z16","Dungeon_A5.png");
                        InitContenu.listeTileset.set(16, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(16);
                    }
                    break;
                case 17 :
                    if (!isTilesetInArray(17)){
                        ts = new Tileset("Z17","Dungeon_B.png");
                        InitContenu.listeTileset.set(17, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(17);
                    }
                    break;
                case 18 :
                    if (!isTilesetInArray(18)){
                        ts = new Tileset("Z18","Dungeon_C.png");
                        InitContenu.listeTileset.set(18, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(18);
                    }
                    break;
                case 19 :
                    if (!isTilesetInArray(19)){
                        ts = new Tileset("Z19","World_A1.png");
                        InitContenu.listeTileset.set(19, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(19);
                    }
                    break;
                case 20 :
                    if (!isTilesetInArray(20)){
                        ts = new Tileset("Z20","World_A2.png");
                        InitContenu.listeTileset.set(20, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(20);
                    }
                    break;
                case 21 :
                    if (!isTilesetInArray(21)){
                        ts = new Tileset("Z21","World_B.png");
                        InitContenu.listeTileset.set(21, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(21);
                    }
                    break;
                default:
                    if (!isTilesetInArray(0)){
                        ts = new Tileset("Z0","Outside_A1.png");
                        InitContenu.listeTileset.set(0, ts);
                    }else{
                        ts = InitContenu.listeTileset.get(0);
                    }
            }
        }catch (Exception erreur_declaration_Tileset){
            System.out.println("Un Tileset n'a pas pu être déclaré");
        }

        return ts;
    }

    public static Boolean isTilesetInArray(Integer position){
        try{
            Boolean exist = false;
            if (InitContenu.listeTileset.get(position)!=null){
                exist=true;
            }
            return exist;
        }catch (Exception erreur_lecture_liste_tileset){
            System.out.println("Il y a eu une erreur dans la lecture de la liste des Tilesets.");
        }
        return null;
    }

    public String getId() {
        return id;
    }
}
