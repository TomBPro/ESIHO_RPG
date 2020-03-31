package GameData.Combat.Types;

import java.util.ArrayList;

public abstract class Types {
    public String nomType;

    public Types() {
        this.nomType = nomType;
    }

    public String getNomType() {
        return nomType;
    }

    public abstract ArrayList getWeaknesses();

    public abstract ArrayList getStrengths();
}
