package GameData.Ressources.Contenu;

import java.util.ArrayList;

public class Map {
    private String id;
    private String nomMap;
    private Integer largeur;
    private Integer hauteur;
    private Layer coucheBase;
    private Layer couche2;
    private Layer couche3;
    private Layer collisionGrid; //Où False = pas de collision et True = collision
    private ArrayList<ArrayList<Pnj>> coucheFin;

    public Map(String id, String nomMap, Integer largeur, Integer hauteur){
        this.id=id;
        this.nomMap=nomMap;
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.coucheBase= new Layer(largeur, hauteur, nomMap, "0");
        this.couche2=new Layer(largeur, hauteur, nomMap, "1");
        this.couche3=new Layer(largeur, hauteur, nomMap, "2");
        this.collisionGrid = new Layer(largeur, hauteur, nomMap, "C"); // "C" comme collision
        Integer compteur = 0;
        for (ArrayList<Tile> col : collisionGrid.gridTiles){
            for (Tile ele : col){
                if (ele.getCollision()==true){
                    compteur++;
                }
            }
        }
        System.out.println(compteur);
        this.coucheFin= new ArrayList<>();
        for (int a = 0; a<hauteur; a++){
            coucheFin.add(new ArrayList<>());
            for (int b = 0; b<largeur; b++){
                coucheFin.get(a).add(null);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomMap() {
        return nomMap;
    }

    public void setNomMap(String nomMap) {
        this.nomMap = nomMap;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public Layer getCoucheBase() {
        return coucheBase;
    }

    public void setCoucheBase(Layer coucheBase) {
        this.coucheBase = coucheBase;
    }

    public Layer getCouche2() {
        return couche2;
    }

    public void setCouche2(Layer couche2) {
        this.couche2 = couche2;
    }

    public Layer getCouche3() {
        return couche3;
    }

    public void setCouche3(Layer couche3) {
        this.couche3 = couche3;
    }

    public ArrayList<ArrayList<Pnj>> getCoucheFin() {
        return coucheFin;
    }

    public Layer getCollisionGrid() {
        return collisionGrid;
    }

    public Boolean isCollided(Integer newDx, Integer newDy, Integer step){
        Boolean collision = false;
        try{
            newDx/=step;
            newDy/=step;
            if (this.getCollisionGrid().getTile(newDx, newDy).getCollision()==true){
                collision = true;
            }
            return collision;
        }catch (Exception erreur_collision){
            System.out.println("Erreur de collision");
            return true;
        }
    }
}
