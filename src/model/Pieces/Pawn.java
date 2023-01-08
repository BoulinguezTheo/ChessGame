package model.Pieces;

import model.ChessData;
import model.Piece;

import java.util.ArrayList;

public class Pawn extends Piece {
    private int initXCor;
    private int initYCor;
    private static final int blackSign = 1;
    private static final int whiteSign = -1;
    private int sign;

    public Pawn(){
        super.xCor = 0;
        super.yCor = 0;
        super.color = "none";
        super.representation = "X";
    }
    public Pawn(int pXCor, int pYCor, String pColor){
        super.xCor = pXCor;
        this.initXCor = super.xCor;
        super.yCor = pYCor;
        this.initYCor = super.yCor;
        super.color = pColor;
        this.sign = this.color.equals("b") ? whiteSign : blackSign;
        super.representation = "p";
    }

    @Override
    public ArrayList<int[]> getMovesPossible(ChessData pBoard){
        ArrayList<int[]> availableMoves = new ArrayList<>();
        if (pBoard.getCells()[xCor + sign][yCor].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + sign, yCor});
        }
        int[] eatPiece1 = {getXCor() + sign, getYCor() + 1};
        if (!pBoard.getCells()[eatPiece1[0]][eatPiece1[1]].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + sign, yCor + 1});
        }
        if (!pBoard.getCells()[eatPiece1[0]][eatPiece1[1]].getCellContent().equals(" ")) {
            availableMoves.add(new int[]{xCor + sign, yCor - 1});
        }
        return availableMoves;
    }

    
    

}
    

    
    