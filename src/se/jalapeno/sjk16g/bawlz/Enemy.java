package se.jalapeno.sjk16g.bawlz;

public abstract class Enemy extends Entity {
	protected int fireDelay = 0;
	public Enemy(float x, float y, float veloX, float veloY) {
		super(x, y);
		this.veloX = veloX;
		this.veloY = veloY;
	}

	public void runFrame() {
		x += veloX;
		y += veloY;
		if ( (veloX > 0 && x > 1) || (veloX < 0 && x < 0) ||
			 (veloY > 0 && y > 1) || (veloY < 0 && y < 0)) {
			BawlzGame.getInstance().removeEnemy(this);
		}
		if (fireDelay > 0) {
			fireDelay--;
			if (fireDelay == 0) fireBullet();
		}
	}
	public abstract void fireBullet();
}
