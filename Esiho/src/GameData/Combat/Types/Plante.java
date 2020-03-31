package GameData.Combat.Types;

import java.util.ArrayList;

public class Plante extends Types {
    public String nomType;

    public Plante() {
        nomType="PLANTE";
    }

    public String getNomType() {
        return nomType;
    }

    @Override
    public ArrayList getWeaknesses() {
        ArrayList<Types> weaknesses = new ArrayList<>();
        weaknesses.add(new Feu());
        weaknesses.add(new Plante());
        return weaknesses;
    }

    @Override
    public ArrayList getStrengths() {
        ArrayList<Types> strengths = new ArrayList<>();
        strengths.add(new Eau());
        return strengths;
    }

}
