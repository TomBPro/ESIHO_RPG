package Test;

import GameData.Combat.Entities.Team;
import GameData.Ressources.Cheats.Engine;
import GameData.Ressources.Contenu.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ShowMap extends Application {
    private Scene sceneMap;
    private Stage primStage;
    private Map map;
    private Integer stageWidth;
    private Integer stageHeight;
    private Canvas mapPane;
    private ArrayList<Image> joueurSprites;
    private Image joueurImage;
    private Node joueur;
    private Integer dx = 0;
    private Integer dy = 0;
    private Integer dx_old;
    private Integer dy_old;
    private Boolean keyPressed;
    private Integer compteurPas;
    private Integer memoireSens;
    private Boolean cheatsToggle;
    private Engine cheatEngine;
    private Boolean deplacement;

    @Override
    public void start(Stage stage) throws Exception {
        lancement(stage);
        ecranMap();
    }

    public static void main(String[] args){
        launch(args);
    }

    public ShowMap(){}

    public void lancement(Stage stage) throws Exception{
        InitContenu contenu = new InitContenu();
        stageWidth=800;
        stageHeight=400;
        joueurSprites = new ArrayList<>();
        for (Tile tile: Pnj.joueur("Maurice").getListeSprites()) {
            joueurSprites.add(tile.getImage());
        }
        joueurImage = joueurSprites.get(0);
        joueur = new ImageView(joueurImage);
        this.primStage = stage;
        primStage.setTitle("Map");
        compteurPas=0;
        memoireSens=0;
        StackPane root = new StackPane();
        mapPane = new Canvas(stageWidth,stageHeight);
        keyPressed = false;
        this.map = Map.getMapTest(new EcranCombat(), primStage);
        Integer[] position = map.getTpPoint(0);
        System.out.println(position[0]+" "+position[1]);
        dx = 4*16;
        dy = 4*16;
        this.deplacement = false;
        showLayers();
        root.getChildren().addAll(mapPane);
        root.getChildren().add(joueur);


        //Zone cheats
        cheatsToggle = false;
        GridPane cheatRoot = new GridPane();
        TextArea textArea = new TextArea();
        textArea.setPrefRowCount(4);
        textArea.setEditable(true);
        AtomicReference<String> text = new AtomicReference<>("");
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            text.set(textArea.getText());
        });
        textArea.setText(text.get());
        textArea.setMaxSize(stageWidth*0.2, stageHeight*0.1);
        cheatRoot.add(textArea, 0, 0);
        root.getChildren().add(cheatRoot);
        root.getChildren().get(2).setVisible(false);


        this.sceneMap= new Scene(root, stageWidth, stageHeight, Color.BLACK);

        sceneMap.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                keyPressed = true;
                switch (event.getCode()) {
                    case UP:
                        if (!deplacement){
                            if (!map.isCollided(dx, dy-16, 16)){
                                if (memoireSens!=3){
                                    compteurPas=0;
                                    memoireSens=3;
                                }
                                animDeplacement();
                            }else{
                                System.out.println("COLLISION case x: "+dx+" y: "+dy);
                                joueurImage = joueurSprites.get(9);
                                memoireSens=3;
                            }
                        }
                        break;
                    case DOWN:
                        if (!deplacement){
                            if (!map.isCollided(dx, dy+16, 16)){ //S'il n'y a pas de collision là où il se dirige
                                if (memoireSens!=0){
                                    compteurPas=0;
                                    memoireSens=0;
                                }
                                animDeplacement();
                            }else{
                                System.out.println("COLLISION case x: "+dx+" y: "+dy);
                                joueurImage = joueurSprites.get(0);
                                memoireSens=0;
                            }
                        }
                        break;
                    case LEFT:
                        if (!deplacement){
                            if (!map.isCollided(dx-16, dy, 16)){
                                if (memoireSens!=1){
                                    compteurPas=0;
                                    memoireSens=1;
                                }
                                animDeplacement();
                            }else{
                                System.out.println("COLLISION case x: "+dx+" y: "+dy);
                                joueurImage = joueurSprites.get(3);
                                memoireSens=1;
                            }
                        }
                        break;
                    case RIGHT:
                        if (!deplacement){
                            if (!map.isCollided(dx+16, dy, 16)) {
                                if (memoireSens!=2){
                                    compteurPas=0;
                                    memoireSens=2;
                                }
                                animDeplacement();
                            }else{
                                System.out.println("COLLISION case x: "+dx+" y: "+dy);
                                joueurImage = joueurSprites.get(6);
                                memoireSens=2;
                            }
                        }
                        break;
                    case F9:
                        if (cheatsToggle){
                            cheatsToggle=false;
                        }else{
                            cheatsToggle=true;
                        }
                        if (!cheatsToggle){
                            root.getChildren().get(2).setVisible(false);
                        }else{
                            root.getChildren().get(2).setVisible(true);
                        }
                        break;
                    case F10:
                        if (cheatsToggle){
                            try{
                                cheatEngine.cheats(text.toString());
                            }catch (Exception erreur_cheat_code){
                                System.out.println("Erreur lors de la commande de cheat");
                                if (text.toString()=="coord"){
                                    System.out.println("Dx : "+dx+" Dy : "+dy+" Dx/ : "+dx/16+" Dy/ : "+dy/16);
                                }
                            }
                        }
                        break;
                    case E: //INTERRACTION
                        Integer x = 0;
                        Integer y = 0;
                        switch (memoireSens){
                            case 0 :
                                //BAS
                                y=1;
                                break;
                            case 1 :
                                //GAUCHE
                                x=-1;
                                break;
                            case 2 :
                                //DROITE
                                x=1;
                                break;
                            case 3 :
                                //HAUT
                                y=-1;
                        }
                        try{
                            Stage newStage = map.onInterraction(x+dx/16, y+dy/16, primStage, new EcranCombat());
                            if (newStage!=null){
                                primStage = newStage;
                            }
                        }catch (Exception erreur_interraction_no_Pnj){
                            System.out.println("RIEN");
                            x = x+dx/16;
                            y = y+dy/16;
                            System.out.println("X : "+x+" Y : "+y);
                        }
                        break;
                    case I:
                        System.out.println("Argent : "+ Team.getTeam("T0").getArgent());
                        System.out.println("Inventaire : "+Team.getTeam("T0").getInventaire().getInventaire().size()+" objets");
                        System.out.println("Team : "+Team.getTeam("T0").getListePNJ().size()+" Pnjs");
                }
                System.out.println("Dx : "+dx+" Dy : "+dy+" Dx/ : "+dx/16+" Dy/ : "+dy/16);
            }
        });

        sceneMap.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                keyPressed = false;
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (dx/16 == 4 && dy/16 == 5){
                    System.out.println("TELEPORTATION");
                    if (map.getId()=="M1"){
                        mapChange(Map.getMap("M0"));
                    }else{
                        mapChange(Map.getMap("M1"));
                    }
                }
                if (keyPressed){
                    joueur = new ImageView(joueurImage);
                    root.getChildren().set(1, joueur);
                }
            }
        };
        timer.start();

        primStage.setScene(sceneMap);
    }

    private void showLayers(){
        GraphicsContext gc = mapPane.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, stageWidth, stageHeight);
        showOneLayer(map.getCoucheBase());
        showOneLayer(map.getCouche2());
        showOneLayer(map.getCouche3());
        showPnjLayer(map.getCoucheFin());
    }

    private void showOneLayer(Layer couche){
        Integer a = 0;
        for (ArrayList<Tile> ligne:couche.gridTiles) {
            Integer b = 0;
            for (Tile ignored:ligne) {
                    mapPane.getGraphicsContext2D().drawImage(couche.getTile(a, b).getImage(), a*16-dx+384, b*16-dy+176);
                b++;
            }
            a++;
        }
    }

    private void showPnjLayer(ArrayList<ArrayList<Pnj>> gridPnj){
        Integer a = 0;
        for (ArrayList<Pnj> ligne:gridPnj) {
            Integer b = 0;
            for (Pnj element:ligne) {
                if (element!=null){
                    mapPane.getGraphicsContext2D().drawImage(element.getListeSprites().get(0).getImage(), a*16-dx+384, b*16-dy+176);

                    System.out.println("a");
                }
                b++;
            }
            a++;
        }
    }

    private void mapChange(Map newMap){
        this.map = newMap;
        if (map.getTpPoint(0)!=null){
            Integer[] position = map.getTpPoint(0);
            this.dx = position[0]*16;
            this.dy = position[1]*16;
        }else{
            this.dx = 0;
            this.dy = 0;
        }
    }

    private void animDeplacement(){
        deplacement = true;
        Integer compteur = 0;
        while(compteur<32){
            if (compteurPas>=2){
                compteurPas=0;
            }else{
                compteurPas++;
            }
            switch (memoireSens){
                case 0 :
                    //BAS
                    joueurImage = joueurSprites.get(0+compteurPas);
                    dy+=4;
                    break;
                case 1 :
                    //GAUCHE
                    joueurImage = joueurSprites.get(3+compteurPas);
                    dx-=4;
                    break;
                case 2 :
                    //DROITE
                    joueurImage = joueurSprites.get(6+compteurPas);
                    dx+=4;
                    break;
                case 3 :
                    //HAUT
                    joueurImage = joueurSprites.get(9+compteurPas);
                    dy-=4;
            }
            timer(10);
            compteur+=4;
            showLayers();
        }
        deplacement = false;
    }

    private void timer(Integer duree){
        try{
            TimeUnit.MILLISECONDS.sleep(duree);
        }catch(InterruptedException ex){
            System.out.println("AH");
            ex.printStackTrace();
        }
    }

    private void ecranMap() throws Exception{
        primStage.show();
    }
}