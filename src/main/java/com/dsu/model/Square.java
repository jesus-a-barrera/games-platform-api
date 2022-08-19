package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private static List<Square> squares = new ArrayList<Square>();

    private int idRound;
    private int column;
    private int row;
    private int idPiece;

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

    public static Square insertSquare(Square square) {
        squares.add(square);
        return square;
    }



    public static Square selectSquare(int id) {
        for (Square square : squares)
            if (square.getIdRound() == id)
                return square;
        return null;
    }

    public static List<Square> selectSquares() {
        return squares;
    }

    public static Square updateSquare(int id, Square square) {
        for (Square foundSquare : squares) {
            if (foundSquare.getIdRound() == id) {
                foundSquare.setIdRound(square.getIdRound());
                foundSquare.setColumn(square.getColumn());
                foundSquare.setRow(square.getRow());
                foundSquare.setIdPiece(square.getIdPiece());
                return foundSquare;
            }
        }
        squares.add(square);
        return square;
    }

    public static void deleteSquare(Square square) {
        for (Square foundSquare : squares) {
            if (foundSquare.getIdRound() == square.getIdRound())
                squares.remove(foundSquare);
        }
    }

}
