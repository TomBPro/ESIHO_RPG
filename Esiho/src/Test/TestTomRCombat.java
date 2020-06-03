package Test;

import GameData.Combat.Combat;
import GameData.Combat.Entities.Team;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
        GridPane rootSprites = new GridPane();
        Integer compteur = 0;
        team1Cv = new Canvas(Math.round(stageWidth/2), Math.round(stageHeight/1.5));
        Integer sizeT1 = Math.toIntExact(Math.round(stageHeight * 0.666));
        sizeT1=Math.round(sizeT1/team1.getListePNJ().size());
        for (Pnj pnj: team1.getListePNJ()) {
            team1Cv.getGraphicsContext2D().drawImage(new ImageView(pnj.getEntite().getImage()).getImage(), stageWidth/2, compteur*sizeT1);
            compteur++;
        }
        rootSprites.add(team1Cv, 0, 0);
        compteur = 0;
        team2Cv = new Canvas(Math.round(stageWidth/2), Math.round(stageHeight/1.5));
        Integer sizeT2 = Math.toIntExact(Math.round(stageHeight * 0.666));
        sizeT2=Math.round(sizeT2/team2.getListePNJ().size());
        for (Pnj pnj: team2.getListePNJ()) {
            team2Cv.getGraphicsContext2D().drawImage(new ImageView(pnj.getEntite().getImage()).getImage(), stageWidth/2, compteur*sizeT2);
            if (pnj.getEntite().getImage()==null){
                System.out.println("AH");
            }
            compteur++;
        }
        rootSprites.add(team2Cv, 1, 0);
        root.add(rootSprites, 0, 0);

        GridPane rootBtn = new GridPane();
        rootBtn.add(cbtPane, 0, 0, 2, 4);
        Button btn1 = new Button();
        btn1.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn1.setText("Bouton 1");
        rootBtn.add(btn1, 0, 0);
        Button btn2 = new Button();
        btn2.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn2.setText("Bouton 2");
        rootBtn.add(btn2, 0, 1);
        Button btn3 = new Button();
        btn3.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn3.setText("Bouton 3");
        rootBtn.add(btn3, 1, 0);
        Button btn4 = new Button();
        btn4.setPrefSize(Math.round(stageWidth/2), Math.round(stageHeight/6));
        btn4.setText("Bouton 4");
        rootBtn.add(btn4, 1, 1);
        root.add(rootBtn, 0, 1);

        this.cbtScene= new Scene(root, stageWidth, stageHeight);

        primStage.setScene(cbtScene);
        primStage.show();
    }
}
