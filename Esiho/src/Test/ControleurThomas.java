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
    private void startCtnButtonOnClick() throws Exception {// bouton : lance le jeu

    }

    @FXML
    private void ecranCombat() throws Exception {// bouton Combat
        //super.ecranCredits();
        Pane pane = FXMLLoader.load(getClass().getResource("testCombatThomas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void startNewButtonOnClick() throws Exception {// bouton new game
        Pane pane = FXMLLoader.load(getClass().getResource("ecranNewGame.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void startOptnButtonOnClick() throws Exception {// bouton options
        Pane pane = FXMLLoader.load(getClass().getResource("ecranOptions.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    //Credits
    @FXML
    private void optnRtrnButtonOnClick() throws Exception {//bouton retour
        //super.ecranTitre();
        Pane pane = FXMLLoader.load(getClass().getResource("ecranTitre.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
