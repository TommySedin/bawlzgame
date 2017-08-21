package se.jalapeno.sjk16g.bawlz;

import java.awt.image.BufferedImage;

public abstract class Entity {
	float x, y;
	float veloX, veloY;
	BufferedImage img;

	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public float getX() { return x; }
	public float getY() { return y; }
	public abstract BufferedImage getImage();

	public static boolean isOverlapping(Entity a, Entity b) {
		return false;
	}
}
