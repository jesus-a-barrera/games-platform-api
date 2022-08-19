package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Letter {
    private static List<Letter> letters = new ArrayList<Letter>();
    private int idRound;
    private char character;
    private int position;
    private boolean isShown;

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

    public static Letter selectPositionLetter(int position) {
        for (Letter letter : letters)
            if (letter.getPosition() == position)
                return letter;
        return null;
    }

    public static List<Letter> selectLetter() {
        return letters;
    }

    public static Letter updateLetter(int idRound, Letter letter) {
        for (Letter fLetter : letters) {
            if (fLetter.getIdRound() == idRound) {
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

    public static void deleteLetter(Letter letter) {
        for (Letter fLetter : letters) {
            if (fLetter.getPosition() == letter.getPosition())
                letters.remove(fLetter);
        }
    }

}