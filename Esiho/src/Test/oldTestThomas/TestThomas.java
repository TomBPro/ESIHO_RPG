package Test.oldTestThomas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestThomas extends Application {
    private Scene sceneTitre,sceneCombat;
    private Stage primStage;


    @Override
    public void start(Stage stage) throws Exception {
        this.primStage = stage;
        this.sceneCombat= new Scene(FXMLLoader.load(getClass().getResource("testCombatThomas.fxml")));
        this.sceneTitre= new Scene(FXMLLoader.load(getClass().getResource("testMenuThomas.fxml")));
        primStage.setTitle("Menu");
        ecranTitre();
    }

    public static void main(String[] args) {
        launch(args);
        initPerso();
    }

    private static void initPerso() {


    }

    protected void ecranTitre() throws Exception {//affiche l'écran de combat
        primStage = new Stage();
        primStage.setScene(sceneTitre);
        primStage.show();
    }

    public void ecranCombat() throws Exception {//affiche l'écran de combat
        primStage = new Stage();
        primStage.setScene(sceneCombat);
        primStage.show();
    }

}
