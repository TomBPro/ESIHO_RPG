package GameData.Combat.Moves;

import java.util.ArrayList;

public class MoveList {
    private ArrayList<Move> movelist;

    public MoveList(Move move1, Move move2, Move move3, Move move4) {
        movelist.add(move1);
        movelist.add(move2);
        movelist.add(move3);
        movelist.add(move4);
    }

    public Move getMove(Integer position) {
        return movelist.get(position);
    }

    public ArrayList<Move> getMovelist() {
        return movelist;
    }
}
