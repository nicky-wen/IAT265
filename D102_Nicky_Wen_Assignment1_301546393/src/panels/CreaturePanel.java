package panels;

/* --- Creature Panel ---
 * Manages the lifetimes and interactions of creatures within the ecosystem
 */
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.UUID;

import models.Creature;
import models.creatures.Turtle;

public class CreaturePanel extends JPanel implements ActionListener {

    private Timer timer;
    private Dimension size;
    private HashMap<String, Creature> creatures = new HashMap<String, Creature>();

    public CreaturePanel(Dimension initialSize) {
        super();

        size = initialSize;

        for (int i = 0; i < 5; i++) {
            String creature_id = UUID.randomUUID().toString();
            Creature turtle = new Turtle(0, // (int) (Math.random() * 1920),
                    0,
                    (int) Math.random() * 10,
                    0,
                    0);
            // Creature turtle = new Turtle((int) (Math.random() * 1920),
            // (int) (Math.random() * 1080),
            // (int) Math.random() * 10,
            // 0,
            // 0);
            creatures.put(creature_id, turtle);

            timer = new Timer(33, this);
            timer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Creature creature : creatures.values()) {
            creature.draw(g2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
