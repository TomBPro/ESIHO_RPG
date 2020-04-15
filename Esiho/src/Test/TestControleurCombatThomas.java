package Test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TestControleurCombatThomas implements Initializable {

    @FXML
    private Button btnAtk1, btnAtk2, btnAtk3, btnAtk4;
    @FXML
    private Pane rootPane;
    @FXML
    private GridPane gridAtk,gridInventaire;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void startCtnButtonOnClick() throws Exception {// bouton : lance le jeu

    }

    @FXML
    private void atkPhy() throws Exception {//
        gridInventaire.setVisible(false);
        gridAtk.setVisible(true);
        btnAtk1.setText("Attaque Phy 1");
        btnAtk2.setText("Attaque Phy 2");
        btnAtk3.setText("Attaque Phy 3");
        btnAtk4.setText("Attaque Phy 4");
    }

    @FXML
    private void atkSpe() throws Exception {//
        gridInventaire.setVisible(false);
        gridAtk.setVisible(true);
        btnAtk1.setText("Attaque Spé 1");
        btnAtk2.setText("Attaque Spé 2");
        btnAtk3.setText("Attaque Spé 3");
        btnAtk4.setText("Attaque Spé 4");

    }

    @FXML
    private void inventaire() throws Exception {//
        gridAtk.setVisible(false);
        gridInventaire.setVisible(true);
    }

    public void fuite(ActionEvent actionEvent) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("testMenuThomas.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}