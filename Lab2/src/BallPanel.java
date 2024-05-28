import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
public class BallPanel extends JPanel implements ActionListener {
	
	private Ball ball;
	private Timer t;
	public final static int PAN_WIDTH  = 800;
	public final static int PAN_HEIGHT = 600;

	
	public BallPanel() {
		super();
		this.setPreferredSize(new Dimension(PAN_WIDTH, PAN_HEIGHT));
		int speed_x = (int) (Math.random()*10 - 5);
		int speed_y = (int) (Math.random()*10 - 5);

		ball = new Ball(PAN_WIDTH/2, PAN_HEIGHT/2, Math.min(PAN_WIDTH, PAN_HEIGHT)/10, 
			speed_x, speed_y);
		t = new Timer(33, this);
		t.start();
	}	
	@Override
	public void paintComponent(Graphics g) {
		setBackground(Color.black);
		//FYI: the panel's size can be accessed via its getSize() call 
		//and we'll use this function down the road, now just display for you to see
		System.out.println(this.getSize().width + ":" + this.getSize().height);

		ball.draw(g);
	}

	public void actionPerformed(ActionEvent e) {
		ball.move();
		// ball.checkCollision(getSize());
		repaint();
	}
	
}

