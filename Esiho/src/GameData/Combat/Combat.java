package GameData.Combat;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import sample.launcher;
import GameData.Combat.Entities.Team;
import GameData.Combat.Moves.MoveList;
import GameData.Combat.Moves.Move;
import GameData.Combat.Entities.Entity;
import GameData.Combat.Types.Eau;
import GameData.Combat.Types.Types;
import GameData.Default.Items.Item;
import GameData.Ressources.Contenu.Pnj;
import Test.TestControleurCombatThomas;

public class Combat {
    private Team team1;
    private Team team2;
    private Integer compteur;
    private Integer tour;



    private ArrayList<JButton> tabouton;

    public Combat(Team team1, Team team2){
        this.team1=team1;
        this.team2=team2;
        this.tour = 0;
    }

    public void affichage(){//Actualisation des données affichées à l'écran
    }

    public void fight(){
        Boolean fin=false;
        Integer victoire = 0;
        while (fin!=true){
            if (fin==true){

            }else{
                ArrayList<Pnj> listePnjsVitesse = new ArrayList<>();
                for (Pnj pnjAjoute:team1.getListePNJ()) {
                    listePnjsVitesse.add(pnjAjoute);
                }
                for (Pnj pnjAjoute:team2.getListePNJ()) {
                    listePnjsVitesse.add(pnjAjoute);
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
                for (Pnj pnj:listePnjsVitesse) {
                    for (Pnj pnjteam1:team1.getListePNJ()) {
                        if (pnj.equals(pnjteam1) && pnj.getEntite().getPV().getPv()>0 && victoire==0){
                            Integer selecGenre;
                            //Ici le joueur choisit le genre d'attaque , il retourne un chiffre entre 0 et 1 (inclus)
                            selecGenre=1;//Init vide
                            Integer selecAttaque;
                            //Ici le joueur choisit l'attaque à lancer, il retourne un chiffre entre 0 et 3 (inclus)
                            selecAttaque=1;//Init vide
                            Integer selecCible;
                            //Ici le joueur choisit la cible de l'attaque, il retourne un chiffre entre 0 et le nb maximal d'adversaire + 1
                            selecCible=1;//Init vide
                            boolean selection=false;
                            while (selection==false){
                                if (TestControleurCombatThomas.getSelectionAtk()!="RIEN" && selection==false){
                                    try{
                                        selecGenre=Integer.parseInt(TestControleurCombatThomas.getSelectionAtk().substring(0,1));
                                        selecAttaque=Integer.parseInt(TestControleurCombatThomas.getSelectionAtk().substring(1,2));
                                        selecCible=Integer.parseInt(TestControleurCombatThomas.getSelectionAtk().substring(2,3));
                                        selection=true;
                                        TestControleurCombatThomas.setSelectionAtk("RIEN");
                                    }catch (Exception error_selection_atk){
                                        //Erreur lors de la selection de l'attaque
                                    }
                                }
                            }

                            Move attaque = new Move("MError","Erreur","Erreur", 0, new Eau(), 0);//Attaque vide. Reste s'il y a une erreur
                            if (selecGenre==0){
                                attaque = pnjteam1.getEntite().getMovesPhy().getMove(selecAttaque);
                            }else{
                                attaque = pnjteam1.getEntite().getMovesSpe().getMove(selecAttaque);
                            }
                            Entity cible = team2.getListePNJ().get(selecCible).getEntite();
                            useMove(attaque, pnjteam1.getEntite(), cible);
                            //Ici on lance l'animation, puis l'affichage
                            affichage();
                            victoire = analyseVictoire(team1, team2);
                        }
                    }//On fait choisir les attaques par le joueur

                    for (Pnj pnjteam2:team2.getListePNJ()) {
                        Pnj randomPnj = new Pnj();
                        if (pnj.equals(pnjteam2) && pnj.getEntite().getPV().getPv()>0 && victoire==0){
                            boolean finAnalysePv = false;
                            while (finAnalysePv==false){
                                if (finAnalysePv==false){
                                    Integer randomPnjIndex = ThreadLocalRandom.current().nextInt(0, team1.getListePNJ().size()+1);
                                    randomPnj = team1.getListePNJ().get(randomPnjIndex);
                                    if (randomPnj.getEntite().getPV().getPv()>0){
                                        finAnalysePv=true;
                                    }
                                }
                            }//Sélection aléatoire d'un adversaire (s'il est vivant)
                            Integer randomMoveGenre = ThreadLocalRandom.current().nextInt(0, 2);//Genre aléatoire
                            Integer randomMoveIndex = ThreadLocalRandom.current().nextInt(0, 4);//Position aléatoire d'attaque
                            Move randomMove = new Move("MError","Erreur","Erreur", 0, new Eau(), 0);//Attaque vide. Reste s'il y a une erreur
                            if (randomMoveGenre==0 && !pnjteam2.getEntite().getMovesPhy().getMove(0).equals(null)){
                                randomMove = pnjteam2.getEntite().getMovesPhy().getMove(randomMoveIndex);
                            }else if (randomMoveGenre==1 && !pnjteam2.getEntite().getMovesSpe().getMove(0).equals(null)){
                                randomMove = pnjteam2.getEntite().getMovesSpe().getMove(randomMoveIndex);
                            }else{
                                //Rien, car il n'y a aucune attaque, (voir l'attaque vide)
                            }
                            useMove(randomMove, pnjteam2.getEntite(), randomPnj.getEntite());
                            //Ici on lance l'animation, puis l'affichage
                            affichage();
                            victoire = analyseVictoire(team1, team2);
                        }
                    }//On fait choisir les attaques de l'adversaire aléatoirement
                }
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
                    for (Pnj pnjAllie:team1.getListePNJ()){
                        pnjAllie.getEntite().addXp((Integer) xpObtenu/team1.getListePNJ().size());
                    }//Ajout de l'xp sur chaque entité de l'équipe alliée
                    fin=true;
                }else if (victoire==-1){
                    //Défaite !
                    fin=true;
                }
            }
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

    public void testMort(){
        if (analyseVictoire(team1,team2)==-1){
            launcher.ecranMortRespawn();
        }
    }

    public void useMove(Move move, Entity entityThrow, Entity entityReceiver){
        String genre=move.getGenre();
        if (genre.equals("SPECIAL")){
            double dommages=2+(2*entityThrow.getLvl())/5;
            dommages*=move.getPuissance();
            dommages*=entityThrow.getAttspe()/entityReceiver.getDefspe();
            dommages/=50;
            dommages+=2;
            dommages*=getModifier(move, entityThrow, entityReceiver);//Faire une méthode analysant les types alliés et ennemis
            entityReceiver.getPV().degatsPVabs((int)dommages);
        }else if (genre.equals("PHYSIQUE")){
            double dommages=2+(2*entityThrow.getLvl())/5;
            dommages*=move.getPuissance();
            dommages*=entityThrow.getAtt()/entityReceiver.getDef();
            dommages/=50;
            dommages+=2;
            dommages*=getModifier(move, entityThrow, entityReceiver);//Faire une méthode analysant les types alliés et ennemis
            entityReceiver.getPV().degatsPVabs((int)dommages);
        }else{

        }

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
