package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public class PawnMove extends Move {
    public PawnMove(Board board, Piece movedPiece, int destination) {
        super(board, movedPiece, destination);
    }

}
