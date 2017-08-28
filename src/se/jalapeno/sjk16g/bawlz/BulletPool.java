package se.jalapeno.sjk16g.bawlz;

import java.util.*;

public class BulletPool {
	private static List<Bullet> pool = new ArrayList<>();
	private static List<Bullet> activeBullets = new ArrayList<>();
	
	public static Bullet getBullet(float x, float y, float veloX, float veloY) {
		if (pool.size() < 1) {
			Bullet b = new Bullet(x, y, veloX, veloY);
			synchronized (activeBullets) {
				activeBullets.add(b);
			}
			return b;
		} else {
			Bullet b = pool.remove(0);
			b.reinit(x, y, veloX, veloY);
			synchronized (activeBullets) {
				activeBullets.add(b);
			}
			return b;
		}
	}
	public static void returnToPool(Bullet b) {
		synchronized (activeBullets) {
			activeBullets.remove(b);
		}
		pool.add(b);
	}

	public static Bullet[] getActiveBullets() {
		synchronized (activeBullets) {
			return activeBullets.toArray(new Bullet[activeBullets.size()]);
		}
	}
}
