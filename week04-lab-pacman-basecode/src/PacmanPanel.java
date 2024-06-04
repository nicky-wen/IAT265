import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PacmanPanel extends JPanel implements ActionListener {

	private class MyMouseMotionAdapter extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			for (Pacman p : pList) {
				if (p.checkMouseHit(e))
					p.setPos(e.getX(), e.getY());
			}
		}
	}

	private class MyMouseAdapter extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.toString());
		}
	}

	private ArrayList<Pacman> pList;
	private Timer t;
	private Dimension pnlSize;

	public PacmanPanel() {
		super();
		this.pnlSize = new Dimension(800, 600);

		this.setPreferredSize(pnlSize);

		this.pList = new ArrayList<Pacman>();
		for (int i = 0; i < 3; i++) {
			Pacman p = new Pacman(pnlSize.width / 3, pnlSize.height / 2, Math.min(pnlSize.width, pnlSize.height) / 10);
			pList.add(p);
		}

		t = new Timer(33, this);
		t.start();

		addMouseListener(new MyMouseAdapter());
		addMouseMotionListener(new MyMouseMotionAdapter());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		pnlSize = getSize();
		setBackground(Color.GRAY);
		Graphics2D g2 = (Graphics2D) g;
		for (Pacman p : pList) {
			p.draw(g2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Pacman p : pList) {
			p.move();
		}
		for (Pacman p : pList) {
			p.checkCollision(pnlSize);
		}

		repaint();
		// p1.setScale(p2.scale);
		// p1.setToOtherPacmanScale(p2);
	}

	// public void mouseClicked(MouseEvent e) {
	// if (p1.checkMouseHit(e))
	// p1.select();
	// if (p2.checkMouseHit(e))
	// p2.select();
	// }

	public void mousePressed(MouseEvent e) {
		for (Pacman p : pList)
			if (p.checkMouseHit(e)) {
				if (e.isShiftDown())
					p.enlarge();
				else if (e.isAltDown())
					p.shrink();
				else
					p.select();
			} else
				p.deselect();
	}

}
