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

	public void checkCollision(Dimension panelSize, Pacman otherPacman) {
		if ((pos.x < size / 2 * scale) || (pos.x > panelSize.width - size / 2 * scale))
			speed.x *= -1;
		if ((pos.y < size / 2 * scale) || (pos.y > panelSize.height - size / 2 * scale))
			speed.y *= -1;

		// Check collision with other pacman
		// double bodyRadius = (size / 2) * scale;
		// double otherPacmanBodyRadius = (otherPacman.getSize() / 2) *
		// otherPacman.getScale();
		// PVector otherPacmanPosition = otherPacman.getPosition();

		// if (((pos.x + bodyRadius) >= (otherPacmanPosition.x - otherPacmanBodyRadius))
		// ||
		// ((pos.x - bodyRadius) <= (otherPacmanPosition.x - otherPacmanBodyRadius)) ||
		// ((pos.y + bodyRadius) >= (otherPacmanPosition.y - otherPacmanBodyRadius)) ||
		// ((pos.y - bodyRadius) <= (otherPacmanPosition.y - otherPacmanBodyRadius))) {
		// otherPacman.increaseScale();
		// this.respawn(panelSize);
		// }
		// Check collision with other pacman
		double bodyRadius = (size / 2) * scale;
		double otherPacmanBodyRadius = (otherPacman.getSize() / 2) * otherPacman.getScale();
		PVector otherPacmanPosition = otherPacman.getPosition();

		// Calculate the distance between the centers of the two Pacmen
		double distanceX = pos.x - otherPacmanPosition.x;
		double distanceY = pos.y - otherPacmanPosition.y;
		double distanceSquared = distanceX * distanceX + distanceY * distanceY;

		// Calculate the sum of the radii
		double radiiSum = bodyRadius + otherPacmanBodyRadius;

		// Check if the distance between the centers is less than the sum of the radii
		if (distanceSquared < radiiSum * radiiSum) {
			if (scale > otherPacman.scale) {
				this.increaseScale();
				otherPacman.respawn(panelSize);
			} else {
				this.respawn(panelSize);
				otherPacman.increaseScale();
			}
		}
	}

	public void increaseScale() {
		this.scale *= 1.20;
	}

	public void respawn(Dimension panelSize) {
		this.scale = 1;
		pos.set((float) panelSize.getWidth() / 2, (float) panelSize.getHeight() / 2);
	}

	public PVector getPosition() {
		return this.pos;
	}

	public int getSize() {
		return this.size;
	}

	public double getScale() {
		return this.scale;
	}
}