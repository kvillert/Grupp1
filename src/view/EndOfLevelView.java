package view;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import model.Game;
/**
 * 
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class EndOfLevelView {
	final private int score;
	final private boolean gameOver;
	final private boolean victory;
	final private Image gameOverImage;
	final private Image victoryImage;
	final private Image levelClearedImage;

	public EndOfLevelView (final int score, final boolean gameOver, final boolean victory) throws SlickException {
		this.score = score;
		this.gameOver = gameOver;
		this.victory = victory;
		gameOverImage = new Image("pics/gameOver.png");
		victoryImage = new Image("pics/victory.png");
		levelClearedImage = new Image("pics/levelCleared.png");
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		if (gameOver) {
			gameOverImage.draw();
			g.setColor(Color.red);
		} else if (victory) {
			victoryImage.draw();
			g.setColor(Color.green);
		} else {
			levelClearedImage.draw();
			g.setColor(Color.yellow);
		}
		g.drawString("ENTER - continue", Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 40);
		g.drawString("ESC - back to menu", Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 60);
		g.drawString("Score: " + this.score, Game.WINDOW_WIDTH/2 - 30, Game.WINDOW_HEIGHT/2 + 90);
	}
}