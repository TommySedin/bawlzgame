package se.jalapeno.sjk16g.bawlz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SimpleEnemy extends Enemy {
	public SimpleEnemy(float x, float y, float veloX, float veloY) {
		super(x, y, veloX, veloY);
		fireDelay = 20;
	}

	@Override
	public BufferedImage getImage() {
		if (img == null) {
			img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.setColor(Color.RED);
			g.fillOval(0, 0, 20, 20);
		}
		return img;
	}

	@Override
	public void fireBullet() {
		Player pl = BawlzGame.getInstance().getPlayer();
		float dx = pl.getX() - x;
		float dy = pl.getY() - y;
		
		BulletPool.getBullet(x, y, dx/100, dy/100);
		fireDelay = 20;
	}
}
