package com.dsu.model;

import java.util.List;
import java.util.ArrayList;

public class TypePlayer {
    private static List<TypePlayer> typesPlayers = new ArrayList<>();
    private int idTypePlayer;
    private int name;

    public int getIdTypePlayer() {
        return idTypePlayer;
    }

    public void setIdTypePlayer(int idTypePlayer) {
        this.idTypePlayer = idTypePlayer;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public static TypePlayer insertTypePlayer(TypePlayer typePlayer) {
        typesPlayers.add(typePlayer);
        return typePlayer;
    }

    public static TypePlayer selectTypePlayer(int id) {
        for (TypePlayer typePlayer : typesPlayers)
            if (typePlayer.getIdTypePlayer() == id)
                return typePlayer;
        return null;
    }

    public static List<TypePlayer> selectTypesPlayers() {
        return typesPlayers;
    }

    public static TypePlayer updateTypePlayer(int id, TypePlayer typePlayer) {
        for (TypePlayer foundTypePlayer : typesPlayers) {
            if (foundTypePlayer.getIdTypePlayer() == id) {
                foundTypePlayer.setIdTypePlayer(typePlayer.getIdTypePlayer());
                foundTypePlayer.setName(typePlayer.getName());
                return foundTypePlayer;
            }
        }
        typesPlayers.add(typePlayer);
        return typePlayer;
    }

    public static void deleteTypePlayer(TypePlayer typePlayer) {
        for (TypePlayer foundTypePlayer : typesPlayers) {
            if (foundTypePlayer.getIdTypePlayer() == typePlayer.getIdTypePlayer())
                typesPlayers.remove(foundTypePlayer);
        }
    }
}
