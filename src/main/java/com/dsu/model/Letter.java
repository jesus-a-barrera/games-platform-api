package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private static List<Letter> letters = new ArrayList<Letter>();
    private int idRound;
    private char character;
    private int position;
    private boolean isShown;

    public Letter() {
    }

    public Letter(int idRound, char character, int position, boolean isShown) {
        this.idRound = idRound;
        this.character = character;
        this.position = position;
        this.isShown = isShown;
    }

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getIsShown() {
        return isShown;
    }

    public void setIsShown(boolean shown) {
        isShown = shown;
    }


    public static Letter insertLetter(Letter letter) {
        letters.add(letter);
        return letter;
    }

    public static Letter selectLetter(int idRound, char character, int position) {
        String PK = String.valueOf(idRound + character + position);
        for (Letter letter : letters) {
            String foundPK = String.valueOf(letter.getIdRound() + letter.getCharacter() + letter.getPosition());
            if (PK.equals(foundPK)) {
                return letter;
            }
        }
        return null;
    }

    public static List<Letter> selectLetter() {
        return letters;
    }

    public static Letter updateLetter(Letter letter) {
        String PK = String.valueOf(letter.getIdRound() + letter.getCharacter() + letter.getPosition());
        for (Letter fLetter : letters) {
            String foundPK = String.valueOf(fLetter.getIdRound() + fLetter.getCharacter() + fLetter.getPosition());
            if (PK.equals(foundPK)) {
                fLetter.setIdRound(letter.getIdRound());
                fLetter.setCharacter(letter.getCharacter());
                fLetter.setPosition(letter.getPosition());
                fLetter.setIsShown(letter.getIsShown());
                return fLetter;
            }
        }
        letters.add(letter);
        return letter;
    }

    public static void deleteLetter(int idRound, char character, int position) {
        String PK = String.valueOf(idRound + character + position);
        for (Letter fLetter : letters) {
            String foundPK = String.valueOf(fLetter.getIdRound() + fLetter.getCharacter() + fLetter.getPosition());
            if (PK.equals(foundPK))
                letters.remove(fLetter);
        }
    }
}