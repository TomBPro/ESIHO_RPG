package GameData.Ressources.Contenu;

import GameData.Combat.Entities.Entity;
import GameData.Combat.Entities.Pv;
import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.Move;
import GameData.Combat.Moves.MoveList;
import GameData.Combat.Types.*;
import GameData.Default.Items.*;
import GameData.Default.Story.Quest;
import javafx.scene.image.Image;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InitContenu {//Cette classe contiendra toutes les initialisations de map, d'items, de pnj, d'entités, etc.
    private ArrayList<Quest> listeQuetes;
    public static ArrayList<Tileset> listeTileset = new ArrayList<>();
    public static ArrayList<Tileset> listeSpriteset = new ArrayList<>();
    public static ArrayList<Team> listeTeams = new ArrayList<>();
    public static ArrayList<Item> listeItems = new ArrayList<>();
    public static ArrayList<Pnj> listePnjs = new ArrayList<>();

    public InitContenu() throws FileNotFoundException {
        initTilesets();
	    initPnjs();
	    initItems();
	    initTeams();
	    initQuetes();
    }

    private void initTilesets(){
        Integer nbTileset = 21;
        for (int a = 0; a<nbTileset; a++){
            listeTileset.add(null);
        }
        Integer nbSpriteset = 4;
        for (int a = 0; a<nbSpriteset; a++){
            listeSpriteset.add(null);
        }
    }

    private void initPnjs() throws FileNotFoundException {//Ici on créera les Pnjs
	    Integer nbPnj = 5;
        for (int a = 0; a<nbPnj; a++){
            listePnjs.add(null);
        }

 //       _____ __  __ _____   ____  _____ _______       _   _ _______
 //     |_   _|  \/  |  __ \ / __ \|  __ \__   __|/\   | \ | |__   __|
 //       | | | \  / | |__) | |  | | |__) | | |  /  \  |  \| |  | |
 //       | | | |\/| |  ___/| |  | |  _  /  | | / /\ \ | . ` |  | |
 //      _| |_| |  | | |    | |__| | | \ \  | |/ ____ \| |\  |  | |
 //     |_____|_|  |_|_|     \____/|_|  \_\ |_/_/    \_\_| \_|  |_|
// Les pnjs vont être initialisés en static dans la classe Pnj. Ex : Pnj.joueur();  Donc il faudra tout déplacer là-bas ! Et proprement.

                //Gentils
//        Types typeFeu = new Feu();
//        Plante typePlante = new Plante();
//        Pv pv = new Pv(10,10);
//        MoveList movesPhy = new MoveList(Move.lameFeu(),Move.coupPoing(),Move.coupEpee(),Move.coupPoing());
//        MoveList movesSpe = new MoveList(Move.flecheFeu(),Move.flecheFeu(),Move.flecheFeu(),Move.flecheFeu());
//        Arme arme = new Arme("1","Epée",5,2);
//        Armure armure = new Armure("2","Bouclier", 5 , 2);
//        Entity entity = new Entity("1","Squelette",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy, x);
//        listePnjs.add(new Pnj("1","Squelette", listeSprites, entity));
//
//        movesPhy = new MoveList(Move.coupPoing(),Move.coupPoing(),Move.coupPoing(),Move.coupPoing());
//        movesSpe = new MoveList(Move.coupPoing(),Move.coupPoing(),Move.coupPoing(),Move.coupPoing());
//        pv = new Pv(10,10);
//        //movesPhy = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
//        arme = new Arme("2","Rien",1,1);
//        armure= new Armure("2","Rien",1,1);
//        entity = new Entity("2","Rat",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy, x);
//        listePnjs.add(new Pnj("2","Rat", listeSprites, entity));
//
//        pv = new Pv(20,20);
//        //movesPhy = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
//        arme = new Arme("1","Epée",5,2);
//        armure= new Armure("2","Bouclier", 5, 2);
//        entity = new Entity("3","Le Vieux Fou",3,50,0,typeFeu,pv,2,2,2,2,2,arme,armure, movesPhy, movesPhy, x);
//        listePnjs.add(new Pnj("3","Le Vieux Fou", listeSprites, entity));
//
//        pv = new Pv(15,15);
//        //movesPhy = new MoveList(listeMoves.get(0),listeMoves.get(0),listeMoves.get(0),listeMoves.get(0));
//        arme = new Arme("2","Rien",1,1);
//        armure= new Armure("2","Rien",1,1);
//        entity = new Entity("4","Petit Diable",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesPhy, x);
//        listePnjs.add(new Pnj("4","Petit Diable", listeSprites, entity));
//
//        pv = new Pv(15,15);
//        arme = new Arme("2","Rien",1,1);
//        armure= new Armure("2","Rien",1,1);
//        entity = new Entity("5","Combattant Test",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesSpe, x);
//        listePnjs.add(new Pnj("4","Combattant Test", listeSprites, entity));

        //Entity entite1 = new Entity(1, "Celui qui dit l'histoire", 1, Integer xpmax, Integer xp, Types type, Pv pv, Integer att, Integer def, Integer attspe, Integer defspe, Integer vitesse, MoveList moves
	    //listePnjs.add(new Pnj(1,"Celui qui dit l'histoire", x,));





    }

    private void initItems() {//Ici on créera les Items
        Integer nbItems = 1;
        for (int a = 0; a<nbItems; a++){
            InitContenu.listeItems.add(null);
        }
        Arme.epee();
        Arme.arc();
        Arme.baton();
        Arme.dague();

        Armure.banale();
        Armure.legendaire();

//        Consommable.vie();
//        Consommable.degats();

        Divers.balle();
        Divers.queue();


    }

    private void initTeams(){
        Integer nbTeams = 1;
        for (int a = 0; a<nbTeams; a++){
            InitContenu.listeTeams.add(null);
        }
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
