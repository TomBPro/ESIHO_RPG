package GameData.Ressources.Contenu;

public class Map {
    private String id;
    private Integer largeur;
    private Integer hauteur;
    private Layer coucheBase;
    private Layer couche2;
    private Layer couche3;
    private Pnj coucheFin;

    public Map(String id, Integer largeur, Integer hauteur){
        this.id=id;
        this.largeur=largeur;
        this.hauteur=hauteur;
    }



}
