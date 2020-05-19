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

import java.awt.*;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.swing.*;
import java.awt.image.ImageObserver;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Pnj {
    private String id;
    private String nom;
    private ArrayList<Tile> listeSprites;
    private Entity entite;

    public Pnj(){
        //Pnj vide
    }

    public Pnj(String id, String nom, ArrayList<Tile> listeSprites, Entity entite) {
        this.id = id;
        this.nom = nom;
        this.listeSprites = listeSprites;
        this.entite = entite;
    }

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
                    pnj = Pnj.joueur("Maurice");
                    break;
                case 1:
                    pnj = Pnj.squelette(); //Faire les autres comme ici, en faisant chacun leur fonction statique comme le squelette
                    break;
//                case 2:
//                    listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
//                    image = new Image("");
//                    entity = new Entity(
//                            //Lvl / xpmax / xp
//                            3, 50, 0,
//                            //Type
//                            new Feu(),
//                            //PV
//                            new Pv(20, 20),
//                            // Atk / Def / AtkSpe / DefSpe / Vitesse
//                            2,2,2,2,2,
//                            //Arme
//                            new Arme("1","Epée",5,2),
//                            //Armure
//                            new Armure("2","Bouclier", 5, 2),
//                            //Moves Phy
//                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                            //Moves Spe
//                            new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                            //Image
//                            image
//                    );
//                    return new Pnj(idPnj, "Le Vieux Fou", listeSprites, entity);
//
//                case 3:
//                    listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
//                    image = new Image("");
//                    entity = new Entity(
//                            //Lvl / xpmax / xp
//                            1, 50, 0,
//                            //Type
//                            new Feu(),
//                            //PV
//                            new Pv(15, 15),
//                            // Atk / Def / AtkSpe / DefSpe / Vitesse
//                            1,1,1,1,1,
//                            //Arme
//
//                            //Armure
//
//                            //Moves Phy
//                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                            //Moves Spe
//                            new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                            //Image
//                            image
//                    );
//                    return new Pnj(idPnj, "Petit Diable", listeSprites, entity);
//
//                case 4:
//                    listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
//                    image = new Image("");
//                    entity = new Entity(
//                            //Lvl / xpmax / xp
//                            1, 50, 0,
//                            //Type
//                            new Feu(),
//                            //PV
//                            new Pv(10, 10),
//                            // Atk / Def / AtkSpe / DefSpe / Vitesse
//                            1,1,1,1,1,
//                            //Arme
//
//                            //Armure
//
//                            //Moves Phy
//                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                            //Moves Spe
//                            new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                            //Image
//                            image
//                    );
//                    return new Pnj(idPnj, "Rat", listeSprites, entity);

//            case 5:
//                listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
//                image = new Image("");
//                entity = new Entity(
//                        //Lvl / xpmax / xp
//                        1, 50, 0,
//                        //Type
//                        new Feu(),
//                        //PV
//                        new Pv(10, 10),
//                        // Atk / Def / AtkSpe / DefSpe / Vitesse
//                        1,1,1,1,1,
//                        //Arme
//
//                        //Armure
//
//                        //Moves Phy
//                        new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                        //Moves Spe
//                        new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
//                        //Image
//                        image
//                );
//                return new Pnj( nomJoueur, "Rat", listeSprites, entity);
                default:
                    pnj = Pnj.joueur("Maurice");
            }
            return pnj;
        }catch (Exception E){
            System.out.print("error");

        }
        return null;
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
        Pnj pnj = new Pnj("P0" , "Joueur", listeSprites, entity);
        return pnj;
    }

    public static Pnj squelette(){
        ArrayList<Tile> listeSprites = Tileset.getTileset(1, "SPRITE").getListeSprites().get(1); //On récupère la liste de sprites
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Images","Entities","PersoRPG","Chevalier Combat.png");
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
        Pnj pnj = new Pnj("P1", "Squelette", listeSprites, entity);
        return pnj;
    }
}

