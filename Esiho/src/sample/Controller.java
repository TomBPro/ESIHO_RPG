package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //Menu Écran Titre
    @FXML
    private Pane rootPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void startCrdtsButtonOnClick() throws Exception {// bouton crédit
        //super.ecranCredits();
        Pane pane = FXMLLoader.load(getClass().getResource("ecranCrdts.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    //Credits
    @FXML
    private void optnRtrnButtonOnClick() throws Exception {
        //super.ecranTitre();
        Pane pane = FXMLLoader.load(getClass().getResource("ecranTitre.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
