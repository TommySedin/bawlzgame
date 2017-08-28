package se.jalapeno.sjk16g.bawlz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Entity {
	public Bullet() {
		super(0,0);
	}
	public Bullet(float x, float y, float veloX, float veloY) {
		super(0,0);
		reinit(x,y,veloX,veloY);
	}
	public void reinit(float x, float y, float veloX, float veloY) {
		this.x = x;
		this.y = y;
		this.veloX = veloX;
		this.veloY = veloY;
	}

	@Override
	public BufferedImage getImage() {
		if (img == null) {
			img = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.setColor(Color.ORANGE);
			g.fillOval(0, 0, 10, 10);
		}
		return img;
	}

	public void runFrame() {
		x += veloX;
		y += veloY;
		if ( (veloX > 0 && x > 1) || (veloX < 0 && x < 0) ||
			 (veloY > 0 && y > 1) || (veloY < 0 && y < 0)) {
			BulletPool.returnToPool(this);
		}
	}
}
