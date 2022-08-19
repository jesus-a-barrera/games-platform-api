package com.dsu.model;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private static List<Player> players = new ArrayList<>();
    private int idPlayer;
    private String name;
    private int idTypePlayer;

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTypePlayer() {
        return idTypePlayer;
    }

    public void setIdTypePlayer(int idTypePlayer) {
        this.idTypePlayer = idTypePlayer;
    }

    public static Player insertPlayer(Player player) {
        players.add(player);
        return player;
    }

    public static Player selectPlayer(int id) {
        for (Player player : players)
            if (player.getIdPlayer() == id)
                return player;
        return null;
    }

    public static List<Player> selectPlayers() {
        return players;
    }

    public static Player updatePlayer(int id, Player player) {
        for (Player foundPlayer : players) {
            if (foundPlayer.getIdPlayer() == id) {
                foundPlayer.setIdPlayer(player.getIdPlayer());
                foundPlayer.setName(player.getName());
                foundPlayer.setIdTypePlayer(player.getIdTypePlayer());
                return foundPlayer;
            }
        }
        players.add(player);
        return player;
    }

    public static void deletePlayer(Player player) {
        for (Player foundPlayer : players) {
            if (foundPlayer.getIdPlayer() == player.getIdPlayer())
                players.remove(foundPlayer);
        }
    }
}
