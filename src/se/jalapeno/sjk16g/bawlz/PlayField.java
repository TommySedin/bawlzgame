package se.jalapeno.sjk16g.bawlz;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class PlayField extends JPanel {
	private int width, height;

	public PlayField(int w, int h) {
		this.width = w;
		this.height = h;
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
	}
}
