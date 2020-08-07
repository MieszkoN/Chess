package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class AttackingMove extends Move{
    final Piece attackedPiece;
    public AttackingMove(Board board, Piece movedPiece, int destination, Piece attackedPiece) {
        super(board, movedPiece, destination);
        this.attackedPiece = attackedPiece;
    }
}
