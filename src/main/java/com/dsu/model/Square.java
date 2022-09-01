package com.dsu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Square {
    private static List<Square> squares = new ArrayList<Square>();

    private int idRound;
    private int row;
    private int column;
    private Piece piece;

    public Square() {
    }

    public Square(int idRound, int row, int column, Piece piece) {
        this.idRound = idRound;
        this.row = row;
        this.column = column;
        this.piece = piece;
    }

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
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
            String foundPK = String.valueOf(foundSquare.getIdRound() + foundSquare.getColumn() + foundSquare.getRow());
            if (PK.equals(foundPK)) {
                squares.remove(foundSquare);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square that = (Square) o;
        return idRound == that.idRound && row == that.row && column == that.column && piece.equals(that.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRound, row, column);
    }
}