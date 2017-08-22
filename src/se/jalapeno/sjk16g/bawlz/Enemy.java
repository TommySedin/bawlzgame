package se.jalapeno.sjk16g.bawlz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Entity {
	public Enemy(float x, float y, float veloX, float veloY) {
		super(x, y);
		this.veloX = veloX;
		this.veloY = veloY;
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

	public void runFrame() {
		x += veloX;
		y += veloY;
		if ( (veloX > 0 && x > 1) || (veloX < 0 && x < 0) ||
			 (veloY > 0 && y > 1) || (veloY < 0 && y < 0)) {
			BawlzGame.getInstance().removeEnemy(this);
		}
	}
}
