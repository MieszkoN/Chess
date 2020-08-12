package com.niewiarowski.chess.board;


import com.niewiarowski.chess.pieces.Piece;

public class KingCastleMove extends CastleMove {
    public KingCastleMove(Board board, Piece movedPiece, int destination) {
        super(board, movedPiece, destination);
    }
}
