package com.dsu.model;

import java.util.List;
import java.util.ArrayList;

public class TypePlayer {
    private static List<TypePlayer> typesPlayers = new ArrayList<>();
    private int idTypePlayer;
    private String name;

    public TypePlayer() {
    }

    public TypePlayer(String name) {
        this.name = name;
    }

    public int getIdTypePlayer() {
        return idTypePlayer;
    }

    public void setIdTypePlayer(int idTypePlayer) {
        this.idTypePlayer = idTypePlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TypePlayer insertTypePlayer(TypePlayer typePlayer) {
        typePlayer.setIdTypePlayer(typesPlayers.size() + 1);
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

    public static void deleteTypePlayer(int idTypePlayer) {
        for (TypePlayer foundTypePlayer : typesPlayers) {
            if (foundTypePlayer.getIdTypePlayer() == idTypePlayer)
                typesPlayers.remove(foundTypePlayer);
        }
    }
}