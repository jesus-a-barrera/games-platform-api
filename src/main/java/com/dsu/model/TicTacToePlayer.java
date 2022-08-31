package com.dsu.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicTacToePlayer that = (TicTacToePlayer) o;
        return player.equals(that.player) && piece.equals(that.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, piece);
    }
}
