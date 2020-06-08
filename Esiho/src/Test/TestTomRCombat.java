package Test;

import GameData.Combat.Combat;
import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.Move;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TestTomRCombat extends Application {
    private Combat combat;
    private Team team1, team2;
    private Scene cbtScene;
    private Stage primStage;
    private Integer stageWidth, stageHeight;
    private Boolean fin;
    private Boolean selection;
    private Boolean memoPhy;
    private Boolean memoSpe;
    private Move atk;
    private Pnj thrower;
    private Pnj cible;
    private Integer pointeurThrower;
    private Label indicateur;
    private GridPane team1Gd, team2Gd;
    private ArrayList<ProgressBar> barAllies;
    private ArrayList<ProgressBar> barEnnemies;

    @Override
    public void start(Stage stage) throws Exception {
        selection = true;
        this.fin = false;
        InitContenu contenu = new InitContenu();
        memoPhy = true;
        memoSpe = false;
        barAllies = new ArrayList<>();
        barEnnemies = new ArrayList<>();
        pointeurThrower = 0;
        if (team1==null && team2==null){
            System.out.println("Au moins une équipe n'est pas déclarée");
            this.team1 = Team.teamJoueur();
            this.team2 = new Team("T1", 20);
            this.team2.addPNJ(Pnj.squelette());
            this.team2.addPNJ(Pnj.rat());
            this.team2.addPNJ(Pnj.petiDiable());
        }
        this.thrower = team1.getListePNJ().get(0);
        this.indicateur = new Label(""+thrower.getNom());
        this.combat = new Combat(team1, team2);

        stageWidth=800;
        stageHeight=400;
        this.primStage = stage;
        primStage.setTitle("Combat");
        GridPane root = new GridPane();
        Integer compteur = 0;
        team1Gd = new GridPane();
        team1Gd.setAlignment(Pos.CENTER);
        team1Gd.setMaxSize(new Double(stageWidth/2), new Double(stageHeight/3)*2);
        for (Pnj pnj: team1.getListePNJ()) {
            GridPane gdPn = new GridPane();

            Label lbl = new Label();
            lbl.setText(""+pnj.getNom()+"   lvl : "+pnj.getEntite().getLvl());
            gdPn.add(lbl, 0, 0);

            ProgressBar bar = new ProgressBar();
            bar.setProgress(pnj.getEntite().getPV().getPv());
            barAllies.add(bar);
            gdPn.add(barAllies.get(compteur), 0, 1);

            Image img = pnj.getEntite().getImage();
            Canvas cv = new Canvas(img.getWidth()*2, img.getHeight()*2);
            cv.getGraphicsContext2D().drawImage(new ImageView(img).getImage(), 0, 0, -img.getWidth(), img.getHeight());

            gdPn.add(cv, 0, 2);
            team1Gd.add(gdPn, 0, compteur);
            compteur++;
        }

        root.add(team1Gd, 0, 0, 1, 1);

        compteur = 0;

        team2Gd = new GridPane();
        team2Gd.setAlignment(Pos.CENTER);
        team2Gd.setMaxSize(new Double(stageWidth/2), new Double(stageHeight/3)*2);
        for (Pnj pnj: team2.getListePNJ()) {
            GridPane gdPn = new GridPane();

            Label lbl = new Label();
            lbl.setText(""+pnj.getNom()+"   lvl : "+pnj.getEntite().getLvl());
            gdPn.add(lbl, 0, 0);

            ProgressBar bar = new ProgressBar();
            bar.setProgress(pnj.getEntite().getPV().getPv());
            barEnnemies.add(bar);
            gdPn.add(barEnnemies.get(compteur), 0, 1);

            Image img = pnj.getEntite().getImage();
            Canvas cv = new Canvas(img.getWidth()*2, img.getHeight()*2);
            cv.getGraphicsContext2D().drawImage(new ImageView(img).getImage(), 0, 0, -img.getWidth(), img.getHeight());

            gdPn.add(cv, 0, 2);
            team2Gd.add(gdPn, 0, compteur);
            compteur++;
        }
        root.add(team2Gd, 1, 0, 1, 1);

        GridPane.setValignment(team2Gd, VPos.CENTER);
        GridPane pnBtn = new GridPane();
        Button btn1 = new Button();
        btn1.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/6));
        btn1.setText("Bouton 1");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (selection){
                    btnAtk(0);
                    selection();
                }
            }
        });
        pnBtn.add(btn1, 0, 0);

        Button btn2 = new Button();
        btn2.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/6));
        btn2.setText("Bouton 2");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (selection){
                    btnAtk(1);
                    selection();
                }
            }
        });
        pnBtn.add(btn2, 1, 0);

        Button btn3 = new Button();
        btn3.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/6));
        btn3.setText("Bouton 3");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (selection){
                    btnAtk(2);
                    selection();
                }
            }
        });
        pnBtn.add(btn3, 0, 1);

        Button btn4 = new Button();
        btn4.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/6));
        btn4.setText("Bouton 4");
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (selection){
                    btnAtk(3);
                    selection();
                }
            }
        });
        pnBtn.add(btn4, 1, 1);


        if (thrower.getEntite().getMovesPhy().getSize()>0){
            btn1.setText(""+thrower.getEntite().getMovesPhy().getMove(0).getNom());
            if (thrower.getEntite().getMovesPhy().getSize()>1){
                btn2.setText(""+thrower.getEntite().getMovesPhy().getMove(1).getNom());
                if (thrower.getEntite().getMovesPhy().getSize()>2){
                    btn3.setText(""+thrower.getEntite().getMovesPhy().getMove(2).getNom());
                    if (thrower.getEntite().getMovesPhy().getSize()>3){
                        btn4.setText(""+thrower.getEntite().getMovesPhy().getMove(3).getNom());
                    }else{
                        btn4.setText("");
                    }
                }else{
                    btn3.setText("");
                }
            }else{
                btn2.setText("");
            }
        }else{
            btn1.setText("");
        }


        root.add(pnBtn, 0, 1, 2, 1);

        GridPane btnCibles = new GridPane();
        compteur = 0;
        for (Pnj cible:team2.getListePNJ()) {
            Button btn = new Button();
            btn.setText(""+cible.getNom());
            btn.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/15));
            Integer finalCompteur = compteur;
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    btnCible(finalCompteur);
                }
            });
            btnCibles.add(btn, 0, compteur);
            compteur++;
        }
        pnBtn.add(btnCibles, 2, 0);

        GridPane btnSlPn = new GridPane();
        btnSlPn.add(this.indicateur, 0, 0);



        Button phy = new Button();
        phy.setText("Attaques Physiques");
        phy.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/12));
        phy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (memoPhy==false){
                    memoPhy=true;
                    memoSpe=false;
                    if (thrower.getEntite().getMovesPhy().getSize()>0){
                        btn1.setText(""+thrower.getEntite().getMovesPhy().getMove(0).getNom());
                        if (thrower.getEntite().getMovesPhy().getSize()>1){
                            btn2.setText(""+thrower.getEntite().getMovesPhy().getMove(1).getNom());
                            if (thrower.getEntite().getMovesPhy().getSize()>2){
                                btn3.setText(""+thrower.getEntite().getMovesPhy().getMove(2).getNom());
                                if (thrower.getEntite().getMovesPhy().getSize()>3){
                                    btn4.setText(""+thrower.getEntite().getMovesPhy().getMove(3).getNom());
                                }else{
                                    btn4.setText("");
                                }
                            }else{
                                btn3.setText("");
                            }
                        }else{
                            btn2.setText("");
                        }
                    }else{
                        btn1.setText("");
                    }
                }
            }
        });
        btnSlPn.add(phy, 0, 1);

        Button spe = new Button();
        spe.setText("Attaques spéciales");
        spe.setPrefSize(Math.round(stageWidth/4), Math.round(stageHeight/12));
        spe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (memoSpe==false){
                    memoSpe=true;
                    memoPhy=false;
                    if (thrower.getEntite().getMovesSpe().getSize()>0){
                        btn1.setText(""+thrower.getEntite().getMovesSpe().getMove(0).getNom());
                        if (thrower.getEntite().getMovesSpe().getSize()>1){
                            btn2.setText(""+thrower.getEntite().getMovesSpe().getMove(1).getNom());
                            if (thrower.getEntite().getMovesSpe().getSize()>2){
                                btn3.setText(""+thrower.getEntite().getMovesSpe().getMove(2).getNom());
                                if (thrower.getEntite().getMovesSpe().getSize()>3){
                                    btn4.setText(""+thrower.getEntite().getMovesSpe().getMove(3).getNom());
                                }else{
                                    btn4.setText("");
                                }
                            }else{
                                btn3.setText("");
                            }
                        }else{
                            btn2.setText("");
                        }
                    }else{
                        btn1.setText("");
                    }
                }
            }
        });
        btnSlPn.add(spe, 0, 2);


        pnBtn.add(btnSlPn,3,0);



        this.cbtScene= new Scene(root, stageWidth, stageHeight, Color.WHITE);



        primStage.setScene(cbtScene);
        primStage.show();
    }

    private void selection(){
        if (this.atk!=null && this.thrower!=null && this.cible!=null && combat.getFin()!=true){
            System.out.println(thrower.getNom());
            combat.selectMove(thrower, atk, cible);
            this.atk=null;


            if (pointeurThrower<team1.getListePNJ().size()-1){
                pointeurThrower++;
            }else{
                pointeurThrower=0;
                Integer tourTableOld = combat.getTourDeTable();
                while (combat.getTourDeTable()==tourTableOld){
                    combat.tour();
                    this.team1=combat.team1;
                    this.team2=combat.team2;

                }
                Integer compteur = 0;
                for (ProgressBar bar:barAllies) {
                    bar.setProgress(team1.getListePNJ().get(compteur).getEntite().getPV().getlvlpv());
                    compteur++;
                }
                compteur = 0;
                for (ProgressBar bar: barEnnemies) {
                    bar.setProgress(team2.getListePNJ().get(compteur).getEntite().getPV().getlvlpv());
                    compteur++;
                }
            }
            this.thrower = team1.getListePNJ().get(this.pointeurThrower);
            this.indicateur.setText(""+thrower.getNom());
            this.cible=null;

        }
    }

    private void btnAtk(Integer cas){
        if (memoPhy){
            this.atk = this.thrower.getEntite().getMovesPhy().getMove(cas);
        }else{
            this.atk = this.thrower.getEntite().getMovesSpe().getMove(cas);
        }
    }

    private void btnCible(Integer cas){
        this.cible = team2.getListePNJ().get(cas);
    }
}
