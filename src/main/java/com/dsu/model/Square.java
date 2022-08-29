package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Square {
    private static List<Square> squares = new ArrayList<Square>();

    private Round round;
    private int column;
    private int row;
    private Piece piece;

    public Square() {
    }

    public Square(Round round, int column, int row, Piece piece) {
        this.round = round;
        this.column = column;
        this.row = row;
        this.piece = piece;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
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

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public static Square insertSquare(Square square) {
        squares.add(square);
        return square;
    }


    public static Square selectSquare(Round round, int column, int row) {
        String PK = String.valueOf(round.getIdRound() + column + row);
        for (Square square : squares) {
            String foundPK = String.valueOf(square.getRound().getIdRound() + square.getColumn() + square.getRow());
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
        String PK = String.valueOf(square.getRound().getIdRound() + square.getColumn() + square.getRow());
        for (Square foundSquare : squares) {
            String foundPK = String.valueOf(foundSquare.getRound().getIdRound() + foundSquare.getColumn() + foundSquare.getRow());
            if (PK.equals(foundPK)) {
                foundSquare.setRound(square.getRound());
                foundSquare.setColumn(square.getColumn());
                foundSquare.setRow(square.getRow());
                foundSquare.setPiece(square.getPiece());
                return foundSquare;
            }
        }
        squares.add(square);
        return square;
    }

    public static void deleteSquare(int idRound, int column, int row) {
        String PK = String.valueOf(idRound + column + row);
        for (Square foundSquare : squares) {
            String foundPK = String.valueOf(foundSquare.getRound().getIdRound() + foundSquare.getColumn() + foundSquare.getRow());
            if (PK.equals(foundPK)) {
                squares.remove(foundSquare);
            }
        }
    }
}