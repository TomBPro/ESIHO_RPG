package GameData.Combat.Moves;

import java.util.ArrayList;

public class MoveList {
    private ArrayList<Move> movelist;

    public MoveList(Move move1) {
        movelist = new ArrayList<>();
        movelist.add(move1);
    }

    public MoveList(Move move1, Move move2) {
        movelist = new ArrayList<>();
        movelist.add(move1);
        movelist.add(move2);
    }

    public MoveList(Move move1, Move move2, Move move3) {
        movelist = new ArrayList<>();
        movelist.add(move1);
        movelist.add(move2);
        movelist.add(move3);
    }

    public MoveList(Move move1, Move move2, Move move3, Move move4) {
        movelist = new ArrayList<>();
        movelist.add(move1);
        movelist.add(move2);
        movelist.add(move3);
        movelist.add(move4);
    }

    public Move getMove(Integer position) {
        Move move;
        if (movelist.get(position)!=null){
            move = movelist.get(position);
        }else{
            move = null;
        }
        return move;
    }

    public ArrayList<Move> getMovelist() {
        return movelist;
    }
}
