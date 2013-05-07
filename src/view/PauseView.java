package view;

import java.util.ArrayList;

import model.Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class PauseView {
	private int buttonHeight;
	private int buttonWidth;
	private int isMarked;
	private ArrayList<Rectangle> buttonList;

	public PauseView() {
		this.buttonWidth = Game.WINDOW_WIDTH;
		this.buttonHeight = (2*Game.WINDOW_HEIGHT)/15;
		this.isMarked = 0;
		buttonList = new ArrayList<Rectangle>();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		/*Draw illusion image of the game*/
		Image pauseBackground = new Image("pics/pauseBackground.png");
		g.drawImage(pauseBackground, 0, 0);

		/*Make background darker to highlight pause menu*/
		g.setColor(new Color(0f, 0f, 0f, 0.3f));
		g.fillRect(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

		/*Create pause menu "buttons"*/
		//start position
		int buttonX = 0;
		int buttonY = Game.WINDOW_HEIGHT/5;
		for(int i = 0; i < 5; i++){
			this.buttonList.add(new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight));

			if(buttonList.indexOf(buttonList.get(i)) == isMarked) {
				g.setColor(new Color(0f, 0f, 0f, 0.4f));
				g.fill(buttonList.get(i));
			} else {
				g.setColor(new Color(0f, 0f, 0f, 0f));
				g.draw(buttonList.get(i));
			}
			/*Add labels to buttons*/
			switch(i) {
			case 0: g.drawImage(new Image("pics/start_game.png"), buttonX, buttonY);
			break;
			case 1: g.drawImage(new Image("pics/sound_on.png"), buttonX, buttonY);
			break;
			case 2: g.drawImage(new Image("pics/music_on.png"), buttonX, buttonY);
			break;
			case 3: g.drawImage(new Image("pics/controls.png"), buttonX, buttonY);
			break;	
			case 4: g.drawImage(new Image("pics/exit_to_menu.png"), buttonX, buttonY);
			break;
			}

			//increase Y with buttonHeight to place the buttons underneath each other
			buttonY = buttonY + buttonHeight;
		}
	}

	/*Move marker if key is pressed down*/
	public void markButtonDown() {
		isMarked = ++isMarked % 5;
	}

	/*Move marker if key is pressed up*/
	public void markButtonUp() {
		isMarked = (isMarked + 4) %5; //add 4 to make positive (--isMarked + 5)
	}

	public int getIsMarked() {
		return isMarked;
	}

}
