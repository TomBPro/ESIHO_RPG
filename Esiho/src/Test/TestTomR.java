package Test;

import GameData.Ressources.Contenu.*;
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
    private ArrayList<Image> joueurSprites;
    private Image joueurImage;
    private Node joueur;
    private Integer dx = 0;
    private Integer dy = 8;
    private Integer dx_old;
    private Integer dy_old;
    private Boolean keyPressed;
    private Integer compteurPas;
    private Integer memoireSens;

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
        showLayers();
        root.getChildren().addAll(mapPane);
        root.getChildren().add(joueur);
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
                        dy += 16;
                        if (memoireSens!=3){
                            compteurPas=0;
                            memoireSens=3;
                        }
                        joueurImage = joueurSprites.get(9+compteurPas);
                        break;
                    case DOWN:
                        dy -= 16;
                        if (memoireSens!=0){
                            compteurPas=0;
                            memoireSens=0;
                        }
                        joueurImage = joueurSprites.get(0+compteurPas);
                        break;
                    case LEFT:
                        dx += 16;
                        if (memoireSens!=1){
                            compteurPas=0;
                            memoireSens=1;
                        }
                        joueurImage = joueurSprites.get(3+compteurPas);
                        break;
                    case RIGHT:
                        dx -= 16;
                        if (memoireSens!=2){
                            compteurPas=0;
                            memoireSens=2;
                        }
                        joueurImage = joueurSprites.get(6+compteurPas);
                        break;
                }

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
        Map map = new Map("M0", "test", 32,32);
        GraphicsContext gc = mapPane.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, stageWidth, stageHeight);
        showOneLayer(map.getCoucheBase());
        showOneLayer(map.getCouche2());
        showOneLayer(map.getCouche3());
    }

    private void showOneLayer(Layer couche){
        Integer a = 0;
        for (ArrayList<Tile> ligne:couche.gridTiles) {
            Integer b = 0;
            for (Tile element:ligne) {
                    mapPane.getGraphicsContext2D().drawImage(couche.getTile(a, b).getImage(), a*16+dx, b*16+dy);
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