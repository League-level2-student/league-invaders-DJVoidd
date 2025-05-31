import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	int projX;
	int projY;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font regText = new Font("Arial", Font.PLAIN, 24);
	Timer frameDraw;
	Rocketship rocket = new Rocketship(250,700,50,50);
	boolean upPressed = false;
	boolean downPressed = false;
	boolean leftPressed = false;
	boolean rightPressed = false;
	ObjectManager manager = new ObjectManager(rocket);
	Timer alienSpawn;
	public GamePanel(){
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
			drawMenuState(g);
		}
		else if(currentState == GAME){
			drawGameState(g);
		}
		else if(currentState == END){
			drawEndState(g);
		}
	}
	void updateMenuState() { 
		
	}
	void updateGameState() {  
		if (upPressed) {
			rocket.up();
		}
		if (downPressed) {
			rocket.down();
		}
		if (leftPressed) {
			rocket.left();
		}
		if (rightPressed) {
			rocket.right();
		}
		if(rocket.x>434) {
			System.out.println("FIX");
			rocket.x=434;
		}
		if(rocket.x<0) {
			System.out.println("FIX");
			rocket.x=0;
		}
		if(rocket.y>715) {
			System.out.println("FIX");
			rocket.y=715;
		}
		if(rocket.y<0) {
			System.out.println("FIX");
			rocket.y=0;
		}
		manager.update();
	}
	void updateEndState()  { 

	}
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 15, 200);
		g.setFont(regText);
		g.drawString("Press ENTER to start", 120, 400);
		g.drawString("Press SPACE for instructions", 80, 600);

	}
	void drawGameState(Graphics g) { 
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		try {
			g.drawImage(ImageIO.read(this.getClass().getResourceAsStream("space.png")), 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} catch (IOException e) {
		}
		manager.draw(g);
	}
	void drawEndState(Graphics g)  { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 95, 200);
		g.setFont(regText);
		g.drawString("You killed enemies", 135, 400);
		g.drawString("Press ENTER to restart", 110, 600);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
			updateMenuState();
		}
		else if(currentState == GAME){
			updateGameState();
		}
		else if(currentState == END){
			updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addProjectlie(new Projectile(rocket.x+25, rocket.y, 5, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			upPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}
}