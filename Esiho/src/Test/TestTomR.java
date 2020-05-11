package Test;

import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Layer;
import GameData.Ressources.Contenu.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TestTomR extends Application {
    private Scene sceneMap;
    private Stage primStage;
    private Map map;

    @Override
    public void start(Stage stage) throws Exception {
        InitContenu contenu = new InitContenu();
        Layer coucheBase = new Layer(16, 8, "test", "0");
        Layer couche2 = new Layer(16, 8, "test", "1");
        Layer couche3 = new Layer(16, 8, "test", "2");
        Map map = new Map("M0", 16,8, coucheBase, couche2, couche3);
        this.primStage = stage;
        primStage.setTitle("Map");
        AnchorPane root = new AnchorPane();
        Canvas canvas = new Canvas();
        this.sceneMap= new Scene(root, 800, 400);
        primStage.setScene(sceneMap);
        ImageView imgv = new ImageView();
        Image image = coucheBase.getTile(0,0).getImage();
        imgv.setImage(image);
        HBox hbox = new HBox(imgv);
//        ImageObserver observer = new ImageObserver() {
//            @Override
//            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
//                return true;
//            }
//        };
        //graphics.drawImage(img, 16, 16, 16, 16, 4, 4, 4, 4, observer);

        ecranMap();
    }

    public static void main(String[] args){
        launch(args);
    }

    private void ecranMap() throws Exception{
        primStage = new Stage();
        primStage.setScene(sceneMap);
        primStage.show();
    }
}