package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeRound {

    private static List<TicTacToeRound> ticTacToeRounds = new ArrayList<>();
    private int idTicTacToeRound;
    private Round round;
    private Square[][] board;

    public TicTacToeRound() {
    }

    public TicTacToeRound(Round round, Square[][] board) {
        this.round = round;
        this.board = board;
    }

    public int getIdTicTacToeRound() {
        return idTicTacToeRound;
    }

    public void setIdTicTacToeRound(int idTicTacToeRound) {
        this.idTicTacToeRound = idTicTacToeRound;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Square[][] getBoard() {
        return board;
    }

    public void setBoard(Square[][] board) {
        this.board = board;
    }

    public static TicTacToeRound insertTicTacToeRound(TicTacToeRound ticTacToeRound) {
        ticTacToeRound.setIdTicTacToeRound(ticTacToeRounds.size() + 1);
        ticTacToeRounds.add(ticTacToeRound);
        return ticTacToeRound;
    }

    public static TicTacToeRound selectTicTacToeRound(int id) {
        for (TicTacToeRound ticTacToeRound : ticTacToeRounds)
            if (ticTacToeRound.getIdTicTacToeRound() == id)
                return ticTacToeRound;
        return null;
    }

    public static List<TicTacToeRound> selectTicTacToeRounds() {
        return ticTacToeRounds;
    }

    public static TicTacToeRound updateTicTacToeRound(TicTacToeRound ticTacToeRound) {
        for (TicTacToeRound foundRound : ticTacToeRounds) {
            if (foundRound.getIdTicTacToeRound() == ticTacToeRound.getIdTicTacToeRound()) {
                foundRound.setRound(ticTacToeRound.getRound());
                foundRound.setBoard(ticTacToeRound.getBoard());
                return foundRound;
            }
        }
        ticTacToeRounds.add(ticTacToeRound);
        return ticTacToeRound;
    }

    public static void deleteTicTacToeRounds(int idTicTacToeRound) {
        for (TicTacToeRound foundRound : ticTacToeRounds) {
            if (foundRound.getIdTicTacToeRound() == idTicTacToeRound)
                ticTacToeRounds.remove(foundRound);
        }
    }
}
