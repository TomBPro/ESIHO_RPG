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
    private ArrayList<Move> listeMoves;
    private ArrayList<Decor> listeDecors;
    private ArrayList<Pnj> listePnjs;
    private ArrayList<Item> listeItems;
    private ArrayList<Team> listeTeams;
    private ArrayList<Quest> listeQuetes;

    public InitContenu() {
	    initMoves();
	    initDecors();
	    initPnjs();
	    initItems();
	    initTeams();
	    initQuetes();
    }

    private void initMoves() {//Ici on créera les attaques
	//Ex :
	//listeMoves.add(new Move(1, "Lance-flammes", etc))
        listeMoves.add(new Move("M1", "Coup de poing", "Physique", 40, new Normal(), 95));
        listeMoves.add(new Move("M2", "Coup d'épée", "Physique", 85, new Normal(), 85));
        listeMoves.add(new Move("M3", "Lame d'herbe", "Physique", 80, new Plante(), 90));
        listeMoves.add(new Move("M4", "Lame de feu", "Physique", 90, new Feu(), 80));
        listeMoves.add(new Move("M5", "Lame d'eau", "Physique", 85, new Eau(), 85));
        listeMoves.add(new Move("M6", "Feuilles à lancer", "Spécial", 80, new Plante(), 90));
        listeMoves.add(new Move("M7", "Lance-Flammes", "Spécial", 90, new Feu(), 80));
        listeMoves.add(new Move("M8", "Canon à Eau", "Spécial", 85, new Eau(), 85));
        listeMoves.add(new Move("M9", "Tir de flèche", "Spécial", 80, new Normal(), 85));
        listeMoves.add(new Move("M10", "Flèche d'épines", "Spécial", 80, new Plante(), 90));
        listeMoves.add(new Move("M11", "Flèche d'eau", "Spécial", 90, new Normal(), 80));
        listeMoves.add(new Move("M12", "Flèche de feu", "Spécial", 85, new Normal(), 85));

    } 

    private void initDecors() {//Ici on créera les décors 
	
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
        MoveList moves = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        Arme arme = new Arme("1","Epée",5,x,2);
        Armure armure = new Armure("2","Bouclier", 5, x , 2);
        Entity entity = new Entity("1","Squelette",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, moves, moves, x);
        listePnjs.add(new Pnj("1","Squelette", images, entity));


        pv = new Pv(10,10);
        moves = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        arme = new Arme("2","Rien",1,x,1);
        armure= new Armure("2","Rien",1,x,1);
        entity = new Entity("2","Rat",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, moves, moves, x);
        listePnjs.add(new Pnj("2","Rat", images, entity));

        pv = new Pv(20,20);
        moves = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        arme = new Arme("1","Epée",5,x,2);
        armure= new Armure("2","Bouclier", 5, x , 2);
        entity = new Entity("3","Le Vieux Fou",3,50,0,typeFeu,pv,2,2,2,2,2,arme,armure, moves, moves, x);
        listePnjs.add(new Pnj("3","Le Vieux Fou", images, entity));

        pv = new Pv(15,15);
        moves = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
        arme = new Arme("2","Rien",1,x,1);
        armure= new Armure("2","Rien",1,x,1);
        entity = new Entity("2","Petit Diable",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, moves, moves, x);
        listePnjs.add(new Pnj("4","Petit Diable", images, entity));

        //Entity entite1 = new Entity(1, "Celui qui dit l'histoire", 1, Integer xpmax, Integer xp, Types type, Pv pv, Integer att, Integer def, Integer attspe, Integer defspe, Integer vitesse, MoveList moves
	    //listePnjs.add(new Pnj(1,"Celui qui dit l'histoire", x,));



    //Ennemis
        //listePnjs.add(new Pnj(2,"Petit Rat", x,));
        //listePnjs.add(new Pnj(3,"Gros Rat", x, ));


    //Compagnons


    }

    private void initItems() {//Ici on créera les Items
//        listeItems.add(new Arme("I1","Baton",100, "Baton.png", 1));
//        listeItems.add(new Arme("I2","dague",250, "Dague.png", 3));
//        listeItems.add(new Arme("I3","epee légendaire",500, "Epee.png", 5));
//        listeItems.add(new Arme("I4","arc",300, "x", 4));
//        listeItems.add(new Armure("I5", "Armure banale", 100, "x", 2));
//        listeItems.add(new Armure("I6", "Armure légendaire", 500, "x", 5));
//        listeItems.add(new Consommable("I7", "Potion de vie", 100, "x", 1); {
//            @Override
//            public void useItem() {
//
//            }
//
//            @Override
//            public void useItem(Pnj pnj, Integer val) {
//                if(this.getType()==1){
//                    //Soigner
//                    pnj.getEntite().getPV().addPv(val);
//                }else if (this.getType() == 2){
//                    //Degats
//                    pnj.getEntite().getPV().removePv(val);
//                }
//            }
//      }
//        listeItems.add(new Consommable("I8", "Potion de dégâts", 100, "x", 2); {
//            @Override
//            public void useItem() {
//
//            }
//
//            @Override
//            public void useItem(Pnj pnj, Integer val) {
//                if(this.getType()==1){
//                    //Soigner
//                    pnj.getEntite().getPV().addPv(val);
//                }else if (this.getType() == 2){
//                    //Degats
//                    pnj.getEntite().getPV().removePv(val);
//                }
//            }
//        }

//        listeItems.add(new Divers("I9", "queue de rat", 50, "x"));
//        listeItems.add(new Divers("I10", "balle", 200, "x"));

    }

    private void initTeams(){

    }

    private void initQuetes() {
        
    }



    public ArrayList<Move> getListeMoves() {
        return listeMoves;
    }

    public void setListeMoves(ArrayList<Move> listeMoves) {
        this.listeMoves = listeMoves;
    }

    public ArrayList<Decor> getListeDecors() {
        return listeDecors;
    }

    public void setListeDecors(ArrayList<Decor> listeDecors) {
        this.listeDecors = listeDecors;
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
