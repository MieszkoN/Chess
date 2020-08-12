package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public class PawnEnPassantAttackMove extends PawnAttackMove{
    public PawnEnPassantAttackMove(Board board, Piece movedPiece, int destination, Piece attackedPiece) {
        super(board, movedPiece, destination, attackedPiece);
    }
}
