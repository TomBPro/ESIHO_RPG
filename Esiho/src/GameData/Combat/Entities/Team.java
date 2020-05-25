package GameData.Combat.Entities;

import GameData.Default.Inventaire;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.InitContenu;
import GameData.Ressources.Contenu.Pnj;

import java.util.ArrayList;

public class Team {
    private String id;
    private ArrayList<Pnj> listePNJ;
    private Inventaire inventaire;
    private Integer argent;
    private String position;

    public Team(String id, Integer argent, ArrayList<Item> inventaire){
        this.id=id;
        this.argent=argent;
        this.inventaire=new Inventaire(new ArrayList<>());
    }

    public Team(String id, Integer argent){
        this.id=id;
        this.argent=argent;
        this.inventaire=new Inventaire();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addPNJ(Pnj pnjAjoute){
        this.listePNJ.add(pnjAjoute);
    }

    public void removePNJ(Pnj pnjEnleve){
        this.listePNJ.remove(pnjEnleve);
    }

    public Inventaire getInventaire(){
        return inventaire;
    }

    public ArrayList<Pnj> getListePNJ() {
        return listePNJ;
    }

    public void addArgent(Integer argentAjoutee){
        this.argent+=argentAjoutee;
    }

    public void removeArgent(Integer argentRetiree){
        if (this.argent-argentRetiree>=0){//Si le résultat de la déduction est supérieur ou égal à zero
            this.argent-=argentRetiree;
        }/*S'il n'y a pas assez d'argent pour en déduire*/else{
            this.argent=0;
        }
    }

    public Integer getArgent(){
        return this.argent;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static Team getTeam(String id){
        Team team;
        Integer idNum = 0;
        try{
            idNum = Integer.parseInt(id.substring(1));
        }catch (Exception erreur_transtypage_getTeam){
            System.out.println("Erreur lors du transtypage de chaine de caractère en Integer à getTeam");
        }
        switch (idNum){
            case 0:
                if (!isTeamInArray(idNum)){
                    team = Team.teamJoueur();
                    InitContenu.listeTeams.set(idNum, team);
                }else{
                    team = InitContenu.listeTeams.get(idNum);
                }
                break;
            default:
                team = teamJoueur();
        }
        return team;
    }

    public static Boolean isTeamInArray(Integer position){
        try{
            Boolean exist = false;
            if (InitContenu.listeTeams.get(position)!=null){
                exist=true;
            }
            return exist;
        }catch (Exception erreur_lecture_liste_tileset){
            System.out.println("Il y a eu une erreur dans la lecture de la liste des Tilesets.");
        }
        return null;
    }

    public static Team teamJoueur(){
        Team team = new Team("T0", 50, new ArrayList<>());
        team.addPNJ(Pnj.joueur("Maurice"));
        return team;
    }
}
