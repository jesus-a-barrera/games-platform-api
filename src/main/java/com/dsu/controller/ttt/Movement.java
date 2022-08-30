package com.dsu.controller.ttt;

import com.dsu.model.TicTacToePlayer;

public class Movement {
    private TicTacToePlayer ticTacToePlayer;
    private Position position;

    public Movement() {
    }

    public Movement(TicTacToePlayer ticTacToePlayer, Position position) {
        this.ticTacToePlayer = ticTacToePlayer;
        this.position = position;
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
