package Test;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleurAlexis implements Initializable {

    private Team teamjoueur;
    private ArrayList<Item> listItem;

    @FXML
    private GridPane gridArme, gridArmure, gridConso, gridDivers;

    @FXML
    protected void afficherArme(javafx.event.ActionEvent actionEvent) {
        gridArme.setVisible(true);
        gridArmure.setVisible(false);
        gridConso.setVisible(false);
        gridDivers.setVisible(false);
        String type = "Arme";
        for (Item unItem:teamjoueur.getInventaire().getInventaire()) {
            if (unItem.getTypeI().equals(type)){
                listItem.add(unItem);
            }
        }
        for(Item element:listItem){
            System.out.println(element.getNom());
        }
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
        this.teamjoueur= new Team("T1",1200);
        teamjoueur.getInventaire().addItem(Arme.epee());

        for(Item element:teamjoueur.getInventaire().getInventaire()){
            System.out.println(element.getNom());
        }

    }


}
