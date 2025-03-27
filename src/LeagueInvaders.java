import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame gameWindow;
	GamePanel gamePanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	public LeagueInvaders() {
		gameWindow = new JFrame();
		gamePanel = new GamePanel();
		gameWindow.addKeyListener(gamePanel);
	}
	void setup() {
		gameWindow.setSize(WIDTH,HEIGHT);
		gameWindow.add(gamePanel);
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
		game.setup();
	}
}
