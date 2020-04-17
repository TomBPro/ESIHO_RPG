package GameData.Combat.Types;

import java.util.ArrayList;

public class Normal extends Types {
        public String nomType;

        public Normal() {
            nomType="NORMAL";
        }

        public String getNomType() {
            return nomType;
        }

        @Override
        public ArrayList getWeaknesses() {
            ArrayList<Types> weaknesses = new ArrayList<>();
            return weaknesses;
        }

        @Override
        public ArrayList getStrengths() {
            ArrayList<Types> strengths = new ArrayList<>();
            return strengths;
        }
}
