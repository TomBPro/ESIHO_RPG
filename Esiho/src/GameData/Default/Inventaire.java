package GameData.Default;

import GameData.Default.Items.Item;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<Item> inventaire;

    public Inventaire(ArrayList<Item> inventaire) {
        this.inventaire = inventaire;
    }

    public Inventaire(){
        this.inventaire = new ArrayList<>();
    }

    public void addItem(Item itemAdded){
        inventaire.add(itemAdded);
    }//ajoute un objet à l'inventaire

    public void removeItem(Item itemRemoved){
        inventaire.remove(itemRemoved);
    }//enlève un objet à l'inventaire

    public Item getItem(Integer position){
        //retourne l'objet voulu (à revoir)
        return inventaire.get(position);
    }

    public ArrayList<Item> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<Item> inventaire) {
        this.inventaire = inventaire;
    }
}
