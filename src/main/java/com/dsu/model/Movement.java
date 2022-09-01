package com.dsu.controller.ttt;

public class Movement {
    private int idMovement;
    private TicTacToePlayer ticTacToePlayer;
    private Position position;

    public Movement() {
    }

    public Movement(TicTacToePlayer ticTacToePlayer, Position position) {
        this.ticTacToePlayer = ticTacToePlayer;
        this.position = position;
    }

    public int getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(int idMovement) {
        this.idMovement = idMovement;
    }

    public TicTacToePlayer getTicTacToePlayer() {
        return ticTacToePlayer;
    }

    public void setTicTacToePlayer(TicTacToePlayer ticTacToePlayer) {
        this.ticTacToePlayer = ticTacToePlayer;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
