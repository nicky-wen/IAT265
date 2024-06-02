package models.creatures;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import models.Creature;
import processing.core.PVector;

public class Turtle extends Creature {

    public Turtle(int x, int y, int size, int speed_x, int speed_y) {
        super(x, y, size, speed_x, speed_y);
    };

    public void draw(Graphics2D g) {
        g.translate(pos.x, pos.y);
        g.scale(scale, scale);
        g.setStroke(new BasicStroke((float) 0.25));

        // Draw bubble circle
        g.setColor(new Color(84, 158, 79));
        g.fillOval((int) pos.x, (int) pos.y, (int) (2 * scale), (int) (1 * scale));
    }

    /*
     * @Override
     * public void draw(Graphics2D g) {
     * g.translate(this.getPosX(), this.getPosY());
     * 
     * // draw body
     * // drawBody(g);
     * g.setColor(new Color(84, 158, 79));
     * g.drawOval(0,
     * 0,
     * 13,
     * 10);
     * 
     * // draw shell
     * 
     * // draw head
     * 
     * // draw legs
     * 
     * }
     */

    private void drawBody(Graphics2D g) {
        g.setColor(new Color(84, 158, 79));
        g.drawOval((int) pos.x,
                (int) pos.y,
                (int) (size * 1.3),
                (int) size);

    }

}
