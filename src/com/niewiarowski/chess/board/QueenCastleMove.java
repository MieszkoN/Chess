package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class QueenCastleMove extends CastleMove {
    public QueenCastleMove(Board board, Piece movedPiece, int destination) {
        super(board, movedPiece, destination);
    }
}
