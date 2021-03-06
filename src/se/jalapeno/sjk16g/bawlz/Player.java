package se.jalapeno.sjk16g.bawlz;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
	private int score = 0;
	private List<ScoreUpdateListener> scoreUpdateListeners = new ArrayList<>();

	public Player() {
		super(0.5f, 0.5f);
	}
	public void addScoreUpdateListener(ScoreUpdateListener scoreUpdateListener) {
		scoreUpdateListeners.add(scoreUpdateListener);
	}
	public void addScore(int amount) {
		score += amount;
		for (ScoreUpdateListener l : scoreUpdateListeners) {
			l.scoreUpdated(new ScoreUpdateEvent(score));
		}
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

	public void runFrame() {
		x += veloX;
		y += veloY;
		veloX *= 0.95f;
		veloY *= 0.95f;
	}
	
	public void accelerateX(float amount) {
		veloX += amount;
		if (Math.abs(veloX) > 0.1f) veloX = Math.signum(veloX) * 0.1f;
	}
	public void accelerateY(float amount) {
		veloY += amount;
		if (Math.abs(veloY) > 0.1f) veloY = Math.signum(veloY) * 0.1f;
	}
}
