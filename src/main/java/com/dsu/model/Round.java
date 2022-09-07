package com.dsu.model;

import java.util.List;
import java.util.ArrayList;

public class Round {

    private static List<Round> rounds = new ArrayList<Round>();
    private int idRound;
    private Player player1;
    private Player player2;
    private Player Winner;
    private Player turn;
    private Game game;
    private boolean isFinished;

    public Round() {
    }

    public Round(Player Player1, Player Player2, Player winner, Player turn, Game game, boolean isFinished) {
        this.player1 = Player1;
        this.player2 = Player2;
        this.Winner = winner;
        this.turn = turn;
        this.game = game;
        this.isFinished = isFinished;
    }

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinner() {
        return Winner;
    }

    public void setWinner(Player winner) {
        Winner = winner;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Player getTurn() {
        return turn;
    }

    public void setTurn(Player turn) {
        this.turn = turn;
    }

    public static Round insertRound(Round round) {
        round.setIdRound(rounds.size() + 1);
        rounds.add(round);
        return round;
    }

    public static Round selectRound(int id) {
        for (Round round : rounds)
            if (round.getIdRound() == id)
                return round;
        return null;
    }

    public static List<Round> selectRounds() {
        return rounds;
    }

    public static Round updateRound(Round round) {
        for (Round foundRound : rounds) {
            if (foundRound.getIdRound() == round.getIdRound()) {
                foundRound.setIdRound(round.getIdRound());
                foundRound.setPlayer1(round.getPlayer1());
                foundRound.setPlayer2(round.getPlayer2());
                foundRound.setWinner(round.getWinner());
                foundRound.setGame(round.getGame());
                foundRound.setFinished(round.isFinished());
                return foundRound;
            }
        }
        rounds.add(round);
        return round;
    }

    public static void deleteRound(int IdRound) {
        for (Round foundRound : rounds) {
            if (foundRound.getIdRound() == IdRound)
                rounds.remove(foundRound);
        }
    }
}