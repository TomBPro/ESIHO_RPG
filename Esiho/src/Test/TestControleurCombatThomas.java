package Test;

import GameData.Combat.Moves.Move;
import GameData.Combat.Types.Normal;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

public class TestControleurCombatThomas implements Initializable {

    private Pnj combattant;
    private ArrayList<Pnj> listPlayer;
    private ArrayList<Move> move;
    private Integer selecGenre;
    public static String selectionAtk;

    public TestControleurCombatThomas() throws FileNotFoundException {
        selectionAtk="RIEN";
        System.out.println("ok");
        InitContenu contenu = new InitContenu();
        System.out.println("ok");
        this.listPlayer = new ArrayList<>();
        for (int i = 0; i<4; i++){
            listPlayer.add(contenu.getListePnjs().get(i));
        }
    }

    @FXML
    TextField pv;
    @FXML
    private Button btnAtk1, btnAtk2, btnAtk3, btnAtk4, perso1, perso2, perso3, perso4, perso5;
    @FXML
    private Pane rootPane;
    @FXML
    private GridPane gridAtk,gridInventaire;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Button> listBtnPlayer = new ArrayList<>();
        listBtnPlayer.add(perso1);
        listBtnPlayer.add(perso2);
        listBtnPlayer.add(perso3);
        listBtnPlayer.add(perso4);
        listBtnPlayer.add(perso5);

        if (listPlayer.size()==5){
            perso1.setText(listPlayer.get(0).getNom());
            perso2.setText(listPlayer.get(1).getNom());
            perso3.setText(listPlayer.get(2).getNom());
            perso4.setText(listPlayer.get(3).getNom());
            perso5.setText(listPlayer.get(4).getNom());
        }
        if (listPlayer.size()==4){
            perso1.setText(listPlayer.get(0).getNom());
            perso2.setText(listPlayer.get(1).getNom());
            perso3.setText(listPlayer.get(2).getNom());
            perso4.setText(listPlayer.get(3).getNom());
        }
        if (listPlayer.size()==3){
            perso1.setText(listPlayer.get(0).getNom());
            perso2.setText(listPlayer.get(1).getNom());
            perso3.setText(listPlayer.get(2).getNom());
        }
        if (listPlayer.size()==2){
            perso1.setText(listPlayer.get(0).getNom());
            perso2.setText(listPlayer.get(1).getNom());
        }
        if (listPlayer.size()==1){
            perso1.setText(listPlayer.get(0).getNom());
        }
        this.combattant = listPlayer.get(0);
//        int compt = 0;
//        for (Pnj player:listPlayer) {
//            for (Button btn: listBtnPlayer) {
//                if (btn.getText().equals(player.getNom())) {
//                    btn.setTextFill(Paint.valueOf("red"));
//                }
//                pv.setText(player.getEntite().getPV().getPv().toString());
//                boolean moveset = false;
//                while(!moveset){
//                   if (this.move.size()==1){
//                       moveset=true;
//                   }
//                }
//                btn.setTextFill(Paint.valueOf("black"));
//            }
//
//        }
    }




    @FXML
    private void atkPhy() throws Exception {//
        gridInventaire.setVisible(false);
        gridAtk.setVisible(true);
        btnAtk1.setText(combattant.getEntite().getMovesPhy().getMove(0).getNom());
        btnAtk2.setText(combattant.getEntite().getMovesPhy().getMove(1).getNom());
        btnAtk3.setText(combattant.getEntite().getMovesPhy().getMove(2).getNom());
        btnAtk4.setText(combattant.getEntite().getMovesPhy().getMove(3).getNom());
        selecGenre=0;
        selectionAtk="RIEN";
    }

    @FXML
    private void atkSpe() throws Exception {//
        gridInventaire.setVisible(false);
        gridAtk.setVisible(true);
        btnAtk1.setText(combattant.getEntite().getMovesSpe().getMove(0).getNom());
        btnAtk2.setText(combattant.getEntite().getMovesSpe().getMove(1).getNom());
        btnAtk3.setText(combattant.getEntite().getMovesSpe().getMove(2).getNom());
        btnAtk4.setText(combattant.getEntite().getMovesSpe().getMove(3).getNom());
        selecGenre=1;
        selectionAtk="RIEN";
    }

    @FXML
    private void inventaire() throws Exception {//
        gridAtk.setVisible(false);
        gridInventaire.setVisible(true);
    }

    @FXML
    public void useBtnAtk1() throws Exception {
        Integer cibleRandom = ThreadLocalRandom.current().nextInt(0, 4);
        selectionAtk=""+selecGenre+0+cibleRandom.toString();
    }

    @FXML
    public void useBtnAtk2() throws Exception {
        Integer cibleRandom = ThreadLocalRandom.current().nextInt(0, 4);
        selectionAtk=""+selecGenre+1+cibleRandom.toString();
    }

    @FXML
    public void useBtnAtk3() throws Exception {
        Integer cibleRandom = ThreadLocalRandom.current().nextInt(0, 4);
        selectionAtk=""+selecGenre+2+cibleRandom.toString();
    }

    @FXML
    public void useBtnAtk4() throws Exception {
        Integer cibleRandom = ThreadLocalRandom.current().nextInt(0, 4);
        selectionAtk=""+selecGenre+3+cibleRandom.toString();
    }


    public void fuite(ActionEvent actionEvent) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("testMenuThomas.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public static String getSelectionAtk(){
        return selectionAtk;
    }
    public static void setSelectionAtk(String modif){
        selectionAtk="RIEN";
    }

