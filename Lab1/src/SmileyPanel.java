import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class SmileyPanel extends JPanel {

	public SmileyPanel() {
		this.setPreferredSize(new Dimension(800, 600)); // Set panel's size
	}

	@Override
	public void paintComponent(Graphics g) {
		 Dimension size = getSize();
	        
        //make sure the face is always smaller than the windows
        int d = Math.min(size.width, size.height);
        
        //align the face to the center of the window
        int x = (size.width - d)/2;
        int y = (size.height - d)/2;
	        

		// draw a face
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, d, d);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, d, d);
		
		//draw mouth
		g.drawArc(x + d / 4,      // x coordinate of top-left pivot
		          y + 2 * d / 5,  // y coordinate of top-left pivot
		          d / 2,          // horizontal size (width)
		          d / 3,          // vertical size (height)
		          0,              // starting angular position
		          180            // angle of the arc
		);
		
		//calculate eye diameter as 1/20 of the face diameter
		int ed = d / 20;
		                
		// draw 2 eyes
		g.setColor(Color.WHITE);
		g.fillOval(size.width/2 + size.width/8, y + size.height/5, size.width/8, size.height/8);
		g.fillOval(size.width/2 - size.width/4, y + size.height/5, size.width/8, size.height/8);
		
		// draw third eye on forehead
		g.fillOval(size.width/2 - size.width/16, y + size.height/7, size.width/8, size.height/8);

		// draw 2 pupils
		g.setColor(Color.BLACK);
		g.fillOval(size.width/2 + size.width/8, y + size.height/5, size.width/12, size.height/8);
		g.fillOval(size.width/2 - size.width/4, y + size.height/5, size.width/12, size.height/8);
		g.fillOval(size.width/2 - size.width/32, y + size.height/7, size.width/16, size.height/8);
	}
}
