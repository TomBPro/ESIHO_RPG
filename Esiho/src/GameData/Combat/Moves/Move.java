package GameData.Combat.Moves;

import GameData.Combat.Types.*;

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

    public static Move vide(){
        Move move = new Move("A0", "", "PHYSIQUE", 0, new Normal(), 0);
        return move;
    }

    public static Move coupPoing(){
        Move move = new Move("A1", "Coup de poing", "PHYSIQUE", 40, new Normal(), 95);
        return move;
    }

    public static Move coupEpee(){
        Move move = new Move("A2", "Coup d'épée", "PHYSIQUE", 85, new Normal(), 85);
        return move;
    }

    public static Move lameHerbe(){
        Move move = new Move("A3", "Lame d'herbe", "PHYSIQUE", 80, new Plante(), 90);
        return move;
    }

    public static Move lameFeu(){
        Move move = new Move("A4", "Lame de feu", "PHYSIQUE", 90, new Feu(), 80);
        return move;
    }

    public static Move lameEau(){
        Move move = new Move("A5", "Lame d'eau", "PHYSIQUE", 85, new Eau(), 85);
        return move;
    }

    public static Move feuillesLancer(){
        Move move = new Move("A6", "Feuilles à lancer", "SPECIAL", 80, new Plante(), 90);
        return move;
    }

    public static Move lanceFlammes(){
        Move move = new Move("A7", "Lance-Flammes", "SPECIAL", 90, new Feu(), 80);
        return move;
    }

    public static Move cannonEau(){
        Move move = new Move("A8", "Cannon à Eau", "SPECIAL", 85, new Eau(), 85);
        return move;
    }

    public static Move tirFleche(){
        Move move = new Move("A9", "Tir de flèche", "SPECIAL", 80, new Normal(), 85);
        return move;
    }

    public static Move flecheEpines(){
        Move move = new Move("A10", "Flèche d'épines", "SPECIAL", 80, new Plante(), 90);
        return move;
    }

    public static Move flecheEau(){
        Move move = new Move("A11", "Flèche d'eau", "SPECIAL", 90, new Normal(), 80);
        return move;
    }

    public static Move flecheFeu(){
        Move move = new Move("A12", "Flèche de feu", "SPECIAL", 85, new Normal(), 85);
        return move;
    }
}

