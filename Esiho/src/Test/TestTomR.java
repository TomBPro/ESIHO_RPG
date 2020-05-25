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
import java.util.concurrent.atomic.AtomicReference;

public class TestTomR extends Application {
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

    @Override
    public void start(Stage stage) throws Exception {
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
        this.map = new Map("M0", "test", 32,32);
        map.getCoucheFin().get(6).add(12, Pnj.getPnj("P1"));
        map.getCoucheFin().get(6).get(12).setAngle(1, 0);
        map.refreshCollision();
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
                if (compteurPas>=2){
                    compteurPas=0;
                }else{
                    compteurPas++;
                }
                keyPressed = true;
                switch (event.getCode()) {
                    case UP:
                        if (!map.isCollided(dx, dy-16, 16)){
                            dy -= 16;
                            if (memoireSens!=3){
                                compteurPas=0;
                                memoireSens=3;
                            }
                            joueurImage = joueurSprites.get(9+compteurPas);
                        }else{
                            System.out.println("COLLISION case x: "+dx+" y: "+dy);
                            joueurImage = joueurSprites.get(9);
                        }
                        break;
                    case DOWN:
                        if (!map.isCollided(dx, dy+16, 16)){ //S'il n'y a pas de collision là où il se dirige
                            dy += 16;
                            if (memoireSens!=0){
                                compteurPas=0;
                                memoireSens=0;
                            }
                            joueurImage = joueurSprites.get(0+compteurPas);
                        }else{
                            System.out.println("COLLISION case x: "+dx+" y: "+dy);
                            joueurImage = joueurSprites.get(0);
                        }
                        break;
                    case LEFT:
                        if (!map.isCollided(dx-16, dy, 16)){
                            dx -= 16;
                            if (memoireSens!=1){
                                compteurPas=0;
                                memoireSens=1;
                            }
                            joueurImage = joueurSprites.get(3+compteurPas);
                        }else{
                            System.out.println("COLLISION case x: "+dx+" y: "+dy);
                            joueurImage = joueurSprites.get(3);
                        }
                        break;
                    case RIGHT:
                        if (!map.isCollided(dx+16, dy, 16)) {
                            dx += 16;
                            if (memoireSens!=2){
                                compteurPas=0;
                                memoireSens=2;
                            }
                            joueurImage = joueurSprites.get(6+compteurPas);
                        }else{
                            System.out.println("COLLISION case x: "+dx+" y: "+dy);
                            joueurImage = joueurSprites.get(6);
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
                        switch (memoireSens){
                            case 0 :
                                //BAS
                                if (map.getCoucheFin().get(dx/16).get(-1+dy/16)!=null){
                                    map.getCoucheFin().get(dx/16).get(-1+dy/16).interract();
                                }
                                break;
                            case 1 :
                                //GAUCHE
                                if (map.getCoucheFin().get(-1+dx/16).get(dy/16)!=null){
                                    map.getCoucheFin().get(-1+dx/16).get(dy/16).interract();
                                }
                                break;
                            case 2 :
                                //DROITE
                                if (map.getCoucheFin().get(1+dx/16).get(dy/16)!=null){
                                    map.getCoucheFin().get(1+dx/16).get(dy/16).interract();
                                }
                                break;
                            case 3 :
                                //HAUT
                                if (map.getCoucheFin().get(dx/16).get(1+dy/16)!=null){
                                    map.getCoucheFin().get(dx/16).get(1+dy/16).interract();
                                }
                                break;
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
                if (keyPressed){
                    joueur = new ImageView(joueurImage);
                    root.getChildren().set(1, joueur);
                }
                if (dx!=dx_old || dy!=dy_old){
                    showLayers();
                    dx_old=dx;
                    dy_old=dy;
                }
                showLayers();
            }
        };
        timer.start();

        primStage.setScene(sceneMap);

        ecranMap();
    }

    public static void main(String[] args){
        launch(args);
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
            for (Tile element:ligne) {
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
                }
                b++;
            }
            a++;
        }
    }

    private void ecranMap() throws Exception{
        primStage = new Stage();
        primStage.setScene(sceneMap);
        primStage.show();
    }
}