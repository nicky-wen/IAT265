package models.background;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bubble {
    private int x;
    private int y;
    private double scale = 1.0;

    public Bubble(int x, int y, double scale) {
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    public void draw(Graphics2D g) {
        g.translate(x, y);
        g.scale(scale, scale);
        g.setStroke(new BasicStroke((float) 0.25));

        // Draw bubble circle
        g.setColor(Color.WHITE);
        g.fillOval(x, y, (int) (1 * scale), (int) (1 * scale));
    }
}
