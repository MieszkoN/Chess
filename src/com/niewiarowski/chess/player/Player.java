package com.niewiarowski.chess.player;

import com.niewiarowski.chess.ChessColor;
import com.niewiarowski.chess.board.Board;
import com.niewiarowski.chess.board.Move;
import com.niewiarowski.chess.pieces.King;
import com.niewiarowski.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final List<Move> legalMoves;
    private final boolean isCheck;

    Player(final Board board, final List<Move> legalMoves, final List<Move> opponentMoves) {
        this.board = board;
        this.playerKing = giveKing();
        this.isCheck = !Player.getAttacksOnTile(this.playerKing.getPiecePosition(), opponentMoves).isEmpty();
        this.legalMoves = legalMoves;
    }

    private static List<Move> getAttacksOnTile(int piecePosition, List<Move> moves) {
        final List<Move> attackMoves = new ArrayList<>();

        for(Move move : moves) {
            if(piecePosition == move.getDestinationCoordinate()) {
                attackMoves.add(move);
            }
        }

        return attackMoves;
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
        return this.isCheck;
    }

    public boolean isCheckMate() {
        return this.isCheck && !hasEscape();
    }

    public boolean isInStaleMate() {
        return this.isCheck && !hasEscape();
    }

    private boolean hasEscape() {
        for(Move move : this.legalMoves) {
            MoveTransition transition = makeMove(move);
            if(transition.getMoveStatus().isDone()) {
                return true;
            }
        }

        return false;
    }


    public MoveTransition makeMove(final Move move) {
        if(!isMoveLegal(move)) {
            return new MoveTransition(this.board, move, MoveStatus.ILLEGAL_MOVE);
        }

        final Board transitionBoard = move.execute();

        final List<Move> kingAttacks = Player.getAttacksOnTile(transitionBoard.currentPlayer().getOponent().getPlayerKing().getPiecePosition(), transiitionBoard.currentPlayer().getLegalMoves());

        if(!kingAttacks.isEmpty()) {
            return new MoveTransiton(this.board, move, MoveStatus.LEAVES_PLAYER_IN_CHECK);
        }
        return new MoveTransition(transitionBoard, move, MoveStatus.DONE);
    }


    public King getPlayerKing() {
        return this.getPlayerKing();
    }


    public List<Move> getLegalMoves() {
        return this.legalMoves;
    }


    public abstract List<Piece> getCurrentPieces();
    public abstract ChessColor getColorOfPlayer();
    public abstract Player getOponent();


}
