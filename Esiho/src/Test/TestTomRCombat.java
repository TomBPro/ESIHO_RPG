package Test;

import GameData.Combat.Combat;
import GameData.Combat.Entities.Team;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestTomRCombat extends Application {
    private Combat combat;
    private Team team1, team2;
    private Scene cbtScene;
    private Stage primStage;
    private Integer stageWidth, stageHeight;
    private Canvas cbtPane, team1Cv, team2Cv;

//    public TestTomRCombat(Team team1, Team team2){
//        this.team1 = team1;
//        this.team2 = team2;
//    }


    @Override
    public void start(Stage stage) throws Exception {
        InitContenu contenu = new InitContenu();
        if (team1==null && team2==null){
            System.out.println("Au moins une équipe n'est pas déclarée");
            this.team1 = Team.teamJoueur();
            this.team2 = new Team("T1", 20);
            this.team2.addPNJ(Pnj.squelette());
            this.team2.addPNJ(Pnj.rat());
        }
        this.combat = new Combat(team1, team2);
        stageWidth=800;
        stageHeight=400;
        cbtPane = new Canvas(stageWidth, stageHeight);
        this.primStage = stage;
        primStage.setTitle("Combat");
        GridPane root = new GridPane();
        Integer compteur = 0;
//        double nbmax1 = team1.getListePNJ().get(0).getEntite().getImage().getHeight() * 2 *team1.getListePNJ().size();
//        team1Cv = new Canvas(Math.round(stageWidth/2), Math.round(nbmax1));
        GridPane team1Gd = new GridPane();
//        Integer sizeT1 = Math.toIntExact(Math.round(team1.getListePNJ().size() * team1.getListePNJ().get(0).getEntite().getImage().getHeight() * 1.1 *2));
        for (Pnj pnj: team1.getListePNJ()) {
            GridPane gdPn = new GridPane();

            Label lbl = new Label();
            lbl.setText(""+pnj.getNom()+"   lvl : "+pnj.getEntite().getLvl());
            gdPn.add(lbl, 0, 0);

            ProgressBar bar = new ProgressBar();
            bar.setProgress(pnj.getEntite().getPV().getPv());
            gdPn.add(bar, 0, 1);

            Image img = pnj.getEntite().getImage();
            Canvas cv = new Canvas(img.getWidth()*2, img.getHeight()*2);
            cv.getGraphicsContext2D().drawImage(new ImageView(img).getImage(), 0, 0, -img.getWidth()*2, img.getHeight()*2);

            gdPn.add(cv, 0, 2);
            gdPn.add(new Label("TEST"), 0, 3);
            team1Gd.add(gdPn, 0, compteur);
            compteur++;
        }

        root.add(team1Gd, 0, 0);

        compteur = 0;
//        double nbmax2 = team2.getListePNJ().get(0).getEntite().getImage().getHeight() * 2 *team2.getListePNJ().size();
//        team2Cv = new Canvas(Math.round(stageWidth/2), Math.round(nbmax2));
//        Integer sizeT2 = Math.toIntExact(Math.round(team2.getListePNJ().size() * team2.getListePNJ().get(0).getEntite().getImage().getHeight() * 1.1 *2));
//        sizeT2=Math.round(sizeT2/team2.getListePNJ().size());

        GridPane team2Gd = new GridPane();
        for (Pnj pnj: team2.getListePNJ()) {
            GridPane gdPn = new GridPane();

            Label lbl = new Label();
            lbl.setText(""+pnj.getNom()+"   lvl : "+pnj.getEntite().getLvl());
            gdPn.add(lbl, 0, 0);

            ProgressBar bar = new ProgressBar();
            bar.setProgress(pnj.getEntite().getPV().getPv());
            gdPn.add(bar, 0, 1);

            Image img = pnj.getEntite().getImage();
            Canvas cv = new Canvas(img.getWidth()*2, img.getHeight()*2);
            cv.getGraphicsContext2D().drawImage(new ImageView(img).getImage(), 0, 0, -img.getWidth()*2, img.getHeight()*2);

            gdPn.add(cv, 0, 2);
            gdPn.add(new Label("TEST"), 0, 3);
            team2Gd.add(gdPn, 0, compteur);
            compteur++;
        }
        root.add(team2Gd, 1, 0);
        Button btn1 = new Button();
        btn1.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn1.setText("Bouton 1");
        root.add(btn1, 0, 1);
        Button btn2 = new Button();
        btn2.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn2.setText("Bouton 2");
        root.add(btn2, 1, 1);
        Button btn3 = new Button();
        btn3.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn3.setText("Bouton 3");
        root.add(btn3, 0, 2);
        Button btn4 = new Button();
        btn4.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn4.setText("Bouton 4");
        root.add(btn4, 1, 2);

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case Q:
                        root.getChildren().get(0).setVisible(false);
                        break;
                    case E:
                        root.getChildren().get(1).setVisible(false);
                }
            }
        });

        root.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case Q:
                        root.getChildren().get(0).setVisible(true);
                        break;
                    case E:
                        root.getChildren().get(1).setVisible(true);
                }
            }
        });

        this.cbtScene= new Scene(root, stageWidth, stageHeight, Color.WHITE);



        primStage.setScene(cbtScene);
        primStage.show();
    }
}
