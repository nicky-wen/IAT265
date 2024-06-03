import javax.swing.JFrame;

import panels.EcosystemPanel;

public class EcosystemApp extends JFrame {
    public EcosystemApp(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 1500);

        // 1. Create background panel and add it to the frame
        EcosystemPanel ecosystem_panel = new EcosystemPanel(this.getSize());
        this.add(ecosystem_panel);

        // 3. Display the frame altogether
        this.setVisible(true);
    }
}
