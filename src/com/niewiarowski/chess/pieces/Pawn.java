package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.BoardUtils;
import com.niewiarowski.chess.board.MajorMove;
import com.niewiarowski.chess.board.Move;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private final static int [] POSSIBLE_PAWN_MOVES = {8, 16, 7, 9};
    public Pawn(int piecePosition, ChessColor pieceColor) {
        super(piecePosition, pieceColor);
    }

    @Override
    public List<Move> getLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for(int coordinate : POSSIBLE_PAWN_MOVES) {
            int destinationCoordinate = this.piecePosition + (this.getPieceOfChessColor().getDirection() * coordinate);

            if(!BoardUtils.isValidCoordinate(destinationCoordinate)) {
                continue;
            }

            if(coordinate == 8 && !board.getTile(destinationCoordinate).isOccupied()) {
                //TODO more work here
                legalMoves.add(new MajorMove(board, this, destinationCoordinate));
            } else if(coordinate == 16 && this.isFirstMove() && (BoardUtils.SECOND_ROW[this.piecePosition] && this.getPieceOfChessColor().isBlack() || BoardUtils.SEVENTH_ROW[this.piecePosition] && this.getPieceOfChessColor().isWhite())) {
                int destCoordinate = this.piecePosition + (this.pieceColor.getDirection() * 8);
                if(!board.getTile(destCoordinate).isOccupied() && !board.getTile(destinationCoordinate).isOccupied()) {
                    legalMoves.add(new MajorMove(board, this, destinationCoordinate));
                }
            } else if(coordinate == 7 && (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceColor.isWhite()) || (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceColor.isBlack())) {
                if(!board.getTile(destinationCoordinate).isOccupied()) {
                    Piece pieceOnTile = board.getTile(destinationCoordinate).getPiece();
                    if(this.pieceColor != pieceOnTile.getPieceOfChessColor()) {
                        //TODO
                        legalMoves.add(new MajorMove(board, this, destinationCoordinate));
                    }
                }
            } else if(coordinate == 9 && (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceColor.isWhite()) || (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceColor.isBlack())) {
                if(!board.getTile(destinationCoordinate).isOccupied()) {
                    Piece pieceOnTile = board.getTile(destinationCoordinate).getPiece();
                    if(this.pieceColor != pieceOnTile.getPieceOfChessColor()) {
                        //TODO
                        legalMoves.add(new MajorMove(board, this, destinationCoordinate));
                    }
                }
            }
        }

        return legalMoves;
    }


    @Override
    public String toString() {
        return PieceType.PAWN.toString();
    }
}
