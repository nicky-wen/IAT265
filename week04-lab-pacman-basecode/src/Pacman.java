import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import processing.core.PVector;

public class Pacman {

	private int size;
	private PVector pos, speed;
	private Color color;
	private double scale;
	private boolean selected;

	public Pacman(int x, int y, int size) {

		// given attributes
		this.pos = new PVector(x, y);
		this.size = size;

		// others
		this.speed = Util.randomPVector(5); // random direction of the speed 5 pixels/frame
		this.color = Util.randomColor(); // random color
		this.scale = 1; // default scale = 1
		this.selected = false; // not being selected
	}

	public void draw(Graphics2D g) {
		// transformation
		AffineTransform af = g.getTransform();
		g.translate((int) pos.x, (int) pos.y);
		g.rotate(speed.heading());
		g.scale(scale, scale);
		if (speed.x < 0)
			g.scale(1, -1);

		// body
		g.setColor(color);
		g.fillArc(-size / 2, -size / 2, size, size, 30, 300);

		// eye
		g.setColor(Color.black);
		g.fillOval(0, -size / 4, size / 10, size / 10);

		g.setTransform(af);

		// bounding box
		if (selected) {
			g.setColor(Color.red);
			g.drawRect((int) (pos.x - size * scale / 2), (int) (pos.y - size * scale / 2), (int) (size * scale),
					(int) (size * scale));
		}
	}

	public void move() {
		pos.add(speed);
	}

	public void checkCollision(Dimension panelSize) {
		if ((pos.x < size / 2 * scale) || (pos.x > panelSize.width - size / 2 * scale))
			speed.x *= -1;
		if ((pos.y < size / 2 * scale) || (pos.y > panelSize.height - size / 2 * scale))
			speed.y *= -1;
	}

	public void select() {
		this.selected = true;
	}

	public void deselect() {
		this.selected = false;
	}

	public void enlarge() {
		scale *= 1.1;
	}

	public void shrink() {
		scale *= .9;
	}

	public void setScale(double s) {
		scale = s;
	}

	public void setPos(int x, int y) {
		pos.set(x, y);
	}

	public void setToOtherPacmanScale(Pacman p) {
		scale = p.scale;
	}

	public boolean checkMouseHit(MouseEvent e) {
		return (Math.abs(e.getX() - pos.x) < size / 2) &&
				(Math.abs(e.getY() - pos.y) < size / 2);
	}
}
