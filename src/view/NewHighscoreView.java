package view;

import java.awt.Font;

import model.Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class NewHighscoreView {
	
	private TextField textField;
	private TrueTypeFont font;
	
	public NewHighscoreView(GameContainer gc) {
		this.font = new TrueTypeFont(new Font("Courier", Font.BOLD, 50), false);
		this.textField = new TextField(gc, font, Game.WINDOW_WIDTH/4, Game.WINDOW_HEIGHT/2, 300, 50);
		this.textField.setMaxLength(8);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {		
		g.setFont(font);
		g.drawString("New highscore: 1337!", Game.WINDOW_WIDTH/4, Game.WINDOW_HEIGHT/4);
		g.drawString("Enter name:", this.textField.getX(), this.textField.getY()-this.textField.getHeight());
		
		//TODO drawString score - spara undan score i en model?
		this.textField.setFocus(true);
		this.textField.render(gc, g);
	}

	public TextField getTextField() {
		return textField;
	}
}
