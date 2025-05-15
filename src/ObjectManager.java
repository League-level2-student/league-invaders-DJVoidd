import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;
	Random gen;
	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		rocket = new Rocketship(0, 0, 0, 0);
		aliens = new ArrayList<>();
		gen = new Random();
		projectiles = new ArrayList<>();
		
	
	}
	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if(aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive(false);
			aliens.get(i).draw(null);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}
	void addProjectlie(Projectile projectile) {;
	;
	projectiles.add(projectile);
	}
	void addAlien() {
		aliens.add(new Alien(gen.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}
		for (Alien alien : aliens) {
			alien.draw(g);
		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}
	
}
