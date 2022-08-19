package com.dsu.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static List<Game> games =new ArrayList<Game>();
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
        games.add(game);
        return game;
    }

    public static Game selectGame(int idGame) {
        for (Game game : games)
            if (game.getIdGame() == idGame)
                return game;
        return null;
    }

    public static List<Game> selectGame() {
        return games;
    }

    public static Game updateGame(int id, Game game) {
        for (Game fGame : games) {
            if (fGame.getIdGame() == id) {
                fGame.setIdGame(game.getIdGame());
                fGame.setGame(game.getGame());
                return fGame;
            }
        }
        games.add(game);
        return game;
    }

    public static void deleteGame(Game game) {
        for (Game fGame : games) {
            if (fGame.getIdGame() == game.getIdGame())
                games.remove(fGame);
        }
    }
}