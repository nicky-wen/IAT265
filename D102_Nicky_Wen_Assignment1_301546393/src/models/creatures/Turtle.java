package models.creatures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import models.Creature;
import processing.core.PVector;

public class Turtle extends Creature {

    public Turtle(int x, int y, int size, int speed_x, int speed_y) {
        super(x, y, size, speed_x, speed_y);
    };

    @Override
    public void draw(Graphics2D g) {
        AffineTransform af = g.getTransform();

        g.translate(pos.x, pos.y);
        g.rotate(speed.heading());
        g.scale(scale, scale);
        if (speed.x < 0)
            g.scale(1, -1);

        // 1. Draw body
        drawBody(g);

        // 2. Draw Shell
        drawShell(g);

        // 3. Draw Head
        drawHead(g);

        // 4. Draw legs
        drawLegs(g);

        g.setTransform(af);
    }

    private void drawBody(Graphics2D g) {
        g.setStroke(new BasicStroke((float) 0.25));
        g.setColor(new Color(84, 158, 79));

        int width = size * 3 - size / 5;
        int height = size * 2 - size / 4;
        g.fillArc(-width / 2, -height / 2, width, height, 190, 360);
    }

    private void drawShell(Graphics2D g) {
        g.setColor(new Color(105, 68, 4));

        int width = size * 3;
        int height = size * 2;
        g.fillArc(-width / 2, -height / 2, width, height, 0, 190);
    }

    private void drawHead(Graphics2D g) {
        int body_width = (size * 3);
        // int body_height = (size * 2);

        g.setColor(new Color(84, 158, 79));
        int head_width = size;
        int head_height = size / 2;
        g.fillOval((body_width / 2) - (size / 5), 0, head_width, head_height);

        g.setColor(Color.BLACK);
        int eye_height = head_height;
        int eye_width = head_width;
        g.fillOval((body_width / 2) + (body_width / 8), eye_height / 4, size / 8, size / 9);
    }

    private void drawLegs(Graphics2D g) {
        int body_width = (size * 3);
        int body_height = (size * 2);
        g.setColor(new Color(84, 158, 79));

        // front legs
        g.fillOval(body_width / 9, body_height / 5, body_width / 5, (2 * body_height) / 5);

        // back legs
        g.fillOval(-body_width / 3, body_height / 5, body_width / 5, (2 * body_height) / 5);

    }

    @Override
    public void checkCollision(Dimension panelSize) {
        if ((pos.x < size / 2 * scale) || (pos.x > panelSize.width - size / 2 * scale))
            speed.x *= -1;
        if ((pos.y < size / 2 * scale) || (pos.y > panelSize.height - size / 2 * scale))
            speed.y *= -1;
    }
}
