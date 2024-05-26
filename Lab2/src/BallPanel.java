import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class BallPanel extends JPanel {
	
	private Ball ball;
	public final static int PAN_WIDTH  = 800;
	public final static int PAN_HEIGHT = 600;

	
	public BallPanel() {
		super();
		this.setPreferredSize(new Dimension(PAN_WIDTH, PAN_HEIGHT));
		ball = new Ball(PAN_WIDTH/2, PAN_HEIGHT/2, Math.min(PAN_WIDTH, PAN_HEIGHT)/10);
	}	
	@Override
	public void paintComponent(Graphics g) {
		setBackground(Color.black);
		//FYI: the panel's size can be accessed via its getSize() call 
		//and we'll use this function down the road, now just display for you to see
		System.out.println(this.getSize().width + ":" + this.getSize().height);

		ball.draw(g);
	}
	
}

