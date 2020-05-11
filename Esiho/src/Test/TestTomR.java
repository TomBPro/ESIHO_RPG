package Test;

import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Layer;
import GameData.Ressources.Contenu.Map;
import GameData.Ressources.Contenu.Tile;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
//import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TestTomR extends Application {
    private Scene sceneMap;
    private Stage primStage;
    private Map map;
    private Integer stageWidth;
    private Integer stageHeight;
    private Canvas mapPane;

    @Override
    public void start(Stage stage) throws Exception {
        stageWidth=800;
        stageHeight=400;
        InitContenu contenu = new InitContenu();
        this.primStage = stage;
        primStage.setTitle("Map");
        StackPane root = new StackPane();
        mapPane = new Canvas(stageWidth,stageHeight);
        showLayers();
        root.getChildren().addAll(mapPane);
        this.sceneMap= new Scene(root, stageWidth, stageHeight, Color.BLACK);
        primStage.setScene(sceneMap);

        ecranMap();
    }

    public static void main(String[] args){
        launch(args);
    }

    private void showLayers(){
        Map map = new Map("M0", "test", 16,8);
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
                mapPane.getGraphicsContext2D().drawImage(couche.getTile(a, b).getImage(), a*16, b*16);
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