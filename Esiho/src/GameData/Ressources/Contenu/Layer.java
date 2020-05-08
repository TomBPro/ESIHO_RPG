package GameData.Ressources.Contenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Layer{
    private Tile gridTiles[][];

    public Layer(Integer x, Integer y) {
        this.gridTiles = new Tile[x][y];
    }

    public Tile getTile(Integer x, Integer y) {
        return gridTiles[x][y];
    }

    public void setGridTiles(Tile tile, Integer x, Integer y) {
        this.gridTiles[x][y] = tile;
    }

    private void mapReader(String nomMap, String nbLayer){
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
                        gridTiles[compteurLignes][a] = readTile(valeur);
                        a++;
                    }
                }
            }
        }catch (Exception erreur_lecture_fichier){
            System.out.println("Le fichier n'a pas pu être lu");
        }
    }

    private Tile readTile(String tileCode){
        Tile tile = null;
        try{
            String[] codeTileset = tileCode.split("-");
            switch (codeTileset[0]){
                case "0":
                    tile = Tileset.getTileset0().getTile(Integer.parseInt(codeTileset[1]));
                    break;
                case "1":
                    //tile = Tileset.getTileset1().getTile(Integer.parseInt(codeTileset[1]));
                    break;
                case "2":
                    //tile = Tileset.getTileset2().getTile(Integer.parseInt(codeTileset[1]));
                    break;
                default:
                    tile = Tileset.getTileset0().getTile(Integer.parseInt(codeTileset[10]));
            }
        }catch(Exception erreur_lecture_tile_map){
            System.out.println("La couche de la map ne doit pas être bien écrite");
        }
        return tile;
    }
}
