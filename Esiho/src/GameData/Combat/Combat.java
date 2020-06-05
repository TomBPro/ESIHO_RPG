package GameData.Combat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import GameData.Combat.Moves.MoveList;
import sample.launcher;
import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.Move;
import GameData.Combat.Entities.Entity;
import GameData.Combat.Types.Eau;
import GameData.Combat.Types.Types;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.Pnj;
import Test.oldTestThomas.TestControleurCombatThomas;

public class Combat {
    public Team team1;
    public Team team2;
    private Integer tour;
    private Integer tourDeTable;
    private Boolean fin;
    private ArrayList<Pnj> listeOrdrePnj;
    private ArrayList<Pnj> pnjsALancer;
    private ArrayList<Move> movesALancer;
    private ArrayList<Pnj> pnjsARecevoir;

    public Combat(Team team1, Team team2){
        this.team1=team1;
        this.team2=team2;
        this.tour = 0;
        this.tourDeTable = 0;
        this.fin = false;
        this.listeOrdrePnj = new ArrayList<>();
    }

//    public void affichage(){//Actualisation des données affichées à l'écran
//    }

    public void start(){
        Integer victoire = 0;
    }

    private void newTourdeTable(){
        this.listeOrdrePnj = triVitesse();
        tourDeTable++;
    }

    private void newTour(){
        this.pnjsALancer = new ArrayList<>();
        this.movesALancer = new ArrayList<>();
        this.pnjsARecevoir = new ArrayList<>();
        this.tour++;
    }

    public Integer tour(){
        Pnj pnjPlay = listeOrdrePnj.get(tour);
        Boolean isPnjAllie = false;
        if (pnjsALancer.contains(pnjPlay)){
            isPnjAllie=true;
        }
        if (pnjPlay.getEntite().getPV().getlvlpv()!=0){
            if (isPnjAllie){
                Integer rang = pnjsALancer.indexOf(pnjPlay);
                team2.getListePNJ().get(team2.getListePNJ().indexOf(pnjsARecevoir.get(rang))).setEntite(useMove(movesALancer.get(rang), pnjsALancer.get(rang).getEntite(), pnjsARecevoir.get(rang).getEntite()));
            }else{
                Integer genre = ThreadLocalRandom.current().nextInt(0, 1);
                MoveList moveList;
                if (genre == 0){
                    moveList = pnjPlay.getEntite().getMovesPhy();
                }else{
                    moveList = pnjPlay.getEntite().getMovesSpe();
                }
                Move move;
                if (moveList.getSize()!=0){
                    Integer movePtr = ThreadLocalRandom.current().nextInt(0, moveList.getSize()-1);
                    move = moveList.getMove(movePtr);
                }else{
                    move = Move.coupPoing();
                }
                ArrayList<Integer> cibles = new ArrayList<>();
                Integer compteur = 0;
                for (Pnj pnj:team1.getListePNJ()){
                    if (pnj.getEntite().getPV().getlvlpv()>0){
                        cibles.add(compteur);
                    }
                    compteur++;
                }
                Integer ciblePtr = ThreadLocalRandom.current().nextInt(0, cibles.size()-1);
                Pnj cible = team1.getListePNJ().get(ciblePtr);
                team1.getListePNJ().get(team1.getListePNJ().indexOf(cible)).setEntite(useMove(move, pnjPlay.getEntite(), cible.getEntite()));
            }
        }
        Integer victoire = analyseVictoire(team1, team2);
        if (victoire!=0){
            this.fin = true;
            fin(victoire);
        }

        newTour();
        Double reste = 0.0;
        if (listeOrdrePnj.size()!=0){
            reste = new Double(this.tour%listeOrdrePnj.size());
        }
        if (reste == 0){
            newTourdeTable();
        }
        return victoire;
    }

    public void selectMove(Pnj pnjThrower, Move moveSelected, Pnj pnjReceiver){
        this.pnjsALancer.add(pnjThrower);
        this.movesALancer.add(moveSelected);
        this.pnjsARecevoir.add(pnjReceiver);
    }

    private ArrayList<Pnj> triVitesse(){
        ArrayList<Pnj> listePnjsVitesse;
        if (this.listeOrdrePnj.size()==0){
            listePnjsVitesse = new ArrayList<>();
            for (Pnj pnjAjoute:team1.getListePNJ()) {
                listePnjsVitesse.add(pnjAjoute);
            }
            for (Pnj pnjAjoute:team2.getListePNJ()) {
                listePnjsVitesse.add(pnjAjoute);
            }
        }else{
             listePnjsVitesse = this.listeOrdrePnj;
        }

        Integer compteurCompare = 0;
        for (Pnj pnjCompare:listePnjsVitesse) {
            Integer compteurComparant = 0;
            Integer vitesseCompare = pnjCompare.getEntite().getVitesse();
            for (Pnj pnjComparant:listePnjsVitesse) {
                Integer vitesseComparante = pnjComparant.getEntite().getVitesse();
                if (vitesseCompare>=vitesseComparante){
                    Pnj comparant = pnjComparant;
                    Pnj compare = pnjCompare;
                    listePnjsVitesse.remove(pnjComparant);
                    listePnjsVitesse.add(compteurComparant, pnjCompare);
                    listePnjsVitesse.remove(pnjCompare);
                    listePnjsVitesse.add(compteurCompare, pnjComparant);
                }/*Si la vitesse comparante est supérieure ou égale*/else if (vitesseCompare<vitesseComparante){
                    Pnj comparant = pnjComparant;
                    Pnj compare = pnjCompare;
                    listePnjsVitesse.remove(pnjComparant);
                    listePnjsVitesse.add(compteurCompare, pnjCompare);
                    listePnjsVitesse.remove(pnjCompare);
                    listePnjsVitesse.add(compteurComparant, pnjComparant);
                }//Si la vitesse comparée est supérieure
                compteurComparant++;
            }
            compteurCompare++;
        }//On trie les PNJs dans l'ordre de leur attaques pour savoir qui est plus ou moins rapide

        return listePnjsVitesse;
    }

