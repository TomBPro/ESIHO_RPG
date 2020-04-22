package Test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleurThomas implements Initializable {

    //Menu Écran Titre
    @FXML
    private Pane rootPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void ecranCombat() throws Exception {// bouton Combat
        //super.ecranCredits();
        Pane pane = FXMLLoader.load(getClass().getResource("testCombatThomas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void ecranLvlUp() throws Exception {// bouton new game
        Pane pane = FXMLLoader.load(getClass().getResource("testLvlUpThomas.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
