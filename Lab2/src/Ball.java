import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int x, y, size, speed_x, speed_y;
	
	public Ball(int x, int y, int size, int speed_x, int speed_y) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.speed_x = speed_x;
		this.speed_y = speed_y;
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x-size/2, y-size/2, size, size);
	}

	public void move() {
		x += speed_x;
		y += speed_y;
	}

	public void checkCollision(Dimension panelSize) {
        if ((x < size/2) || (x > panelSize.width - size/2)) 
			speed_x *= -1;
            // speed_y *= -1;
    }
}
