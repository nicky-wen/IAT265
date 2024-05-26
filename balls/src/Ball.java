import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int x, y, size;
	
	public Ball(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x-size/2, y-size/2, size, size);
	}

}
