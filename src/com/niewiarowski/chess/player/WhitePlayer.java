package com.niewiarowski.chess.player;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;
import com.niewiarowski.chess.pieces.Piece;

import java.util.List;

public class WhitePlayer extends Player {
    public WhitePlayer(Board board, List<Move> whiteLegalMoves, List<Move> blackLegalMoves) {
        super(board, whiteLegalMoves, blackLegalMoves, isCheck);
    }

    @Override
    public List<Piece> getCurrentPieces() {
        return this.board.getWhitePieces();
    }

    @Override
    public ChessColor getColorOfPlayer() {
        return ChessColor.WHITE;
    }

    @Override
    public Player getOponent() {
        return this.board.getBlackPlayer();
    }
}
