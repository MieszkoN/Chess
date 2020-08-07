package com.niewiarowski.chess.board;

import com.niewiarowski.chess.pieces.Piece;

public final class MajorMove extends Move{

    public MajorMove(Board board, Piece movedPiece, int destination) {
        super(board, movedPiece, destination);
    }
}
