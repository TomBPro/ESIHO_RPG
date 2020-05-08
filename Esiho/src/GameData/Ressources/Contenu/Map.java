package GameData.Ressources.Contenu;

public class Map {
    private String id;
    private Tile gridTiles[][];
    private Pnj gridPnj[][];

    public Map(String id, Integer x, Integer y) {
        this.id = id;
        this.gridTiles = new Tile[x][y];
        this.gridPnj = new Pnj[x][y];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tile getTile(Integer x, Integer y) {
        return gridTiles[x][y];
    }

    public void setGridTiles(Tile tile, Integer x, Integer y) {
        this.gridTiles[x][y] = tile;
    }

    public Pnj getGridPnj(Integer x, Integer y) {
        return gridPnj[x][y];
    }

    public void setGridPnj(Pnj pnj, Integer x, Integer y) {
        this.gridPnj[x][y]= pnj;
    }
}
