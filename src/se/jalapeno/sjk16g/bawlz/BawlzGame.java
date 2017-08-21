package se.jalapeno.sjk16g.bawlz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class BawlzGame extends JFrame implements MouseMotionListener {
	private static BawlzGame instance;

	public static BawlzGame getInstance() {
		if (instance == null) {
			instance = new BawlzGame();
		}
		return instance;
	}
	private BawlzGame() {
		setSize(500, 400);

		playField = new PlayField(500, 400);
		this.add(playField);
		this.addMouseMotionListener(this);
		//pack();
		
		player = new Player();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				runFrame();
			}
		}, 0 /*delay*/, 10 /*period*/);
	}

	private PlayField playField;
	private Player player;

	public Player getPlayer() {
		return player;
	}

	private void runFrame() {
		// Anropa think() på Playern
		player.think();
		// Anropa think() på alla fiender
		// Anropa think() på alla bullets

		// Säg åt PlayField att rita om		
		playField.repaint();
	}

	public static void main(String[] args) {
		BawlzGame game = getInstance();
		game.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		player.setDestination( ((float) e.getX()) / playField.getWidth(), ((float) e.getY()) / playField.getHeight() );
	}

}
