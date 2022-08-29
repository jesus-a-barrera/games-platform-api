package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private static List<Square> squares = new ArrayList<Square>();

    private int idRound;
    private int column;
    private int row;
    private int idPiece;

    public Square() {
    }

    public Square(int idRound, int column, int row, int idPiece) {
        this.idRound = idRound;
        this.column = column;
        this.row = row;
        this.idPiece = idPiece;
    }

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


    public static Square selectSquare(int idRound, int column, int row) {
        String PK = String.valueOf(idRound + column + row);
        for (Square square : squares) {
            String foundPK = String.valueOf(square.getIdRound() + square.getColumn() + square.getRow());
            if (PK.equals(foundPK)) {
                return square;
            }
        }
        return null;
    }

    public static List<Square> selectSquares() {
        return squares;
    }

    public static Square updateSquare(Square square) {
        String PK = String.valueOf(square.getIdRound() + square.getColumn() + square.getRow());
        for (Square foundSquare : squares) {
            String foundPK = String.valueOf(foundSquare.getIdRound() + foundSquare.getColumn() + foundSquare.getRow());
            if (PK.equals(foundPK)) {
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

    public static void deleteSquare(int idRound, int column, int row) {
        String PK = String.valueOf(idRound + column + row);
        for (Square foundSquare : squares) {
            String foundPK = String.valueOf(foundSquare.getIdRound() + foundSquare.getColumn() + foundSquare.getRow());
            if (PK.equals(foundPK)) {
                squares.remove(foundSquare);
            }
        }
    }
}