//    public void selectPerso1(ActionEvent actionEvent) {
//        this.combattant = listPlayer.get(0);
//        gridAtk.setVisible(false);
//        perso1.setTextFill(Paint.valueOf("red"));
//        perso2.setTextFill(Paint.valueOf("black"));
//        perso3.setTextFill(Paint.valueOf("black"));
//        perso4.setTextFill(Paint.valueOf("black"));
//        perso5.setTextFill(Paint.valueOf("black"));
//        pv.setText(combattant.getEntite().getPV().getPv().toString());
//    }
//    public void selectPerso2(ActionEvent actionEvent) {
//        if (listPlayer.size() >= 2){
//            this.combattant = listPlayer.get(1);
//            gridAtk.setVisible(false);
//            perso1.setTextFill(Paint.valueOf("black"));
//            perso2.setTextFill(Paint.valueOf("red"));
//            perso3.setTextFill(Paint.valueOf("black"));
//            perso4.setTextFill(Paint.valueOf("black"));
//            perso5.setTextFill(Paint.valueOf("black"));
//            pv.setText(combattant.getEntite().getPV().getPv().toString());
//        }
//
//    }
//    public void selectPerso3(ActionEvent actionEvent) {
//        if (listPlayer.size() >= 3){
//            this.combattant = listPlayer.get(2);
//            gridAtk.setVisible(false);
//            perso1.setTextFill(Paint.valueOf("black"));
//            perso2.setTextFill(Paint.valueOf("black"));
//            perso3.setTextFill(Paint.valueOf("red"));
//            perso4.setTextFill(Paint.valueOf("black"));
//            perso5.setTextFill(Paint.valueOf("black"));
//            pv.setText(combattant.getEntite().getPV().getPv().toString());
//        }
//    }
//    public void selectPerso4(ActionEvent actionEvent) {
//        if (listPlayer.size() >= 4){
//            this.combattant = listPlayer.get(3);
//            gridAtk.setVisible(false);
//            perso1.setTextFill(Paint.valueOf("black"));
//            perso2.setTextFill(Paint.valueOf("black"));
//            perso3.setTextFill(Paint.valueOf("black"));
//            perso4.setTextFill(Paint.valueOf("red"));
//            perso5.setTextFill(Paint.valueOf("black"));
//            pv.setText(combattant.getEntite().getPV().getPv().toString());
//        }
//    }
//    public void selectPerso5(ActionEvent actionEvent) {
//        if (listPlayer.size() == 5){
//            this.combattant = listPlayer.get(4);
//            gridAtk.setVisible(false);
//            perso1.setTextFill(Paint.valueOf("black"));
//            perso2.setTextFill(Paint.valueOf("black"));
//            perso3.setTextFill(Paint.valueOf("black"));
//            perso4.setTextFill(Paint.valueOf("black"));
//            perso5.setTextFill(Paint.valueOf("red"));
//            pv.setText(combattant.getEntite().getPV().getPv().toString());
//        }
//    }



}