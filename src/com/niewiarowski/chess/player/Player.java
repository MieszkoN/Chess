package com.niewiarowski.chess.player;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;
import com.niewiarowski.chess.pieces.King;
import com.niewiarowski.chess.pieces.Piece;

import java.util.List;

public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final List<Move> legalMoves;

    Player(final Board board, final List<Move> legalMoves, final List<Move> opponentMoves) {
        this.board = board;
        this.playerKing = giveKing();
        this.legalMoves = legalMoves;
    }

    private King giveKing() {
        for(Piece piece : getCurrentPieces()) {
            if(piece.getPieceType().isKing()) {
                return (King) piece;
            }
        }
        throw new RuntimeException("There is no king!");
    }


    //TODO
    public boolean isMoveLegal(final Move move) {
        return this.legalMoves.contains(move);
    }

    public boolean isCheck() {
        return false;
    }

    public boolean isCheckMate() {
        return false;
    }


    public MoveTransition makeMove(final Move move) {

    }


    public abstract List<Piece> getCurrentPieces();
    public abstract ChessColor getColorOfPlayer();
    public abstract Player getOponent();


}
