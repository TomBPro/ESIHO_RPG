package Test;

import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Layer;

import java.io.IOException;

public class TestTomR {
    public static void main(String[] args){
        InitContenu contenu = new InitContenu();
        Layer couche = new Layer(16, 8, "test", "0");
        Layer couche2 = new Layer(16, 8, "test", "1");
    }
}
