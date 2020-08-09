package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.*;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private final static int [] POSSIBLE_KING_MOVES = {-9, -8, -7, -1, 1, 7, 8, 9};

    public King(int piecePosition, ChessColor pieceColor) {
        super(piecePosition, pieceColor);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        int destinationCoordinate;

        for(int coordinate : POSSIBLE_KING_MOVES) {
            destinationCoordinate = this.piecePosition + coordinate;
            if(BoardUtils.isValidCoordinate(destinationCoordinate)) {
                if(isFirstColumn(this.piecePosition, coordinate) || isEighthColumn(this.piecePosition, coordinate)) {
                   continue;
                }

                Tile destinationTile = board.getTile(destinationCoordinate);
                if(!destinationTile.isOccupied()) {
                    legalMoves.add(new MajorMove(board, this, destinationCoordinate));
                } else {
                    final Piece pieceAtDestination = destinationTile.getPiece();
                    final ChessColor pieceOfChessColor = pieceAtDestination.getPieceOfChessColor();
                    if (this.pieceColor != pieceOfChessColor) {
                        legalMoves.add(new AttackingMove(board, this, destinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }

        return legalMoves;
    }


    private static boolean isFirstColumn(final int currentPosition, final int coordinateException) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (coordinateException == -9 || coordinateException == -1 || coordinateException == 7);
    }

    private static boolean isEighthColumn(final int currentPosition, final int coordinateException) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (coordinateException == -7 || coordinateException == 1 || coordinateException == 9);
    }

    @Override
    public String toString() {
        return PieceType.KING.toString();
    }
}
