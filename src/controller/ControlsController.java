package controller;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import view.ControlsView;

public class ControlsController extends BasicGameState {
	
	private ControlsView controlsView;
	private GameController gameController;
	private StateBasedGame sbg;

	public ControlsController(GameController gameController) {
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
		// TODO Auto-generated method stub

	}
	
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ENTER) {
			sbg.enterState(Game.START_MENU);
		}
	}

	@Override
	public int getID() {
		return Game.CONTROLS;
	}

}