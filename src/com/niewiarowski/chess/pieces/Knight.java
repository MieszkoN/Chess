package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.BoardUtils;
import com.niewiarowski.chess.board.Move;
import com.niewiarowski.chess.board.Tile;

import java.util.*;

import static com.niewiarowski.chess.board.BoardUtils.isValidCoordinate;

public class Knight extends Piece {

    private final static int [] POSSIBLE_MOVES = {-17, -15, -10, -6, 6, 10, 15, 17};

    Knight(int piecePosition, ChessColor pieceColor) {
        super(piecePosition, pieceColor);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        int destinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();
        for(final int currentCoordinate : POSSIBLE_MOVES) {
            destinationCoordinate = this.piecePosition + currentCoordinate;

            if(BoardUtils.isValidCoordinate(destinationCoordinate)) {
                if(isFirstColumn(this.piecePosition, currentCoordinate) || isSecondColumn(this.piecePosition, currentCoordinate) || isSeventhColumn(this.piecePosition, currentCoordinate) || isEighthColumn(this.piecePosition, currentCoordinate)) {
                    continue;
                }

                final Tile candidateDestination = board.getTile(destinationCoordinate);

                if(!candidateDestination.isOccupied()) {
                    legalMoves.add(new Move());
                } else {
                    final Piece pieceAtDestination = candidateDestination.getPiece();
                    final ChessColor pieceOfChessColor = pieceAtDestination.getPieceOfChessColor();
                    if (this.pieceColor != pieceOfChessColor) {
                        legalMoves.add(new Move());
                    }
                }
            }
        }

        return legalMoves;
    }

    private static boolean isFirstColumn(final int currentPosition, final int coordinateException) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (coordinateException == -17 || coordinateException == -10 || coordinateException == 6 || coordinateException == 15);
    }

    private static boolean isSecondColumn(final int currentPosition, final int coordinateException) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && (coordinateException == -10 || coordinateException == 6);
    }

    private static boolean isSeventhColumn(final int currentPosition, final int coordinateException) {
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (coordinateException == -6 || coordinateException == 10);
    }

    private static boolean isEighthColumn(final int currentPosition, final int coordinateException) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (coordinateException == -15 || coordinateException == -6 || coordinateException == 10 || coordinateException == 17);
    }
}
