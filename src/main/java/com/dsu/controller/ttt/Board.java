package com.dsu.controller.ttt;

import com.dsu.model.Piece;
import com.dsu.model.Square;

public class Board {
    public static int EmptySquare;

    public static Square[][] initBoard(int idRound, Square[][] board) {
        EmptySquare = 9;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Square(idRound, (i + 1), (j + 1), Piece.selectPiece(3));
            }
        }
        return board;
    }

    public static boolean putPiece(Position position, Piece piece, Square[][] board) {
        if (position.getX() > 3 || position.getY() > 3) return false;
        if (position.getX() <= 0 || position.getY() <= 0) return false;
        if (board[position.getX() - 1][position.getY() - 1].getPiece().equals(Piece.selectPiece(3))) {
            board[position.getX() - 1][position.getY() - 1].setPiece(piece);
            EmptySquare--;
            return true;
        }
        return false;
    }

    public static boolean isFull() {
        return EmptySquare <= 0;
    }

    public static Piece getWinner(Square[][] squares) {
        if (!checkRows(squares).equals(Piece.selectPiece(3)))
            return checkRows(squares);
        if (!checkColumns(squares).equals(Piece.selectPiece(3)))
            return checkColumns(squares);
        if (!checkDiagonals(squares).equals(Piece.selectPiece(3)))
            return checkDiagonals(squares);
        return Piece.selectPiece(3);
    }

    private static Piece checkRows(Square[][] squares) {
        Piece piece = Piece.selectPiece(3);
        for (Square[] row : squares) {
            if (row[0].equals(row[1]) && row[0].equals(row[2])) {
                piece = (row[0].getPiece());
                break;
            }
        }
        return piece;
    }

    private static Piece checkColumns(Square[][] squares) {
        Piece piece = Piece.selectPiece(3);
        for (int i = 0; i < 3; i++) {
            if (squares[0][i].equals(squares[1][i]) && squares[0][i].equals(squares[2][i])) {
                piece = squares[0][i].getPiece();
                break;
            }
        }
        return piece;
    }

    private static Piece checkDiagonals(Square[][] squares) {
        Piece piece = Piece.selectPiece(3);
        if ((squares[0][0].equals(squares[1][1]) && squares[0][0].equals(squares[2][2]))
                || squares[0][2].equals(squares[1][1]) && squares[0][2].equals(squares[2][0]))
            piece = squares[1][1].getPiece();
        return piece;
    }
}

