package GameData.Ressources.Contenu;

import Test.EcranCombat;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Map {
    private String id;
    private String nomMap;
    private Integer largeur;
    private Integer hauteur;
    private ArrayList<ArrayList<Integer>> tpPoint;
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
        this.tpPoint = new ArrayList<>();
        this.tpPoint.add(new ArrayList<>());
        this.tpPoint.add(new ArrayList<>());
        this.coucheBase= new Layer(largeur, hauteur, nomMap, "0");
        this.couche2=new Layer(largeur, hauteur, nomMap, "1");
        this.couche3=new Layer(largeur, hauteur, nomMap, "2");
        this.collisionGrid = new Layer(largeur, hauteur, nomMap, "C"); // "C" comme collision
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

    public void addTpPoint(Integer x, Integer y){
        this.tpPoint.get(0).add(x);
        this.tpPoint.get(1).add(y);
    }

    public Integer[] getTpPoint(Integer rangPoint){
        Integer[] sortie = new Integer[2];
        sortie[0] = this.tpPoint.get(0).get(rangPoint);
        sortie[1] = this.tpPoint.get(1).get(rangPoint);
        return sortie;
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
            for (int a = 0; a<1; a++){
                for (int b = 0; b<1; b++){
                    if (this.getCollisionGrid().getTile(newDx+a, newDy+b).getCollision()==true || this.coucheFin.get(newDx+a).get(newDy+b)!=null){
                        collision = true;
                    }
                }
            }
            return collision;
        }catch (Exception erreur_collision){
            System.out.println("Erreur de collision");
            return true;
        }
    }

    public void refreshCollision(){
        Integer a = 0;
        for (ArrayList<Pnj> list: this.coucheFin) {
            Integer b = 0;
            for (Pnj pnj: list){
                if (pnj!=null){
                    Integer x = a+pnj.getAngleX();
                    Integer y = b+pnj.getAngleY();
                    System.out.println("x : "+a+" y : "+b+" newX : "+x+" newY : "+y);
                    collisionGrid.getTile(x, y).setCollision(true);
                }
                b++;
            }
            a++;
        }
    }

    public static Map getMap(String id){
        Integer idMap = 0;
        Map map;
        try{
            idMap = Integer.parseInt(id.substring(1));
        }catch (Exception erreur_transtypage_getMap){
            System.out.println("Erreur lors du transtypage de chaine de caractère en Integer à getTeam");
        }
        switch (idMap){
            case 0:
                map = Map.getMapTest(null, null);
                break;
            case 1:
                map = Map.getMapMaison();
                break;
            default:
                map = Map.getMapTest(null, null);
        }
        return map;
    }

    public static Map getMapTest(EcranCombat ec, Stage stage){
        Map map = new Map("M0", "test", 32,32);
        if (ec!=null && stage!=null){
            map.getCoucheFin().get(6).add(12, Pnj.squelette());
        }else{
            map.getCoucheFin().get(6).set(12, Pnj.getPnj("P1"));
        }
        map.getCoucheFin().get(6).get(12).setAngle(1, 0);
        map.refreshCollision();
        map.addTpPoint(10, 10);
        return map;
    }

    public static Map getMapMaison(){
        Map map = new Map("M1", "maison", 16,16);
        map.addTpPoint(6, 6);
        return map;
    }

    public Stage onInterraction(Integer x, Integer y, Stage stage, EcranCombat ec){
        if (this.getCoucheFin().get(x).get(y)!= null){
            this.getCoucheFin().get(x).get(y).interract();
        }else{
            for (int a = -1; a<2; a++){
                try{
                    for (int b = -1; b<2; b++){
                        try{
                            if (this.getCoucheFin().get(a+x).get(b+y)!=null){
                                Pnj pnj = this.getCoucheFin().get(a+x).get(b+y);
                                if (a+x+pnj.getAngleX() == x && b+y+pnj.getAngleY() == y){
                                    return pnj.interract(stage, ec);
                                }
                            }
                        }catch (Exception erreur_y_out_of_bounds){
                            System.out.println("Y ERROR");
                        }
                    }
                }catch (Exception erreur_x_out_of_bounds){
                    System.out.println("X ERROR");
                }
            }
        }
        return null;
    }
}
