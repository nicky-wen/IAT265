import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PacmanPanel extends JPanel implements ActionListener {

	private Pacman p1;
	private Pacman p2;
	private Timer t;
	private Dimension size;

	public PacmanPanel(Dimension initialSize) {
		super();

		size = initialSize;
		p1 = new Pacman(size.width / 3, size.height / 2,
				Math.min(size.width, size.height) / 10,
				(int) Util.random(-10, 10), (int) Util.random(-10, 10), Util.randomColor());
		p2 = new Pacman(size.width / 6, size.height / 2,
				Math.min(size.width, size.height) / 10,
				(int) Util.random(-10, 10), (int) Util.random(-10, 10), Util.randomColor());

		t = new Timer(33, this);
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.size = getSize();
		setBackground(Color.DARK_GRAY);
		Graphics2D g2 = (Graphics2D) g; // new
		p1.draw(g2);
		p2.draw(g2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p1.move();
		p1.checkCollision(size, p2);
		p2.move();
		p2.checkCollision(size, p1);

		repaint();
	}

}
