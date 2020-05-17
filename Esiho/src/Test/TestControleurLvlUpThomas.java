package Test;

import GameData.Combat.Entities.Entity;
import GameData.Combat.Entities.Pv;
import GameData.Combat.Moves.Move;
import GameData.Combat.Moves.MoveList;
import GameData.Combat.Types.Feu;
import GameData.Combat.Types.Normal;
import GameData.Combat.Types.Types;
import GameData.Default.Items.Arme;
import GameData.Default.Items.Armure;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import javafx.scene.control.TextField;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static java.lang.String.valueOf;

public class TestControleurLvlUpThomas implements Initializable {
    Pnj pnjTest;
    @FXML
    private Pane rootPane;

    @FXML
    private TextField currentLvl, currentHp, currentAtk, currentDef, currentAtkSpe, currentDefSpe,currentSpeed, addLvl, addHp, addAtk, addDef, addAtkSpe, addDefSpe,addSpeed;;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(),"src", "GameData","Ressources","Images", "Entities", "PersoRPG", "Chevalier Combat.png");
        Image x = new Image(cheminImage.toString());
        ArrayList<Image> images = new ArrayList<>();
        images.add(x);
        Types typeFeu = new Feu();
        Pv pv = new Pv(10,10);
        Move move = new Move("M1", "Coup de poing", "Physique", 40, new Normal(), 95);
        MoveList movesPhy = new MoveList(move,move,move,move);
        MoveList movesSpe = new MoveList(move,move,move,move);
        Arme arme = new Arme("1","Epée",5,2);
        Armure armure = new Armure("2","Bouclier", 5,  2);
        Entity entity = new Entity("1","Squelette",1,50,0,typeFeu,pv,1,1,1,1,1,arme,armure, movesPhy, movesSpe, x);

        pnjTest = new Pnj("1","Squelette", InitContenu.listeSpriteset.get(0).getListeSprites().get(0), entity);

        currentLvl.setText(valueOf(pnjTest.getEntite().getLvl()));
        currentHp.setText(valueOf(pnjTest.getEntite().getPV().getPvmax())) ;
        currentAtk.setText(valueOf(pnjTest.getEntite().getAtt())) ;
        currentDef.setText(valueOf(pnjTest.getEntite().getDef())) ;
        currentAtkSpe.setText(valueOf(pnjTest.getEntite().getAttspe()));
        currentDefSpe.setText(valueOf(pnjTest.getEntite().getDefspe()));
        currentSpeed.setText(valueOf(pnjTest.getEntite().getVitesse()));


    }
    public void lvlUp(ActionEvent actionEvent) throws IOException {
        pnjTest.setLvl(pnjTest.getEntite().getLvl()+1);
        addLvl.setText("Bravo, vous passez lvl " + pnjTest.getEntite().getLvl());
        currentLvl.setText(valueOf(pnjTest.getEntite().getLvl())) ;

        int hpadd = randomNumber(0,5);
        addHp.setText(" + " + hpadd);
        pnjTest.sethpmax(pnjTest.getEntite().getPV().getPvmax()+hpadd);
        currentHp.setText(valueOf(pnjTest.getEntite().getPV().getPvmax()));

        int atk = randomNumber(0,5);
        addAtk.setText(" + " + atk);
        pnjTest.setAtk(pnjTest.getEntite().getAtt()+atk);
        currentAtk.setText(valueOf(pnjTest.getEntite().getAtt())) ;

        int def = randomNumber(0,5);
        addDef.setText(" + " + def);
        pnjTest.setDef(pnjTest.getEntite().getDef()+def);
        currentDef.setText(valueOf(pnjTest.getEntite().getDef())) ;

        int atkSpe = randomNumber(0,5);
        addAtkSpe.setText(" + " + atkSpe);
        pnjTest.setAtkSpe(pnjTest.getEntite().getAttspe()+atkSpe);
        currentAtkSpe.setText(valueOf(pnjTest.getEntite().getAttspe()));

        int defSpe = randomNumber(0,5);
        addDefSpe.setText(" + " + defSpe);
        pnjTest.setDefSpe(pnjTest.getEntite().getDefspe()+defSpe);
        currentDefSpe.setText(valueOf(pnjTest.getEntite().getDefspe()));

        int speed = randomNumber(0,5);
        addSpeed.setText(" + " + speed);
        pnjTest.setVitesse(pnjTest.getEntite().getVitesse()+speed);
        currentSpeed.setText(valueOf(pnjTest.getEntite().getVitesse()));

    }

    public static int randomNumber(int min, int max) {
        //Donne un nombre aléatoire entre nbr1 et nbr2
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;

    }

    public void returnMenu(ActionEvent actionEvent) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("testMenuThomas.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
