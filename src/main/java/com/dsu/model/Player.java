package com.dsu.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private static List<Player> players = new ArrayList<>();
    private int idPlayer;
    private String name;
    private TypePlayer typePlayer;

    @Override
    public String toString() {
        return "Player{" +
                "idPlayer=" + idPlayer +
                ", name='" + name + '\'' +
                '}';
    }

    public Player() {
    }

    public Player(String name, TypePlayer typePlayer) {
        this.name = name;
        this.typePlayer = typePlayer;
    }

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

    public TypePlayer getTypePlayer() {
        return typePlayer;
    }

    public void setTypePlayer(TypePlayer typePlayer) {
        this.typePlayer = typePlayer;
    }

    public static Player insertPlayer(Player player) {
        player.setIdPlayer(players.size() + 1);
        players.add(player);
        return player;
    }

    public static Player selectPlayer(int idPlayer) {
        for (Player player : players)
            if (player.getIdPlayer() == idPlayer)
                return player;
        return null;
    }

    public static List<Player> selectPlayers() {
        return players;
    }

    public static Player updatePlayer(Player player) {
        for (Player foundPlayer : players) {
            if (foundPlayer.getIdPlayer() == player.getIdPlayer()) {
                foundPlayer.setIdPlayer(player.getIdPlayer());
                foundPlayer.setName(player.getName());
                foundPlayer.setTypePlayer(player.getTypePlayer());
                return foundPlayer;
            }
        }
        players.add(player);
        return player;
    }

    public static void deletePlayer(int idPlayer) {
        for (Player foundPlayer : players) {
            if (foundPlayer.getIdPlayer() == idPlayer)
                players.remove(foundPlayer);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player that = (Player) o;
        return idPlayer == that.idPlayer && name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlayer, name);
    }

}