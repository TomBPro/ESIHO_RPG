package Test;

import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Layer;
import GameData.Ressources.Contenu.Map;
import GameData.Ressources.Contenu.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;

public class TestTomR extends Application {
    private Scene sceneMap;
    private Stage primStage;
    private Map map;
    private Integer stageWidth;
    private Integer stageHeight;
    private Canvas mapPane;
    private Integer xJoueur;
    private Integer yJoueur;
    private Boolean goNorth = false;
    private Boolean goSouth = false;
    private Boolean goWest = false;
    private Boolean goEast = false;
    private Boolean running = false;
    private Image joueurImage;
    private Node joueur;

    @Override
    public void start(Stage stage) throws Exception {
        InitContenu contenu = new InitContenu();
        stageWidth=800;
        stageHeight=400;
        xJoueur = -16+stageWidth/2;
        yJoueur = -16+stageHeight/2;
        joueurImage = InitContenu.listeSpriteset.get(0).getTile(0).getImage();
        joueur = new ImageView(joueurImage);
        this.primStage = stage;
        primStage.setTitle("Map");
        StackPane root = new StackPane();
        mapPane = new Canvas(stageWidth,stageHeight);
        showLayers();
        root.getChildren().addAll(mapPane);
        this.sceneMap= new Scene(root, stageWidth, stageHeight, Color.BLACK);

        sceneMap.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        goNorth = true;
                        System.out.println("BRUH");
                        break;
                    case DOWN:  goSouth = true; break;
                    case LEFT:  goWest  = true; break;
                    case RIGHT: goEast  = true; break;
                    case SHIFT: running = true; break;
                }
            }
        });

        sceneMap.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goNorth = false; break;
                    case DOWN:  goSouth = false; break;
                    case LEFT:  goWest  = false; break;
                    case RIGHT: goEast  = false; break;
                    case SHIFT: running = false; break;
                }
            }
        });


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (goNorth){
                    yJoueur+=32;
                }
                if (goSouth){
                    yJoueur-=32;
                }
                if (goWest){
                    xJoueur+=32;
                }
                if (goEast){
                    xJoueur-=32;
                }
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
        Map map = new Map("M0", "test", 32,32);
        GraphicsContext gc = mapPane.getGraphicsContext2D();
        showOneLayer(map.getCoucheBase());
        showOneLayer(map.getCouche2());
        showOneLayer(map.getCouche3());
    }

    private void showOneLayer(Layer couche){
        Integer a = 0;
        for (ArrayList<Tile> ligne:couche.gridTiles) {
            Integer b = 0;
            for (Tile element:ligne) {
                if (a*16<=-16+xJoueur*2 && b*16<=-16+yJoueur*2){
                    mapPane.getGraphicsContext2D().drawImage(couche.getTile(a, b).getImage(), a*16, b*16);
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