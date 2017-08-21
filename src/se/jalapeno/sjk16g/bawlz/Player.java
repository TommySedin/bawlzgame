package se.jalapeno.sjk16g.bawlz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity {
	private float destX, destY;
	public Player() {
		super(0.5f, 0.5f);
	}

	@Override
	public BufferedImage getImage() {
		if (img == null) {
			img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
			Graphics g = img.getGraphics();
			g.setColor(Color.GREEN);
			g.fillOval(0, 0, 20, 20);
		}
		return img;
	}

	public void think() {
		if (x > destX) {
			veloX -= 0.0025f;
		} else if (x < destX) {
			veloX += 0.0025f;
		}
		if (y > destY) {
			veloY -= 0.0025f;
		} else if (y < destY) {
			veloY += 0.0025f;
		}
		
		x += veloX;
		y += veloY;
		veloX *= 0.99f;
		veloY *= 0.99f;
	}
	public void setDestination(float x, float y) {
		this.destX = x;
		this.destY = y;
	}
}
