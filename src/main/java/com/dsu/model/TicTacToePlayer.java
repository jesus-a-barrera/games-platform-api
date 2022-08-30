package com.dsu.model;

public class TicTacToePlayer {
    private Player player;
    private Piece piece;

    public TicTacToePlayer() {
    }

    public TicTacToePlayer(Player player, Piece piece) {
        this.player = player;
        this.piece = piece;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


}
