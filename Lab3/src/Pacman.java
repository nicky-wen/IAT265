import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Pacman {
	
	private int x, y, size;
	private int speedx, speedy;
	private Color color;
	
	public Pacman(int x, int y, int size, int speedx, int speedy, Color c) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.speedx = speedx;
		this.speedy = speedy;
		this.color = c;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillArc(x-size/2, y-size/2, size, size, 30, 300);
		
		//eye
		g.setColor(Color.black);
		g.fillOval(x, y-size/4, size/10, size/10);
	}
	
	public void move() {
		x += speedx;
		y += speedy;
	}
	
	public void checkCollision(Dimension panelSize) {
		if ((x < size/2) || (x > panelSize.width - size/2)) speedx *= -1;
		if ((y < size/2) || (y > panelSize.height - size/2)) speedy *= -1;
	}
	

}
