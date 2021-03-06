package controller;


import model.Game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import utils.SaveUtils;
import view.GameView;

/**
 * 
 * @author Josefin, Martin, Sara, Kino
 *
 */
public class GameController extends StateBasedGame {
	private final Game game;
	private final GameView gameView;
	private final StartMenuController startMenuController;
	private final InGameController inGameController;
	private final PauseMenuController pauseMenuController;
	private final HighScoreStateController highScoreStateController;
	private final Music inGameMusic;
	
	public GameController(final String name) throws SlickException {
		super(name);
		this.inGameMusic = new Music("music/game_music_regular.wav");
		this.inGameController = new InGameController(this);
		this.game = new Game(inGameController.getInGame());
		SaveUtils.init();
		this.startMenuController = new StartMenuController(this);
		this.gameView = new GameView(this.game);
		this.highScoreStateController = new HighScoreStateController(this);
		final NewHighscoreController newHighscoreController = new NewHighscoreController(this);
		this.pauseMenuController = new PauseMenuController(this);
		final EndOfLevelController endOfLevelController = new EndOfLevelController(this);
		final ControlsController controlsController = new ControlsController(this);
		this.addState(startMenuController);
		this.addState(inGameController);
		this.addState(highScoreStateController);
		this.addState(pauseMenuController);
		this.addState(controlsController);
		this.addState(newHighscoreController);
		this.addState(pauseMenuController);
		this.addState(endOfLevelController);
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.enterState(startMenuController.getID());
	}
	
	public StartMenuController getStartMenuController(){
		return startMenuController;
	}
	
	public InGameController getInGameController(){
		return inGameController;
	}
	
	public PauseMenuController getPauseController(){
		return pauseMenuController;
	}

	public HighScoreStateController getHighScoreStateController() {
		return highScoreStateController;
	}

	public Game getGame() {
		return this.game;
	}
	
	public GameView getGameView() {
		return this.gameView;
	}

	public Music getInGameMusic() {
		return inGameMusic;
	}
	
	/**
	 * Allows the change to fullscreen if demanded
	 */
	public void changeFullscreen (GameContainer gc) {
		AppGameContainer agc = (AppGameContainer) gc;
		try {
        	if (gc.isFullscreen()) {
        		agc.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, false);
    			gc.setMouseGrabbed(false);
			} else 	{
				agc.setDisplayMode(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, true);
				gc.setMouseGrabbed(true);
			}
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
