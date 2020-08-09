package com.niewiarowski.chess;

import com.niewiarowski.chess.board.Board;

public class Main {

    public static void main(String[] args) {
        Board board = Board.createStandardBoard();

        System.out.println(board);
    }
}
