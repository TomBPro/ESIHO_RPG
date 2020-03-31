package GameData.Ressources.Contenu;

public class Map {
    private String id;
    private Decor gridDecor[][];
    private Pnj gridPnj[][];

    public Map(String id, Integer x, Integer y) {
        this.id = id;
        this.gridDecor = new Decor[x][y];
        this.gridPnj = new Pnj[x][y];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Decor getDecor(Integer x, Integer y) {
        return gridDecor[x][y];
    }

    public void setGridDecor(Decor decor, Integer x, Integer y) {
        this.gridDecor[x][y] = decor;
    }

    public Pnj getGridPnj(Integer x, Integer y) {
        return gridPnj[x][y];
    }

    public void setGridPnj(Pnj pnj, Integer x, Integer y) {
        this.gridPnj[x][y]= pnj;
    }
}
