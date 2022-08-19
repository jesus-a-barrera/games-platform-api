package com.dsu.model;

import java.util.List;

public class Game {
    private static List<Game> games;
    private int idGame;
    private String game;

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }


    public static Game insertGame(Game game) {
        return game;
    }

    public static Game selectGame(int idGame) {
        return null;
    }

    public static List<Game> selectGame() {
        return null;
    }

    public static Game updateGame(int id, Game game) {
        return null;
    }

    public static void deleteGame(Game game) {

    }
}