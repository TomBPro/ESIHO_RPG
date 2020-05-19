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
import javafx.scene.image.Image;
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

    public static Pnj joueur(String nomJoueur){
        try{
            switch (nomJoueur) {
                case "P1":
                    ArrayList<Tile> listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
                    Image image = new Image("");
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
                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Moves Spe
                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Image
                            image
                    );
                    return new Pnj(nomJoueur , "Squellette", listeSprites, entity);

                case "P2":
                    listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
                    image = new Image("");
                    entity = new Entity(
                            //Lvl / xpmax / xp
                            3, 50, 0,
                            //Type
                            new Feu(),
                            //PV
                            new Pv(20, 20),
                            // Atk / Def / AtkSpe / DefSpe / Vitesse
                            2,2,2,2,2,
                            //Arme
                            new Arme("1","Epée",5,2),
                            //Armure
                            new Armure("2","Bouclier", 5, 2),
                            //Moves Phy
                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Moves Spe
                            new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Image
                            image
                    );
                    return new Pnj( nomJoueur, "Le Vieux Fou", listeSprites, entity);

                case "P3":
                    listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
                    image = new Image("");
                    entity = new Entity(
                            //Lvl / xpmax / xp
                            1, 50, 0,
                            //Type
                            new Feu(),
                            //PV
                            new Pv(15, 15),
                            // Atk / Def / AtkSpe / DefSpe / Vitesse
                            1,1,1,1,1,
                            //Arme

                            //Armure

                            //Moves Phy
                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Moves Spe
                            new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Image
                            image
                    );
                    return new Pnj( nomJoueur, "Petit Diable", listeSprites, entity);

                case "P4":
                    listeSprites = Pnj.joueur("Maurice").getListeSprites(); //On récupère la liste de sprites
                    image = new Image("");
                    entity = new Entity(
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
                            new MoveList(new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Moves Spe
                            new MoveList(new Move("1", "Test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu()), new Move("1", "test", "Genre", new Feu())),
                            //Image
                            image
                    );
                    return new Pnj( nomJoueur, "Rat", listeSprites, entity);

//            case "P5":
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
            }



        }catch (Exception E){
            System.out.print("error");

        }
        return null;
    }}

