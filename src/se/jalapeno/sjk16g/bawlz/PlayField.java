package se.jalapeno.sjk16g.bawlz;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class PlayField extends JPanel implements ScoreUpdateListener {
	private int width, height;
	private int score = 0;

	public PlayField(int w, int h, Player player) {
		this.width = w;
		this.height = h;
		player.addScoreUpdateListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Player p = BawlzGame.getInstance().getPlayer();
		g.drawImage(p.getImage(), (int)(p.getX() * width), (int) (p.getY() * height), null);
		
		List<Enemy> enemies = BawlzGame.getInstance().getEnemies();
		synchronized (enemies) {
			for (Enemy e : BawlzGame.getInstance().getEnemies()) {
				g.drawImage(e.getImage(), (int)(e.getX() * width), (int) (e.getY() * height), null);
			}
		}
		
		for (Bullet b : BulletPool.getActiveBullets()) {
			g.drawImage(b.getImage(), (int)(b.getX() * width), (int) (b.getY() * height), null);
		}
		
		g.drawString("Score: " + score, 0, 100);
	}

	@Override
	public void scoreUpdated(ScoreUpdateEvent event) {
		this.score = event.getNewScore();
	}
}
