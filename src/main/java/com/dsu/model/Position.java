package com.dsu.controller.ttt;

public class Position {
    private int X;
    private int Y;

    public Position(int x, int y) {
        X = x;
        Y = y;
    }

    public Position() {
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
