package GameData.Combat.Types;

import java.util.ArrayList;

public class Feu extends Types {
    public String nomType;

    public Feu() {
        nomType="FEU";
    }

    public String getNomType() {
        return nomType;
    }

    @Override
    public ArrayList getWeaknesses() {
        ArrayList<Types> weaknesses = new ArrayList<>();
        weaknesses.add(new Eau());
        weaknesses.add(new Feu());
        return weaknesses;
    }

    @Override
    public ArrayList getStrengths() {
        ArrayList<Types> strengths = new ArrayList<>();
        strengths.add(new Plante());
        return strengths;
    }
}
