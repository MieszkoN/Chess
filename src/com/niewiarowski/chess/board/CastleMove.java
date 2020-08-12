package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

abstract class CastleMove extends Move {
    public CastleMove(Board board, Piece movedPiece, int destination) {
        super(board, movedPiece, destination);
    }
}
