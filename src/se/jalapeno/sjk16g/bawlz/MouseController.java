package se.jalapeno.sjk16g.bawlz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController implements PlayerController, MouseMotionListener {
	private Player player;
	private float destX, destY;

	@Override
	public void init(BawlzGame game, Player player) {
		this.player = player;
		destX = player.getX();
		destY = player.getY();
		game.addMouseMotionListener(this);
	}

	@Override
	public void runFrame() {
		if (player.getX() > destX) {
			player.accelerateX(-0.0025f);
		} else if (player.getX() < destX) {
			player.accelerateX(0.0025f);
		}
		if (player.getY() > destY) {
			player.accelerateY(-0.0025f);
		} else if (player.getY() < destY) {
			player.accelerateY(0.0025f);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		destX = ((float) e.getX()) / BawlzGame.getInstance().getPlayField().getWidth();
		destY = ((float) e.getY()) / BawlzGame.getInstance().getPlayField().getHeight();
	}
}
