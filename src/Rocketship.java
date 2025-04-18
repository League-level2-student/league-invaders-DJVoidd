import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	public Rocketship(int x, int y, int width, int height) {
		super(x,y,width,height);
		speed = 10;
		x = Math.min(x,0);
		x = Math.max(x, 500);
		y = Math.min(y, 0);
		y = Math.max(y, 800);
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	 public void right() {
	        x+=speed;
	    }
	 public void left() {
	        x-=speed;
	    }
	 public void up() {
	        y-=speed;
	    }
	 public void down() {
	       y+=speed;
	 }
}

