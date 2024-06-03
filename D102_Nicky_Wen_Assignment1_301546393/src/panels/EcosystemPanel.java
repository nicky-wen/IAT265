package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.UUID;

import javax.swing.JPanel;
import javax.swing.Timer;

import models.Creature;
import models.creatures.Turtle;
import processing.core.PVector;
import utils.Util;

public class EcosystemPanel extends JPanel implements ActionListener {

    private Dimension size;
    private Timer timer;
    private HashMap<String, Creature> creatures = new HashMap<String, Creature>();

    public EcosystemPanel(Dimension size) {
        super();
        this.size = size;

        for (int i = 0; i < 5; i++) {
            Creature turtle = new Turtle(
                    (int) (Math.random() * (size.getWidth() / 2)),
                    (int) (Math.random() * (size.getHeight() / 2)),
                    (int) Math.min(size.getHeight(), size.getWidth()) / 20,
                    (int) Util.random(-10, 10),
                    (int) Util.random(-10, 10));
            String random_id = UUID.randomUUID().toString();
            creatures.put(random_id, turtle);
        }

        timer = new Timer(33, this);
        timer.start();
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
        // Bubble bubble = new Bubble(0, 0, 25);
        // bubble.draw(g2);

        // Create turtles
        creatures.forEach((key, creature) -> {
            creature.draw(g2);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        creatures.forEach((key, creature) -> {
            int x_shift = (int) Util.random(-1, 1);
            int y_shift = (int) Util.random(-1, 1);
            creature.changeSpeed(new PVector(x_shift, y_shift));
            creature.move();
        });
        creatures.forEach((key, creature) -> {
            creature.checkCollision(size);
        });

        repaint();
    }
}
