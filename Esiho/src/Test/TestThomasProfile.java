package Test;

import GameData.Combat.Combat;
import GameData.Combat.Entities.Team;
import GameData.Ressources.Contenu.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;


public class TestThomasProfile extends Application {
    private Pnj joueur;
    private Scene profileScene;
    private Stage primStage;
    private Integer stageWidth, stageHeight;

    //Element de gauche pour afficher les stats
    private JScrollPane scrollStats;

    //Element du milieu Pour afficher le pnj sélectionner
    private Pane pnjSelec;
    private TextField pnjName;
    private Image pnjImage;
    private Pane pnjEquipements;

    //Element de droite
    private GridPane gridOptions; //Va afficher la liste des options de base : inventaire, quêtes, liste de l'equipe
    private GridPane gridPnjs; //Va afficher la liste des pnj de l'equipe




    @Override
    public void start(Stage stage) throws Exception {
        InitContenu contenu = new InitContenu();
        this.joueur = Pnj.getPnj("P0");
        stageWidth=800;
        stageHeight=400;
        this.primStage = stage;
        primStage.setTitle("Profile");










//        this.profileScene= new Scene(root, stageWidth, stageHeight, Color.WHITE);
//
//        primStage.setScene(profileScene);
//        primStage.show();
    }
}
