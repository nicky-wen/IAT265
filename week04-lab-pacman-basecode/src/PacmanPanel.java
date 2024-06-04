import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PacmanPanel extends JPanel implements ActionListener {
	
	private Pacman p1, p2;
	private Timer t;
	private Dimension pnlSize;
	
	public PacmanPanel() {
		super();
		this.pnlSize = new Dimension(800, 600);
		
		this.setPreferredSize(pnlSize);

		this.p1 = new Pacman(pnlSize.width/3, pnlSize.height/2, Math.min(pnlSize.width, pnlSize.height)/10);
		this.p2 = new Pacman(pnlSize.width/3*2, pnlSize.height/2, Math.min(pnlSize.width, pnlSize.height)/10);
		
		t = new Timer(33, this);
		t.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pnlSize = getSize();
		setBackground(Color.GRAY);
		Graphics2D g2 = (Graphics2D) g;
		p1.draw(g2);
		p2.draw(g2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p1.move();
//		p1.setScale(p2.scale);
//		p1.setToOtherPacmanScale(p2);
		p1.checkCollision(pnlSize);
		
		p2.move();
		p2.checkCollision(pnlSize);
		
		repaint();
	}
	
}
