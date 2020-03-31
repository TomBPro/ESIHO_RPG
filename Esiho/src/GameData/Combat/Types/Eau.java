package GameData.Combat.Types;

import java.util.ArrayList;

public class Eau extends Types {
    public String nomType;

    public Eau() {
        nomType="EAU";
    }

    public String getNomType() {
        return nomType;
    }

    @Override
    public ArrayList getWeaknesses() {
        ArrayList<Types> weaknesses = new ArrayList<>();
        weaknesses.add(new Plante());
        weaknesses.add(new Eau());
        return weaknesses;
    }

    @Override
    public ArrayList getStrengths() {
        ArrayList<Types> strengths = new ArrayList<>();
        strengths.add(new Feu());
        return strengths;
    }

}
