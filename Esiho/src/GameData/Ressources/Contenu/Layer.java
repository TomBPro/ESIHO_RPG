package GameData.Ressources.Contenu;

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
}
