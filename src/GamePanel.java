import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font regText = new Font("Arial", Font.PLAIN, 24);
	Timer frameDraw;
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
		System.out.println("ACTION");
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e);
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
