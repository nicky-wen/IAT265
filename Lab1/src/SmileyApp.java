import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SmileyApp {

	public static void main(String[] args) {
		
		//create a new JFrame - window frame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        //create a new SmileyPanel - panel for drawing
        JPanel panel = new SmileyPanel();
        
        frame.add(panel);
        frame.pack(); //Pack the window frame around the panel to determine its size
        frame.setVisible(true);
	}

}
