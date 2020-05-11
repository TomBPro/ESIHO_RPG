package GameData.Ressources.Contenu;

import GameData.Combat.Entities.Entity;
import GameData.Combat.Entities.Pv;
import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.Move;
import GameData.Combat.Moves.MoveList;
import GameData.Combat.Types.*;
import GameData.Default.Items.Arme;
import GameData.Default.Items.Armure;
import GameData.Default.Items.Consommable;
import GameData.Default.Items.Item;
import GameData.Default.Story.Quest;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class InitContenu {//Cette classe contiendra toutes les initialisations de map, d'items, de pnj, d'entités, etc.
    private ArrayList<Pnj> listePnjs;
    private ArrayList<Item> listeItems;
    private ArrayList<Team> listeTeams;
    private ArrayList<Quest> listeQuetes;
    public static ArrayList<Tileset> listeTileset = new ArrayList<>();

    public InitContenu() {
	    initPnjs();
	    initItems();
	    initTeams();
	    initQuetes();
	    initTilesets();
    }

    private void initTilesets(){
        listeTileset.add(new Tileset("Z0","Outside_A1.png"));
        listeTileset.add(new Tileset("Z1","Outside_A2.png"));
        listeTileset.add(new Tileset("Z2","Outside_A3.png"));
        listeTileset.add(new Tileset("Z3","Outside_A4.png"));
        listeTileset.add(new Tileset("Z4","Outside_A5.png"));
        listeTileset.add(new Tileset("Z5","Outside_B.png"));
        listeTileset.add(new Tileset("Z6","Outside_C.png"));
        listeTileset.add(new Tileset("Z7","Inside_A1.png"));
        listeTileset.add(new Tileset("Z8","Inside_A2.png"));
        listeTileset.add(new Tileset("Z9","Inside_A4.png"));
        listeTileset.add(new Tileset("Z10","Inside_A5.png"));
        listeTileset.add(new Tileset("Z11","Inside_B.png"));
        listeTileset.add(new Tileset("Z12","Inside_C.png"));
        listeTileset.add(new Tileset("Z13","Dungeon_A1.png"));
        listeTileset.add(new Tileset("Z14","Dungeon_A2.png"));
        listeTileset.add(new Tileset("Z15","Dungeon_A4.png"));
        listeTileset.add(new Tileset("Z16","Dungeon_A5.png"));
        listeTileset.add(new Tileset("Z17","Dungeon_B.png"));
        listeTileset.add(new Tileset("Z18","Dungeon_C.png"));
        listeTileset.add(new Tileset("Z19","World_A1.png"));
        listeTileset.add(new Tileset("Z20","World_A2.png"));
        listeTileset.add(new Tileset("Z21","World_B.png"));

    }

    private void initPnjs() {//Ici on créera les Pnjs
	    listePnjs = new ArrayList<>();

        //listePnjs.add(new Pnj(id,"Nom", Image, Entity ));

        /*Pour créer un Pnj il faut
        * Créer une liste d'image
        * Créer une Entity
        * Ajouter le Pnj à la listePnjs
        */

        //Pour le moment il n'y a qu'une Image vide dans la liste


    //Gentils
        Image x = new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        };

        ArrayList<Image> images = new ArrayList<>();
        images.add(x);
        Types typeFeu = new Feu();
        Plante typePlante = new Plante();
        Pv pv = new Pv(10,10);
        MoveList movesPhy = new MoveList(Move.lameFeu(),Move.coupPoing(),Move.coupEpee(),Move.coupPoing());
        MoveList movesSpe = new MoveList(Move.flecheFeu(),Move.flecheFeu(),Move.flecheFeu(),Move.flecheFeu());
        Arme arme = new Arme("1","Epée",5,x,2);
        Armure armure = new Armure("2","Bouclier", 5, x , 2);
        Entity entity = new Entity("1","Squelette",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy, x);
        listePnjs.add(new Pnj("1","Squelette", images, entity));

        movesPhy = new MoveList(Move.coupPoing(),Move.coupPoing(),Move.coupPoing(),Move.coupPoing());
        movesSpe = new MoveList(Move.coupPoing(),Move.coupPoing(),Move.coupPoing(),Move.coupPoing());
        pv = new Pv(10,10);
        //movesPhy = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        arme = new Arme("2","Rien",1,x,1);
        armure= new Armure("2","Rien",1,x,1);
        entity = new Entity("2","Rat",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy, x);
        listePnjs.add(new Pnj("2","Rat", images, entity));

        pv = new Pv(20,20);
        //movesPhy = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        arme = new Arme("1","Epée",5,x,2);
        armure= new Armure("2","Bouclier", 5, x , 2);
        entity = new Entity("3","Le Vieux Fou",3,50,0,typeFeu,pv,2,2,2,2,2,arme,armure, movesPhy, movesPhy, x);
        listePnjs.add(new Pnj("3","Le Vieux Fou", images, entity));

        pv = new Pv(15,15);
        //movesPhy = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        arme = new Arme("2","Rien",1,x,1);
        armure= new Armure("2","Rien",1,x,1);
        entity = new Entity("4","Petit Diable",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy, x);
        listePnjs.add(new Pnj("4","Petit Diable", images, entity));

        pv = new Pv(15,15);
        arme = new Arme("2","Rien",1,x,1);
        armure= new Armure("2","Rien",1,x,1);
        entity = new Entity("5","Combattant Test",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesSpe, x);
        listePnjs.add(new Pnj("4","Combattant Test", images, entity));

        //Entity entite1 = new Entity(1, "Celui qui dit l'histoire", 1, Integer xpmax, Integer xp, Types type, Pv pv, Integer att, Integer def, Integer attspe, Integer defspe, Integer vitesse, MoveList moves
	    //listePnjs.add(new Pnj(1,"Celui qui dit l'histoire", x,));



    //Ennemis
        //listePnjs.add(new Pnj(2,"Petit Rat", x,));
        //listePnjs.add(new Pnj(3,"Gros Rat", x, ));


    //Compagnons


    }

    private void initItems() {//Ici on créera les Items
//        Arme.baton();
//        Arme.dague();
//        Arme.epee();
//        Arme.arc();
//
//        Armure.banale();
//        Armure.legendaire();
//
//        Consommable.vie();
//        Consommable.degats();
//
//        Divers.balle()
//        Divers.queue()


    }

    private void initTeams(){

    }

    private void initQuetes() {
        
    }

    public ArrayList<Pnj> getListePnjs() {
        return listePnjs;
    }

    public void setListePnjs(ArrayList<Pnj> listePnjs) {
        this.listePnjs = listePnjs;
    }

    public ArrayList<Item> getListeItems() {
        return listeItems;
    }

    public void setListeItems(ArrayList<Item> listeItems) {
        this.listeItems = listeItems;
    }

    public ArrayList<Team> getListeTeams() {
        return listeTeams;
    }

    public void setListeTeams(ArrayList<Team> listeTeams) {
        this.listeTeams = listeTeams;
    }
}
