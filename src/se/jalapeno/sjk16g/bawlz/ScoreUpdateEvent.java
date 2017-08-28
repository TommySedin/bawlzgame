package se.jalapeno.sjk16g.bawlz;

public class ScoreUpdateEvent {
	private int newScore;
	public ScoreUpdateEvent(int newscore) {
		this.newScore = newscore;
	}
	public int getNewScore() {
		return newScore;
	}
}
