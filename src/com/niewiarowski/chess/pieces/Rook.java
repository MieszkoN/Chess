package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    private final static int [] POSSIBLE_ROOK_MOVES = {-8, -1, 1, 8};

    Rook(int piecePosition, ChessColor pieceColor) {
        super(piecePosition, pieceColor);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();

        for(int coordinate: POSSIBLE_ROOK_MOVES) {
            int destinationCoordinate = this.piecePosition;

            while(BoardUtils.isValidCoordinate(destinationCoordinate)) {
                if(isFirstColumn(destinationCoordinate, coordinate) || isEighthColumn(destinationCoordinate, coordinate)) {
                    break;
                }

                destinationCoordinate += coordinate;
                if(BoardUtils.isValidCoordinate(destinationCoordinate)) {
                    final Tile candidateDestination = board.getTile(destinationCoordinate);

                    if(!candidateDestination.isOccupied()) {
                        legalMoves.add(new MajorMove(board, this, destinationCoordinate));
                    } else {
                        final Piece pieceAtDestination = candidateDestination.getPiece();
                        final ChessColor pieceOfChessColor = pieceAtDestination.getPieceOfChessColor();
                        if (this.pieceColor != pieceOfChessColor) {
                            legalMoves.add(new AttackingMove(board, this, destinationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }

        return legalMoves;
    }

    private static boolean isFirstColumn(int currentPosition, int coordinateException) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (coordinateException == -1);
    }

    private static boolean isEighthColumn(int currentPosition, int coordinateException) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (coordinateException == 1);
    }
}
