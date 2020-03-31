package GameData.Combat.Moves;

import java.util.ArrayList;

public class MoveList {
    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;
    private ArrayList<Move> movelist;

    public MoveList(Move move1, Move move2, Move move3, Move move4) {
        this.move1=move1;
        this.move2=move2;
        this.move3=move3;
        this.move4=move4;
        if (movelist != null) {
            movelist.add(this.move1);
            movelist.add(this.move2);
            movelist.add(this.move3);
            movelist.add(this.move4);
        }
    }

    public Move getMove(Integer position) {
        Move movevoulue=getMove1();
        switch (position){
            case 1 :
                movevoulue=getMove1();
                break;
            case 2 :
                movevoulue=getMove2();
                break;
            case 3 :
                movevoulue=getMove3();
                break;
            case 4 :
                movevoulue=getMove4();
                break;
        }
        return movevoulue;
    }

    public Move getMove1() {
        return move1;
    }

    public Move getMove2() {
        return move2;
    }

    public Move getMove3() {
        return move3;
    }

    public Move getMove4() {
        return move4;
    }

}
