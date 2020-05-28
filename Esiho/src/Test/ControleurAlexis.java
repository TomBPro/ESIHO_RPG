package Test;

import GameData.Combat.Entities.Team;
import GameData.Default.Items.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleurAlexis implements Initializable {

    private Team teamjoueur;
    private ArrayList<Item> listItem;
    private ArrayList<Item> listArme;
    private ArrayList<Item> listArmure;
    private ArrayList<Item> listConso;
    private ArrayList<Item> listDivers;


    @FXML
    private GridPane gridArme, gridArmure, gridConso, gridDivers;

    @FXML
    private Label inventaire;

    @FXML
    private Button btinv;

    @FXML
    private ScrollPane vinv;

    @FXML
    protected void showInv(javafx.event.ActionEvent actionEvent){
        vinv.setVisible(true);
        btinv.setVisible(false);
        String contenu = "";

        for(Item element:teamjoueur.getInventaire().getInventaire()){
            contenu = contenu+element.getNom()+"\n";
            //System.out.println(element.getNom());

        }
        inventaire.setText(contenu);
//recycle view
    }

    @FXML
    protected void afficherArme(javafx.event.ActionEvent actionEvent) {
        gridArme.setVisible(true);
        gridArmure.setVisible(false);
        gridConso.setVisible(false);
        gridDivers.setVisible(false);
        String type = "ARME";
        listArme.clear();//vide la liste
        for (Item unItem:teamjoueur.getInventaire().getInventaire()) {
            if (unItem.getTypeI()==type){
                listArme.add(unItem);
            }
        }
        for(Item element:listArme){
            System.out.println(element.getNom());
        }
    }

    @FXML
    protected void afficherArmure(javafx.event.ActionEvent actionEvent){
        gridArme.setVisible(false);
        gridArmure.setVisible(true);
        gridConso.setVisible(false);
        gridDivers.setVisible(false);
        String type = "ARMURE";
        listArmure.clear();//vide la liste
        for (Item unItem:teamjoueur.getInventaire().getInventaire()) {
            if (unItem.getTypeI()==type){
                listArmure.add(unItem);
            }
        }
        for(Item element:listArmure){
            System.out.println(element.getNom());
        }
    }

    @FXML
    protected void afficherConsommable(javafx.event.ActionEvent actionEvent){
        gridArme.setVisible(false);
        gridArmure.setVisible(false);
        gridConso.setVisible(true);
        gridDivers.setVisible(false);
        String type = "CONSOMMABLE";
        listConso.clear();//vide la liste
        for (Item unItem:teamjoueur.getInventaire().getInventaire()) {
            if (unItem.getTypeI()==type){
                listConso.add(unItem);
            }
        }
        for(Item element:listConso){
            System.out.println(element.getNom());
        }
    }

    @FXML
    protected void afficherDivers(javafx.event.ActionEvent actionEvent){
        gridArme.setVisible(false);
        gridArmure.setVisible(false);
        gridConso.setVisible(false);
        gridDivers.setVisible(true);
        String type = "DIVERS";
        listDivers.clear();//vide la liste
        for (Item unItem:teamjoueur.getInventaire().getInventaire()) {
            if (unItem.getTypeI()==type){
                listDivers.add(unItem);
            }
        }
        for(Item element:listDivers){
            System.out.println(element.getNom());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.listItem = new ArrayList<>(); //Ça n'était pas initialisé
        this.listArme = new ArrayList<>();
        this.listArmure = new ArrayList<>();
        this.listConso = new ArrayList<>();
        this.listDivers = new ArrayList<>();
        this.teamjoueur= new Team("T1",1200);
        teamjoueur.getInventaire().addItem(Item.epee());
        teamjoueur.getInventaire().addItem(Item.baton());
        teamjoueur.getInventaire().addItem(Item.dague());
        teamjoueur.getInventaire().addItem(Item.arc());
        teamjoueur.getInventaire().addItem(Item.arc());
        teamjoueur.getInventaire().addItem(Item.arc());
        teamjoueur.getInventaire().addItem(Item.arc());
        teamjoueur.getInventaire().addItem(Item.banale());
        teamjoueur.getInventaire().addItem(Item.legendaire());
        teamjoueur.getInventaire().addItem(Item.balle());



    }


}
