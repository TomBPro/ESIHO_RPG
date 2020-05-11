package GameData.Ressources.Contenu;

public class Map {
    private String id;
    private Integer largeur;
    private Integer hauteur;
    private Layer coucheBase;
    private Layer couche2;
    private Layer couche3;
    private Pnj coucheFin;

    public Map(String id, Integer largeur, Integer hauteur, Layer coucheBase, Layer couche2, Layer couche3){
        this.id=id;
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.coucheBase=coucheBase;
        this.couche2=couche2;
        this.couche3=couche3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Pnj getCoucheFin() {
        return coucheFin;
    }

    public void setCoucheFin(Pnj coucheFin) {
        this.coucheFin = coucheFin;
    }
}
