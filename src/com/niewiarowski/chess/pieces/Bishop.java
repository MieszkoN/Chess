package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.*;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    private final static int [] POSSIBLE_BISHOP_MOVES = {-9, -7, 7, 9};

    public Bishop(int piecePosition, ChessColor pieceColor) {
        super(PieceType.BISHOP, piecePosition, pieceColor);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();

        for(int coordinate: POSSIBLE_BISHOP_MOVES) {
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

    @Override
    public Piece movePiece(Move move) {
        return new Bishop(move.getDestinationCoordinate(), move.getMovedPiece().getPieceOfChessColor());
    }

    private static boolean isFirstColumn(int currentPosition, int coordinateException) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (coordinateException == -9 || coordinateException == 7);
    }

    private static boolean isEighthColumn(int currentPosition, int coordinateException) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (coordinateException == -7 || coordinateException == 9);
    }

    @Override
    public String toString() {
        return PieceType.BISHOP.toString();
    }
}
