package com.niewiarowski.chess.player;

import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;
import com.niewiarowski.chess.pieces.Piece;

import java.util.List;

public class BlackPlayer extends Player{
    public BlackPlayer(Board board, List<Move> whiteLegalMoves, List<Move> blackLegalMoves) {
        super(board, blackLegalMoves, whiteLegalMoves);
    }

    @Override
    public List<Piece> getCurrentPieces() {
        return this.board.getBlackPieces();
    }
}
