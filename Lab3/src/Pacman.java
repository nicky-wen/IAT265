import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.AffineTransform;

import processing.core.PVector;

public class Pacman {

	private int size;
	private PVector pos, speed;
	private Color color;
	private double scale;

	public Pacman(int x, int y, int size, int speedx, int speedy, Color c) {
		this.pos = new PVector(x, y);
		this.size = size;
		this.speed = new PVector(speedx, speedy);
		this.color = c;
		this.scale = 1;
	}

	public void draw(Graphics2D g) {
		AffineTransform af = g.getTransform();

		g.translate((int) pos.x, (int) pos.y);
		g.rotate(speed.heading());
		g.scale(scale, scale);
		if (speed.x < 0)
			g.scale(1, -1);

		g.setColor(color);
		g.fillArc(-size / 2, -size / 2, size, size, 30, 300);

		g.setColor(Color.black);
		g.fillOval(0, -size / 4, size / 10, size / 10);

		g.setTransform(af);
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

	public void increaseScale() {
		this.scale *= 1.10;
	}

}