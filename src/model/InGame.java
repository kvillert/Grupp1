package model;


public class InGame {
	private Player player;
	private StatusBar statusBar;
	private float time;
		
	public InGame(Character character) { 
		this.time = 2*60; //set specific to level (in this case it is 2 min)
		player = new Player(character);
		statusBar = new StatusBar();
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public Player getPlayer() {
		return player;
	}


	public StatusBar getStatusBar() {
		return statusBar;
	}
}
