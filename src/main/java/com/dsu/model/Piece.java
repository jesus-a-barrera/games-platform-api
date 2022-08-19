package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private int idPiece;
    private String name;

    private static List<Piece> pieces = new ArrayList<Piece>();

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Piece insertPiece(Piece piece) {
        pieces.add(piece);
        return piece;
    }



    public static Piece selectPiece(int id) {
        for (Piece piece : pieces)
            if (piece.getIdPiece() == id)
                return piece;
        return null;
    }

    public static List<Piece> selectPieces() {
        return pieces;
    }

    public static Piece updatePiece(int id, Piece piece) {
        for (Piece foundPiece : pieces) {
            if (foundPiece.getIdPiece() == id) {
                foundPiece.setIdPiece(piece.getIdPiece());
                foundPiece.setName(piece.getName());
                return foundPiece;
            }
        }
        pieces.add(piece);
        return piece;
    }

    public static void deletePiece(Piece piece) {
        for (Piece foundPiece : pieces) {
            if (foundPiece.getIdPiece() == piece.getIdPiece())
                pieces.remove(foundPiece);
        }
    }
}
