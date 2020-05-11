package GameData.Ressources.Contenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Layer{//Une couche de
    private Tile gridTiles[][];

    public Layer(Integer x, Integer y, String nomMap, String nbCouche){
        this.gridTiles = new Tile[x][y];
        mapReader(nomMap,nbCouche, x, y);
    }

    public Tile getTile(Integer x, Integer y) {
        return gridTiles[x][y];
    }

    public void setGridTiles(Tile tile, Integer x, Integer y) {
        this.gridTiles[x][y] = tile;
    }

    private void mapReader(String nomMap, String nbLayer, Integer longueur, Integer hauteur){
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Contenu","Maps","map_"+nomMap,"layer_"+nomMap+"_"+nbLayer+".txt");
        try(BufferedReader br = new BufferedReader(new FileReader(cheminImage.toString()))){
            String ligneActuelle = br.readLine();
            Integer compteurLignes = 0;
            while (ligneActuelle!=null){
                if (ligneActuelle.isEmpty()){
                    continue;
                }else{
                    String listeValeurString[] = ligneActuelle.trim().split(" ");
                    Integer a = 0;
                    for (String valeur:listeValeurString) {
                        //System.out.print(" "+valeur);
                        gridTiles[a][compteurLignes] = readTile(valeur);
                        a++;
                    }
                    //System.out.println("");
                }
                ligneActuelle = br.readLine();
            }
        }catch (Exception erreur_lecture_fichier){
            //System.out.println("Le fichier n'a pas pu être lu");
        }
    }

    private Tile readTile(String tileCode){
        Tile tile = null;
        try{
            String[] codeTileset = tileCode.split("-");
            switch (codeTileset[0]){
                case "0":
                    tile = InitContenu.listeTileset.get(0).getTile(Integer.parseInt(codeTileset[1]));
                    break;
                case "1":
                    //tile = InitContenu.listeTileset.get(1).getTile(Integer.parseInt(codeTileset[1]));
                    break;
                case "2":
                    //tile = InitContenu.listeTileset.get(2).getTile(Integer.parseInt(codeTileset[1]));
                    break;
                case "V":
                    tile = Tile.tileVide();
                    break;
                default:
                    tile = Tile.tileVide();
            }
        }catch(Exception erreur_lecture_tile_map){
            System.out.println("La couche de la map ne doit pas être bien écrite");
        }
        return tile;
    }
}
