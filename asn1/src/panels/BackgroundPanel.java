package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import models.background.Bubble;
import models.Creature;
import models.creatures.Turtle;

public class BackgroundPanel extends JPanel {

    public BackgroundPanel(Dimension size) {
        super();
        this.setSize(size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Set background to gradient
        Color light_blue = new Color(124, 216, 235);
        Color dark_blue = new Color(9, 46, 94);
        GradientPaint background_colour = new GradientPaint(
                0,
                0,
                light_blue,
                0,
                this.getHeight(),
                dark_blue);
        g2.setPaint(background_colour);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

        // 2. Add bubbles
        // int i;
        // for(i = 0; i < 5; i++) {

        // }
        Bubble bubble = new Bubble(0, 0, 25);
        bubble.draw(g2);

        // for (int i = 0; i < 5; i++) {
        Creature turtle = new Turtle(1, // (int) (Math.random() * 1920),
                0,
                (int) Math.random() * 10,
                0,
                0);
        turtle.draw(g2);
        // }

    }
}
