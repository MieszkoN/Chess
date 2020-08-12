package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public class PawnAttackMove extends AttackingMove{
        public PawnAttackMove(Board board, Piece movedPiece, int destination, Piece attackedPiece) {
            super(board, movedPiece, destination, attackedPiece);
        }
}
