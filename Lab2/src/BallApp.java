import javax.swing.JFrame;

public class BallApp extends JFrame {

	public BallApp(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		
		//instantiating our BallPanel
		BallPanel panel = new BallPanel();
		
		//adding it to the current frame
		this.add(panel);
		this.pack();
		
		//displaying the frame
		this.setVisible(true);
	}

	public static void main(String[] args) {
		BallApp app = new BallApp("My Ball App");
	}

}
