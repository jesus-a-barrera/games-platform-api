package com.dsu.model;

import java.util.List;
import java.util.ArrayList;

public class Round {
    private static List<Round> rounds = new ArraysList<>();
    private int idRound;
    private int idPlayer1;
    private int idPlayer2;
    private int idWinner;
    private int idGame;
    private boolean isFinished;

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public int getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(int idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    public int getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(int idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }

    public int getIdWinner() {
        return idWinner;
    }

    public void setIdWinner(int idWinner) {
        this.idWinner = idWinner;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public static Round insertRound(Round round) {
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

    public static Round updateRound(int id, Round round) {
        for (Round foundRound : rounds) {
            if (foundRound.getIdRound() == id) {
                foundRound.setIdRound(round.getIdRound());
                foundRound.setIdPlayer1(round.getIdPlayer1());
                foundRound.setIdPlayer2(round.getIdPlayer2());
                foundRound.setIdWinner(round.getIdWinner());
                foundRound.setIdGame(round.getIdGame());
                foundRound.setFinished(round.isFinished());
                return foundRound;
            }
        }
        rounds.add(round);
        return round;
    }

    public static void deleteRound(Round round) {
        for (Round foundRound : rounds) {
            if (foundRound.getIdRound() == round.getIdRound())
                rounds.remove(foundRound);
        }
    }
}
