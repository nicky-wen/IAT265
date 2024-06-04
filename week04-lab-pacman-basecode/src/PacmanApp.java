import javax.swing.JFrame;

public class PacmanApp extends JFrame {

	public PacmanApp(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//instantiating our BallPanel
		PacmanPanel panel = new PacmanPanel();
		
		//adding it to the current frame
		this.add(panel);
		this.pack();
		//displaying the frame
		this.setVisible(true);
	}

	public static void main(String[] args) {
		PacmanApp app = new PacmanApp("My Interactive Pacman App");
	}

}
