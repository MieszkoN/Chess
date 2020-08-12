package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public class AttackingMove extends Move{
    final Piece attackedPiece;
    public AttackingMove(Board board, Piece movedPiece, int destination, Piece attackedPiece) {
        super(board, movedPiece, destination);
        this.attackedPiece = attackedPiece;
    }

    @Override
    public int hashCode() {
        return this.attackedPiece.hashCode() + super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof  AttackingMove)) {
            return false;
        }

        AttackingMove other = (AttackingMove) obj;
        return super.equals(other) && getAttackedPiece().equals(other.getAttackedPiece());

    }

    @Override
    public boolean isAttack() {
        return true;
    }

    @Override
    public Piece getAttackedPiece() {
        return this.attackedPiece;
    }
}
