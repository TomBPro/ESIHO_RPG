package sample;

//import GameData.Ressources.Cheats.Engine;
//import GameData.Ressources.Contenu.InitContenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainActivity extends Application {
    //public InitContenu contenuJeu;
    private Stage primeStage;
    private Scene sceneTitre, sceneCredits;
    //private Engine cheat;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primeStage = primaryStage;
        this.sceneTitre= new Scene(FXMLLoader.load(getClass().getResource("ecranTitre.fxml")));
        this.sceneCredits= new Scene(FXMLLoader.load(getClass().getResource("ecranCrdts.fxml")));
        primeStage.setTitle("ESIHO");
        ecranTitre();
    }


    public void main(String[] args) {
        launch(args);

        //this.contenuJeu = new InitContenu();
        Boolean endGame = false;
        while (endGame==false){

        }
    }

    protected void ecranCredits() throws Exception {//affiche l'écran des crédits
        primeStage = new Stage();
        primeStage.setScene(sceneCredits);
        primeStage.show();
    }

    protected void ecranTitre() throws Exception {//affiche l'écran titre
        primeStage = new Stage();
        primeStage.setScene(sceneTitre);
        primeStage.show();
    }


    /*public InitContenu getContenuJeu() {
        return contenuJeu;
    }

    public void setContenuJeu(InitContenu contenuJeu) {
        this.contenuJeu = contenuJeu;
    }*/
}
