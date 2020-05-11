package GameData.Ressources.Contenu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Layer{//Une couche de
    public ArrayList<ArrayList<Tile>> gridTiles;
    private Integer width;
    private Integer height;

    public Layer(Integer x, Integer y, String nomMap, String nbCouche){
        this.gridTiles = new ArrayList<>();
        this.width = x;
        this.height = y;
        for (int a = 0; a<width; a++){
            gridTiles.add(new ArrayList<>());
        }
        mapReader(nomMap,nbCouche);
//        for (ArrayList<Tile> column:gridTiles) {
//            for (Tile tile:column) {
//                System.out.print(tile.getId());
//            }
//            System.out.println("a");
//        }
    }

    public Tile getTile(Integer x, Integer y) {
        return gridTiles.get(x).get(y);
    }

    public void addGridTiles(Tile tile, Integer x) {
        gridTiles.get(x).add(tile);
    }

    public void setGridTiles(Tile tile, Integer x, Integer y){
        gridTiles.get(x).set(y, tile);
    }

    private void mapReader(String nomMap, String nbLayer){
        Path chemin = Paths.get(System.getProperty("user.dir"));
        Path cheminImage = Paths.get(chemin.toString(), "src", "GameData","Ressources","Contenu","Maps","map_"+nomMap,"layer_"+nomMap+"_"+nbLayer+".txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(cheminImage.toString()));
            String ligneActuelle = br.readLine();
            Integer compteurLignes = 0;
            while (ligneActuelle!=null){
                if (ligneActuelle.isEmpty()){
                    continue;
                }else{
                    String listeValeurString[] = ligneActuelle.trim().split(" ");
                    int a = 0;
                    for (String valeur:listeValeurString) {
                        //System.out.print(" "+valeur);
                        Tile tile = readTile(valeur);
                        addGridTiles(tile, a);
                        //gridTiles.get(a).set(compteurLignes, readTile(valeur));
                        a++;
                    }
                    //System.out.println("");
                }
                ligneActuelle = br.readLine();
                compteurLignes++;
            }
        }catch (Exception erreur_lecture_fichier){
            System.out.println("Erreur : Le fichier n'a pas pu être lu");
        }
    }

    private Tile readTile(String tileCode){
        Tile tile = null;
        try{
            String[] codeTileset = tileCode.split("-");
            try{
                tile = InitContenu.listeTileset.get(Integer.parseInt(codeTileset[0])).getTile(Integer.parseInt(codeTileset[1]));
            }catch (Exception erreur_transcription_nom_tile_map){
                tile = InitContenu.listeTileset.get(10).getTile(33);
            }
//            switch (codeTileset[0]){
//                case "0":
//                    tile = InitContenu.listeTileset.get(0).getTile(Integer.parseInt(codeTileset[1]));
//                    break;
//                case "1":
//                    //tile = InitContenu.listeTileset.get(1).getTile(Integer.parseInt(codeTileset[1]));
//                    break;
//                case "2":
//                    //tile = InitContenu.listeTileset.get(2).getTile(Integer.parseInt(codeTileset[1]));
//                    break;
//                case "V":
//                    tile = Tile.tileVide();
//                    break;
//                default:
//                    tile = Tile.tileVide();
//            }
        }catch(Exception erreur_lecture_tile_map){
            System.out.println("La couche de la map ne doit pas être bien écrite");
        }
        return tile;
    }
}
