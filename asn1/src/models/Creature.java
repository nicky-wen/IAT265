package models;

import java.awt.Color;
import java.awt.Graphics2D;

import processing.core.PVector;

public abstract class Creature {
    protected double scale;
    protected int size;
    protected PVector pos, speed;

    public Creature(int x, int y, int size, int speed_x, int speed_y) {
        this.pos = new PVector(x, y);
        this.size = size;
        this.speed = new PVector(speed_x, speed_y);
        this.scale = 1;
    }

    public void move() {
        pos.add(speed);
    }

    public void checkCollision() {
        // TODO
    }

    public void increaseScale() {
        scale *= 1.10;
    };

    public abstract void draw(Graphics2D g);
}