    private void fin(Integer victoire){
        if (victoire==1){
            //Réussite !
            for (Item objet:team2.getInventaire().getInventaire()) {
                team1.getInventaire().addItem(objet);
            }//Pillage des objets de l'équipe adverse
            team1.addArgent(team2.getArgent()/2);//Pillage de la moitié de l'argent de l'équipe adverse
            Integer xpObtenu = 0;
            for (Pnj pnjEnnemis:team2.getListePNJ()) {
                xpObtenu+=pnjEnnemis.getEntite().getXp();
            }//On récupère la somme d'xp de l'équipe adversaire
            Integer compteur = 0;
            for (Pnj pnjAllie:team1.getListePNJ()){
                pnjAllie.getEntite().addXp((Integer) xpObtenu/team1.getListePNJ().size());
                team1.getListePNJ().set(compteur, pnjAllie);
                compteur++;
            }//Ajout de l'xp sur chaque entité de l'équipe alliée
            fin=true;
        }else if (victoire==-1){
            //Défaite !
            fin=true;
        }
    }

    public Integer analyseVictoire(Team team1, Team team2){
        Integer victoire = 0;
        Integer pvAllie = 0;
        Integer pvEnnemis = 0;
        //Analyse des PV alliés
        for (Pnj allie:team1.getListePNJ()) {
            pvAllie += allie.getEntite().getPV().getPv();
        }
        //Analyse des PV ennemis
        for (Pnj ennemis:team2.getListePNJ()) {
            pvEnnemis += ennemis.getEntite().getPV().getPv();
        }
        if (pvAllie>0 && pvEnnemis>0){
            victoire=0;
        }else if (pvAllie>0 && pvEnnemis==0){
            victoire=1;
        }else if (pvAllie==0 && pvEnnemis>0){
            victoire=-1;
        }else{
            victoire=0;
        }
        return victoire;
    }

//    public void testMort(){
//        if (analyseVictoire(team1,team2)==-1){
//            launcher.ecranMortRespawn();
//        }
//    }

    public Entity useMove(Move move, Entity entityThrow, Entity entityReceiver){
        Entity entiteModifiee;
        String genre=move.getGenre();
        if (genre.equals("SPECIAL")){
            double dommages=2+(2*entityThrow.getLvl())/5;
            dommages*=move.getPuissance();
            dommages*=entityThrow.getAttspe()/entityReceiver.getDefspe();
            dommages/=50;
            dommages+=2;
            dommages*=getModifier(move, entityThrow, entityReceiver);//Faire une méthode analysant les types alliés et ennemis
            entityReceiver.getPV().degatsPVabs((int)dommages);
            entiteModifiee = entityReceiver;
        }else if (genre.equals("PHYSIQUE")){
            double dommages=2+(2*entityThrow.getLvl())/5;
            dommages*=move.getPuissance();
            dommages*=entityThrow.getAtt()/entityReceiver.getDef();
            dommages/=50;
            dommages+=2;
            dommages*=getModifier(move, entityThrow, entityReceiver);//Faire une méthode analysant les types alliés et ennemis
            entityReceiver.getPV().degatsPVabs((int)dommages);
            entiteModifiee = entityReceiver;
        }else{
            entiteModifiee = entityReceiver;
        }
        return entiteModifiee;
    }

    public Double getModifier(Move move, Entity entityThrow, Entity entityReceiver){
        double modifier = 1.0;
        Types moveType = move.getType();
        Types typeReceiver = entityReceiver.getType();
        ArrayList<Types> faiblesses = moveType.getWeaknesses();

        for (Types typeCompare:faiblesses) {
            if (typeCompare.getNomType().equals(typeReceiver.getNomType())){
                modifier = 0.5;//PAS TRÈS EFFICACE !
            }
        }
        ArrayList<Types> forces = moveType.getStrengths();

        for (Types typeCompare:forces) {
            if (typeCompare.getNomType().equals(typeReceiver.getNomType())){
                modifier = 2;//SUPER EFFICACE
            }
        }

        Types typeThrower = entityThrow.getType();
        if (typeThrower.equals(moveType)){
            modifier*=1.5;//STAB
        }

        if (entityThrow.getArme()!=null){
            modifier*=entityThrow.getArme().getCoeffDegats();
        }//Coefficient de l'arme appliqué

        if(entityReceiver.getArmure()!=null){
            modifier*=entityReceiver.getArmure().getCoeffProtection();
        }//Coefficient de l'arme appliqué

        return modifier;
    }

    public Integer getTour() {
        return tour;
    }

    public void setTour(Integer tour) {
        this.tour = tour;
    }
}
