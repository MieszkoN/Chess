package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;

import java.util.List;

public abstract class Piece {
    protected final int piecePosition;
    protected final ChessColor pieceColor;
    protected final boolean isFirstMove;

    Piece(final int piecePosition, final ChessColor pieceColor) {
        this.piecePosition = piecePosition;
        this.pieceColor = pieceColor;
        //TODO
        this.isFirstMove = false;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public ChessColor getPieceOfChessColor() {
        return this.pieceColor;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public abstract List<Move> getLegalMoves(final Board board);

    public enum PieceType {

        PAWN("P"),
        KNIGHT("K"),
        BISHOP("B"),
        ROOK("R"),
        QUEEN("Q"),
        KING("K");

        private String pieceName;

        PieceType(final String pieceName) {
            this.pieceName = pieceName;
        }


        @Override
        public String toString() {
            return this.pieceName;
        }
    }
}
