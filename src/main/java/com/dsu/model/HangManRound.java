package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class HangManRound {
    private static List<HangManRound> hangManRounds = new ArrayList<HangManRound>();
    private int idHangManRound;
    private Round round;
    private final int MAX_NUMBER_OF_ATTEMPTS = 8;
    private int attempts = 0;
    private int failedAttempts = 0;
    private Letter[] secretWord;

    public HangManRound() {}

    public HangManRound(Round round, Letter[] secretWord) {
        this.round = round;
        this.secretWord = secretWord;
    }

    public int getIdHangManRound() {
        return idHangManRound;
    }

    public void setIdHangManRound(int idHangManRound) {
        this.idHangManRound = idHangManRound;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getMAX_NUMBER_OF_ATTEMPTS() {
        return MAX_NUMBER_OF_ATTEMPTS;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public Letter[] getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(Letter[] secretWord) {
        this.secretWord = secretWord;
    }

    public static HangManRound insertHangManRound(HangManRound hangManRound) {
        hangManRound.setIdHangManRound(hangManRounds.size() + 1);
        hangManRounds.add(hangManRound);
        return hangManRound;
    }

    public static HangManRound selectHangManRound(int id) {
        for (HangManRound hangManRound : hangManRounds)
            if (hangManRound.getIdHangManRound() == id)
                return hangManRound;
        return null;
    }

    public static List<HangManRound> selectRounds() {
        return hangManRounds;
    }

    public static HangManRound updateRound(HangManRound hangManRound) {
        for (HangManRound foundRound : hangManRounds) {
            if (foundRound.getIdHangManRound() == hangManRound.getIdHangManRound()) {
                foundRound.setRound(hangManRound.getRound());
                foundRound.setSecretWord(hangManRound.getSecretWord());
                return foundRound;
            }
        }
        hangManRounds.add(hangManRound);
        return hangManRound;
    }

    public static void deleteRound(int idHangManRound) {
        for (HangManRound foundRound : hangManRounds) {
            if (foundRound.getIdHangManRound() == idHangManRound)
                hangManRounds.remove(foundRound);
        }
    }
}
