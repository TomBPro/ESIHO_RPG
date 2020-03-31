package GameData.Combat.Moves;

import GameData.Combat.Types.Types;

public class Move {
    private String id;
    private String nom;
    private String genre;
    private Integer puissance;
    private Types type;
    private Integer precision;

    public Move(String id, String nom, String genre, Integer puissance, Types type, Integer precision) {
        this.id=id;
        this.nom=nom;
        this.genre=genre;
        this.puissance = puissance;
        this.type = type;
        this.precision=precision;
    }

    public Move(String id, String nom, String genre, Types type, Integer precision){
        this.id=id;
        this.nom=nom;
        this.genre=genre;
        this.type = type;
        this.precision=precision;
    }

    public Move(String id, String nom, String genre, Types type){
        this.id=id;
        this.nom=nom;
        this.genre=genre;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public void setPuissance(Integer puissance) {
        this.puissance = puissance;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

