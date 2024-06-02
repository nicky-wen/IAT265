package main.java.com.nicky;

import javax.swing.JFrame;

public class EcosystemApp extends JFrame {
    public EcosystemApp(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);

        // 1. Create background panel and add it to the frame
        BackgroundPanel background_panel = new BackgroundPanel(this.getSize());
        this.add(background_panel);

        // 2. Create Creatures and add them to the frame
        CreaturePanel creature_panel = new CreaturePanel(this.getSize());
    }
}
