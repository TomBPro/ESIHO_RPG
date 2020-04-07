package Test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestThomas extends Application {
    private Scene sceneCombat;
    private Stage stageCombat;

    @Override
    public void start(Stage stage) throws Exception {
        this.stageCombat = stage;
        this.sceneCombat= new Scene(FXMLLoader.load(getClass().getResource("testCombatThomas.fxml")));
        stageCombat.setTitle("Test de combat");
        ecranCombat();
    }

    public static void main(String[] args) {
        launch(args);
        initPerso();
    }

    private static void initPerso() {


    }

    protected void ecranCombat() throws Exception {//affiche l'écran de combat
        stageCombat = new Stage();
        stageCombat.setScene(sceneCombat);
        stageCombat.show();
    }
}
