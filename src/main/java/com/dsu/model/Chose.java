package com.dsu.model;

public class Chose {
    private int idChose;
    private Player player;
    private Letter[] letters;

    public Chose() {
    }

    public Chose(Player player, Letter[] letters) {
        this.player = player;
        this.letters = letters;
    }

    public int getIdChose() {
        return idChose;
    }

    public void setIdChose(int idChose) {
        this.idChose = idChose;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void setLetters(Letter[] letters) {
        this.letters = letters;
    }
}
