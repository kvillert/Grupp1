package controller;

import model.Controls;
import model.PauseMenu;
import model.StartMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.ControlsView;
/**
 * This state shows how to play the game, which controls on the keyboard that you can use
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class ControlsController extends BasicGameState {
	
	private ControlsView controlsView;
	private final GameController gameController;
	private StateBasedGame sbg;
	private GameContainer gc;

	public ControlsController(GameController gameController) {
		super();
		this.gameController = gameController;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		this.controlsView = new ControlsView();
		this.sbg = sbg;
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		this.controlsView.render(gc, sbg, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		this.gc = gc;

	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_TAB) {
			this.gameController.changeFullscreen(this.gc);
		}
		else if (key == Input.KEY_ENTER || key == Input.KEY_ESCAPE) {
			if (gameController.getGame().getInGame().isPaused()) {
				sbg.enterState(PauseMenu.STATE_ID);
			} else {
				sbg.enterState(StartMenu.STATE_ID);
			}
			
		}
	}

	@Override
	public int getID() {
		return Controls.STATE_ID;
	}

}
