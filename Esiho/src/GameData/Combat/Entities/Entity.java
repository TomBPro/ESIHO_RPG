package GameData.Combat.Entities;

import GameData.Combat.Moves.MoveList;
import GameData.Combat.Types.Types;
import GameData.Default.Items.Arme;
import GameData.Default.Items.Armure;
import javafx.scene.image.Image;

import java.util.concurrent.ThreadLocalRandom;

public class Entity {
    Integer lvl;
    Integer xpmax;
    Integer xp;
    Types type;
    Pv pv;
    Integer att;
    Integer def;
    Integer attspe;
    Integer defspe;
    Integer vitesse;
    Arme arme;
    Armure armure;
    MoveList movesPhy;
    MoveList movesSpe;
    Image image;


    public Entity(Integer lvl, Integer xpmax, Integer xp, Types type, Pv pv, Integer att, Integer def, Integer attspe, Integer defspe, Integer vitesse, Arme arme, Armure armure, MoveList movesPhy, MoveList movesSpe, Image image) {
        this.lvl = lvl;
        this.xpmax = xpmax;
        this.xp = xp;
        this.type = type;
        this.pv = pv;
        this.att = att;
        this.def = def;
        this.attspe = attspe;
        this.defspe = defspe;
        this.vitesse = vitesse;
        this.arme = arme;
        this.armure = armure;
        this.movesPhy = movesPhy;
        this.movesSpe = movesSpe;
        this.image = image;
    }


    public Entity( Integer lvl, Integer xpmax, Integer xp, Types type, Pv pv, Integer att, Integer def, Integer attspe, Integer defspe, Integer vitesse, Arme arme, Armure armure, MoveList movesPhy, MoveList movesSpe) {
        //Pas d'image
        this.lvl = lvl;
        this.xpmax = xpmax;
        this.xp = xp;
        this.type = type;
        this.pv = pv;
        this.att = att;
        this.def = def;
        this.attspe = attspe;
        this.defspe = defspe;
        this.vitesse = vitesse;
        this.arme = arme;
        this.armure = armure;
        this.movesPhy = movesPhy;
        this.movesSpe = movesSpe;
    }

    public Entity( Integer lvl, Integer xpmax, Integer xp, Types type, Pv pv, Integer att, Integer def, Integer attspe, Integer defspe, Integer vitesse, MoveList movesPhy, MoveList movesSpe, Image image) {
        //Pas Armes et armures
        this.lvl = lvl;
        this.xpmax = xpmax;
        this.xp = xp;
        this.type = type;
        this.pv = pv;
        this.att = att;
        this.def = def;
        this.attspe = attspe;
        this.defspe = defspe;
        this.vitesse = vitesse;
        this.arme = arme;
        this.armure = armure;
        this.movesPhy = movesPhy;
        this.movesSpe = movesSpe;
        this.image = image;
    }


    //Accesseur


    public int getLvl() {
        return lvl;
    }//Récupérer le niveau

    public Integer getXpmax() {
        return xpmax;
    }

    public Integer getXp() {
        return xp;
    }

    public Types getType() {
        return type;
    }//Récupérer le type

    public Pv getPV() {
        return this.pv;
    }

    public int getAtt() {
        return att;
    }//Récupérer le niveau d'attaque

    public int getDef() {
        return def;
    }//Récupérer le niveau de défense

    public int getAttspe() {
        return attspe;
    }//Récupérer le niveau d'attaque spéciale

    public int getDefspe() {
        return defspe;
    }//Récupérer le niveau de défense spéciale

    public int getVitesse() {
        return vitesse;
    }//Récupérer le niveau de vitesse


    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public void setPv(Integer pvmodif) {
        Pv pvtempo = new Pv(this.pv.getPvmax(), pvmodif);
        this.pv = pvtempo;
    }

    public void setPvMax(Integer pvmaxmodif){
        Pv pvtempo = new Pv(pvmaxmodif, this.pv.getPv());
        this.pv = pvtempo;
    }

    public void setAtt(Integer att) {
        this.att = att;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public void setAttspe(Integer attspe) {
        this.attspe = attspe;
    }

    public void setDefspe(Integer defspe) {
        this.defspe = defspe;
    }

    public void setVitesse(Integer vitesse) {
        this.vitesse = vitesse;
    }

    public Pv getPv() {
        return pv;
    }

    public void setPv(Pv pv) {
        this.pv = pv;
    }

    public void addXp(Integer xpobtenu){
        Integer xpold = xp;
        Integer xpmaxold = xpmax;
        this.xp=xpold+xpobtenu;
        if (xpmaxold<=xp){//S'il y a plus ou juste assez d'exp que nécessaire
            double xpnd=xpmaxold*1.1;
            this.xpmax=(int)xpnd;
            this.lvl++;
            this.xp=xp-xpmaxold;
            lvlUp();
        }
        if (xpmax<=xp){
            addXp(0);
        }
    }

    private void lvlUp(){
        Integer ptsObtenus = lvl;
        for (int a =0; a<ptsObtenus; a++){
            Integer ran = ThreadLocalRandom.current().nextInt(0, 5);
            switch (ran){
                case 0:
                    this.pv.pvmax++;
                    break;
                case 1:
                    this.att++;
                    break;
                case 2:
                    this.def++;
                    break;
                case 3:
                    this.attspe++;
                    break;
                case 4:
                    this.defspe++;
                    break;
                case 5:
                    this.vitesse++;
                    break;
            }
        }
    }//On ajoute les points aux stats

    public void afficherXp(){
        System.out.println("Le niveau : "+lvl);
        System.out.println("Xp : "+xp);
        System.out.println("Xp nécessaire : "+xpmax);
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }

    public Armure getArmure() {
        return armure;
    }

    public void setArmure(Armure armure) {
        this.armure = armure;
    }

    public MoveList getMovesPhy() {
        return movesPhy;
    }

    public void setMovesPhy(MoveList movesPhy) {
        this.movesPhy = movesPhy;
    }

    public MoveList getMovesSpe() {
        return movesSpe;
    }

    public void setMovesSpe(MoveList movesSpe) {
        this.movesSpe = movesSpe;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
