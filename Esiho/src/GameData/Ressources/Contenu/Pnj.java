package GameData.Ressources.Contenu;

import GameData.Combat.Entities.Entity;
import GameData.Combat.Entities.Pv;
import GameData.Combat.Moves.Move;
import GameData.Combat.Moves.MoveList;
import GameData.Combat.Types.Feu;
import GameData.Combat.Types.Plante;
import GameData.Combat.Types.Types;
import GameData.Default.Items.Arme;
import GameData.Default.Items.Armure;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.image.ImageObserver;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Pnj {
    private String id;
    private String nom;
    private ArrayList<Tile> listeSprites;
    private Entity entite;
    private Integer angleX;
    private Integer angleY;

    public Pnj(){
        //Pnj vide
    }

    public Pnj(String id, String nom, ArrayList<Tile> listeSprites, Entity entite) {
        this.id = id;
        this.nom = nom;
        this.listeSprites = listeSprites;
        this.entite = entite;
    }

    public abstract void interract();

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

    public ArrayList<Tile> getListeSprites() {
        return this.listeSprites;
    }

    public void setListeImage(ArrayList<Tile> listSprites) {
        this.listeSprites = listSprites;
    }

    public Entity getEntite() {
        return entite;
    }

    public void setEntite(Entity entite) {
        this.entite = entite;
    }

    public void sethpmax(int i) {
        this.entite.getPV().setPvmax(i);
    }

    public void setAtk(int i) {
        this.entite.setAtt(i);
    }

    public void setDef(int i) {
        this.entite.setDef(i);
    }

    public void setAtkSpe(int i) {
        this.entite.setAttspe(i);
    }

    public void setDefSpe(int i) {
        this.entite.setDefspe(i);
    }

    public void setVitesse(int i) {
        this.entite.setVitesse(i);
    }

    public void setLvl(int i) {
        this.entite.setLvl(i);
    }

    public static Pnj getPnj(String idPnj){
        try{
            Integer id = 0;
            try{
                id = Integer.parseInt(idPnj.substring(1));
            }catch (Exception erreur_transtypage){
                System.out.println("Erreur de transtypage dans Pnj.getPnj()");
            }
            Pnj pnj;

            switch (id) {
                case 0:
                    if (!isPNJInArray(id)){
                        pnj = Pnj.joueur("Maurice");
                        InitContenu.listePnjs.set(id, pnj);
                    }else{
                        pnj = InitContenu.listePnjs.get(id);
                    }
                    break;
                case 1:

                    if (!isPNJInArray(id)){
                        pnj = Pnj.squelette();
                        InitContenu.listePnjs.set(id, pnj);
                    }else{
                        pnj = InitContenu.listePnjs.get(id);
                    }
                    break;
                case 2:
                    if (!isPNJInArray(id)){
                        pnj = Pnj.petiDiable();
                        InitContenu.listePnjs.set(id, pnj);
                    }else{
                        pnj = InitContenu.listePnjs.get(id);
                    }
                    break;

                case 3:
                    if (!isPNJInArray(id)){
                        pnj = Pnj.rat();
                        InitContenu.listePnjs.set(id, pnj);
                    }else{
                        pnj = InitContenu.listePnjs.get(id);
                    }
                    break;

                case 4:
                    if (!isPNJInArray(id)){
                        pnj = Pnj.vieuxFou();
                        InitContenu.listePnjs.set(id, pnj);
                    }else{
                        pnj = InitContenu.listePnjs.get(id);
                    }
                    break;

                default:
                    pnj = Pnj.joueur("Maurice");
            }
            return pnj;
        }catch (Exception E){
            System.out.print("error");

        }
        return null;
    }

    public static boolean isPNJInArray(Integer position){
        try{
            boolean exist = false;
            if (InitContenu.listePnjs.get(position)!=null){
                exist=true;
            }
            return exist;
        }catch (Exception erreur_lecture_liste_tileset){
            System.out.println("Il y a eu une erreur dans la lecture de la liste des PNJs. : " + erreur_lecture_liste_tileset);

        }
        return false;
    }

    public static Pnj joueur(String nomJoueur){
        Tileset a = InitContenu.listeSpriteset.get(0);
        ArrayList<Tile> listeSprites = Tileset.getTileset(0, "SPRITE").getListeSprites().get(0); //On récupère la liste de sprites
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Entities","PersoRPG","Archer.png");
        Image image = SwingFXUtils.toFXImage(Tileset.toBufferedImage(new ImageIcon(cheminImage.toString()).getImage()), null);//Convertit du awt en javafx
        Entity entity = new Entity(
                1, 50, 0,
                new Feu(),
                new Pv(10, 10),
                50, 40,40,50,50,
                new MoveList(Move.lameFeu(), Move.coupPoing(), Move.coupEpee(), Move.lameEau()),
                new MoveList(Move.flecheFeu(), Move.cannonEau(), Move.feuillesLancer(), Move.flecheEpines()),
                image
        );
        Pnj pnj = new Pnj("P0", "Joueur", listeSprites, entity) {
            @Override
            public void interract() {
                //RIEN
            }
        };
        return pnj;
    }

    public static Pnj squelette(){
        ArrayList<Tile> listeSprites = Tileset.getTileset(1, "SPRITE").getListeSprites().get(1); //On récupère la liste de sprites
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Entities","PersoRPG","Chevalier_Combat.png");
        Image image = SwingFXUtils.toFXImage(Tileset.toBufferedImage(new ImageIcon(cheminImage.toString()).getImage()), null);//Convertit du awt en javafx
        Entity entity = new Entity(
                //Lvl / xpmax / xp
                1, 50, 0,
                //Type
                new Feu(),
                //PV
                new Pv(10, 10),
                // Atk / Def / AtkSpe / DefSpe / Vitesse
                1, 1,1,1,1,
                //Arme

                //Armure

                //Moves Phy
                new MoveList(Move.coupEpee()),
                //Moves Spe
                new MoveList(Move.tirFleche()),
                //Image
                image
        );
        Pnj pnj = new Pnj("P1", "Squelette", listeSprites, entity) {
            @Override
            public void interract() {
                System.out.println("Vous venez de parler au "+this.getNom());
            }
        };
        return pnj;
    }

    public static Pnj petiDiable(){
        ArrayList<Tile> listeSprites = Tileset.getTileset(1, "SPRITE").getListeSprites().get(1); //On récupère la liste de sprites
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Entities","PersoRPG","Chevalier_Combat.png");
        Image image = SwingFXUtils.toFXImage(Tileset.toBufferedImage(new ImageIcon(cheminImage.toString()).getImage()), null);//Convertit du awt en javafx
        Entity entity = new Entity(
                //Lvl / xpmax / xp
                1, 50, 0,
                //Type
                new Feu(),
                //PV
                new Pv(10, 10),
                // Atk / Def / AtkSpe / DefSpe / Vitesse
                1,1,1,1,1,
                //Arme

                //Armure

                //Moves Phy
                new MoveList(Move.coupEpee()),
                //Moves Spe
                new MoveList(Move.tirFleche()),
                //Image
                image
        );
        Pnj pnj = new Pnj("P2", "Petit Diable", listeSprites, entity) {
            @Override
            public void interract() {
                System.out.println("Vous venez de parler au "+this.getNom());
            }
        };
        return pnj;
    }

    public static Pnj rat(){
        ArrayList<Tile> listeSprites = Tileset.getTileset(1, "SPRITE").getListeSprites().get(1); //On récupère la liste de sprites
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Entities","PersoRPG","Chevalier_Combat.png");
        Image image = SwingFXUtils.toFXImage(Tileset.toBufferedImage(new ImageIcon(cheminImage.toString()).getImage()), null);//Convertit du awt en javafx
        Entity entity = new Entity(
                            //Lvl / xpmax / xp
                            1, 50, 0,
                            //Type
                            new Feu(),
                            //PV
                            new Pv(10, 10),
                            // Atk / Def / AtkSpe / DefSpe / Vitesse
                            1,1,1,1,1,
                            //Arme

                            //Armure

                            //Moves Phy
                            new MoveList(Move.coupEpee()),
                            //Moves Spe
                             new MoveList(Move.tirFleche()),
                            //Image
                            image
                    );
        Pnj pnj = new Pnj("P3", "Rat", listeSprites, entity) {
            @Override
            public void interract() {
                System.out.println("Vous venez de parler au "+this.getNom());
            }
        };
        return pnj;
    }

    public static Pnj vieuxFou(){
        ArrayList<Tile> listeSprites = Tileset.getTileset(1, "SPRITE").getListeSprites().get(1); //On récupère la liste de sprites
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Entities","PersoRPG","Chevalier_Combat.png");
        Image image = SwingFXUtils.toFXImage(Tileset.toBufferedImage(new ImageIcon(cheminImage.toString()).getImage()), null);//Convertit du awt en javafx
        Entity entity = new Entity(
                //Lvl / xpmax / xp
                1, 50, 0,
                //Type
                new Feu(),
                //PV
                new Pv(10, 10),
                // Atk / Def / AtkSpe / DefSpe / Vitesse
                1,1,1,1,1,
                //Arme

                //Armure

                //Moves Phy
                new MoveList(Move.coupEpee()),
                //Moves Spe
                new MoveList(Move.tirFleche()),
                //Image
                image
        );
        Pnj pnj = new Pnj("P4", "Vieux Fou", listeSprites, entity) {
            @Override
            public void interract() {
                System.out.println("Vous venez de parler au "+this.getNom());
            }
        };
        return pnj;
    }

    public void setAngle(Integer angleX, Integer angleY) {
        this.angleX = angleX;
        this.angleY = angleY;
    }

    public Integer getAngleX() {
        return angleX;
    }

    public Integer getAngleY() {
        return angleY;
    }
}

