package controller;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class GameController extends StateBasedGame {
	private StartMenuController startMenuController;
	private InGameController inGameController;
	private PauseController pauseController;
	private EndOfLevelController endOfLevelController;
	
	public GameController(String name) {
		super(name);
		this.startMenuController = new StartMenuController(this);
		this.inGameController = new InGameController(this);
		this.pauseController = new PauseController(this);
		this.endOfLevelController = new EndOfLevelController(this);
		this.addState(inGameController);
		this.addState(pauseController);
		this.addState(endOfLevelController);
		this.addState(startMenuController);
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.enterState(startMenuController.getID());
	}
	
	public StartMenuController getStartMenuController(){
		return startMenuController;
	}
	
	public InGameController getInGameController(){
		return inGameController;
	}
	
	public PauseController getPauseController(){
		return pauseController;
	}

}
