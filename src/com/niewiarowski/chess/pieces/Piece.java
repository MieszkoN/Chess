package com.niewiarowski.chess.pieces;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;

import java.util.List;

public abstract class Piece {
    protected final int piecePosition;
    protected final ChessColor pieceColor;

    Piece(final int piecePosition, final ChessColor pieceColor) {
        this.piecePosition = piecePosition;
        this.pieceColor = pieceColor;
    }

    public ChessColor getPieceOfChessColor() {
        return this.pieceColor;
    }

    public abstract List<Move> getLegalMoves(final Board board);
}
