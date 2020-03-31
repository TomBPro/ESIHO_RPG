package GameData.Combat.Entities;

public class Pv {
    Integer pvmax;
    Integer pv;

    public Pv(Integer pvmax, Integer pv){
        this.pvmax=pvmax;
        this.pv=pv;
    }

    public Integer getPvmax() {
        return pvmax;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPvmax(Integer pvmax) {
        this.pvmax = pvmax;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getlvlpv(){
        return pv;
    }

    public Integer getlvlpvmax(){
        return pvmax;
    }

    public void regenPVabs(Integer regen){
        Integer pv = getlvlpv();
        Integer pvmax = getlvlpvmax();
        if (pvmax>=pv+regen){
            pv+=regen;
        }else{
            pv=pvmax;
        }
        setPv(pv);
    }

    public void regenPVprct(Integer pourcentage){
        Integer pv = getlvlpv();
        Integer pvmax = getlvlpvmax();
        Integer regen = pourcentage*pvmax;
        if (pvmax>=pv+regen){
            pv+=regen;
        }else{
            pv=pvmax;
        }
        setPv(pv);
    }

    public void degatsPVabs(Integer degats){
        Integer pv = getlvlpv();
        if (pv-degats>0){
            pv-=degats;
        }else{
            pv=0;
        }
        setPv(pv);
        System.out.println(degats);
    }

    public void degatsPVprct(Integer pourcentage){
        Integer pv = getlvlpv();
        Integer pvmax = getlvlpvmax();
        Integer degats = pourcentage*pvmax;
        if (pv-degats>0){
            pv-=degats;
        }else{
            pv=0;
        }
        setPv(pv);
    }

    public void affichage(){
        System.out.println("Niveau maximal de vie : "+this.pvmax);//Affichage Basique
        System.out.println("Niveau actuel de vie : "+this.pv);
        Integer barredevie=(Integer) (getlvlpvmax()/20);
        System.out.print("[");
        for (int a=getlvlpv(); a>0; a=a-barredevie){
            System.out.print("|");
        }//Affichage des "barres" de vie
        for (int a=0; a<getlvlpvmax()-getlvlpv(); a=a+barredevie){
            System.out.print(" ");
        }
        System.out.println("]");//Fin deuxième ligne
    }//L'affichage de la vie en format texte et sur une jauge

    public Integer removePv(Integer valeur){
        this.pv-=pcAjoute;
    }

    public Integer addPv(Integer pvAjouter){
        this.pv+=pcAjoute;
    }

}

