package Test;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleurAlexis implements Initializable {

    @FXML
    private GridPane gridArme, gridArmure, gridConso, gridDivers;

    @FXML
    protected void afficherArme(javafx.event.ActionEvent actionEvent) {
        gridArme.setVisible(true);
        gridArmure.setVisible(false);
        gridConso.setVisible(false);
        gridDivers.setVisible(false);
    }

    @FXML
    protected void afficherArmure(javafx.event.ActionEvent actionEvent){
        gridArme.setVisible(false);
        gridArmure.setVisible(true);
        gridConso.setVisible(false);
        gridDivers.setVisible(false);
    }

    @FXML
    protected void afficherConsommable(javafx.event.ActionEvent actionEvent){
        gridArme.setVisible(false);
        gridArmure.setVisible(false);
        gridConso.setVisible(true);
        gridDivers.setVisible(false);
    }

    @FXML
    protected void afficherDivers(javafx.event.ActionEvent actionEvent){
        gridArme.setVisible(false);
        gridArmure.setVisible(false);
        gridConso.setVisible(false);
        gridDivers.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
