package se.jalapeno.sjk16g.bawlz;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class BawlzGame extends JFrame {
	private static BawlzGame instance;
	private PlayField playField;
	private Player player;
	private PlayerController playerController;

	private List<Enemy> enemies = new ArrayList<Enemy>();
	private List<Enemy> removeEnemies = new ArrayList<Enemy>();

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

		player = new Player();

		playerController = new MouseController();
		playerController.init(this, player);
		//pack();

		enemies.add(new Enemy(-0.25f, 0.5f, 0.005f, 0f));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				runFrame();
			}
		}, 0 /*delay*/, 10 /*period*/);
	}



	public Player getPlayer() {
		return player;
	}
	public List<Enemy> getEnemies() {
		return enemies;
	}
	public PlayField getPlayField() {
		return playField;
	}

	private void runFrame() {
		// Anropa think() på Playern
		playerController.runFrame();
		player.runFrame();
		// Anropa think() på alla fiender
		for (Enemy e : enemies) {
			e.runFrame();
		}

		synchronized (enemies) {
			enemies.add(new Enemy(-0.25f, (float) (Math.random()), 0.005f, 0f));
			enemies.removeAll(removeEnemies);
		}

		// Anropa think() på alla bullets

		// Säg åt PlayField att rita om		
		playField.repaint();
	}
	
	public void removeEnemy(Enemy e) {
		removeEnemies.add(e);
	}

	public static void main(String[] args) {
		BawlzGame game = getInstance();
		game.setVisible(true);
	}

}
